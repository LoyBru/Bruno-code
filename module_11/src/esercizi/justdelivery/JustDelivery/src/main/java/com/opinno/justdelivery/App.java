package com.opinno.justdelivery;

import com.opinno.justdelivery.dao.OrderDao;
import com.opinno.justdelivery.dao.UserDao;
import com.opinno.justdelivery.dao.impl.collections.OrderDaoCollections;
import com.opinno.justdelivery.dao.impl.collections.UserDaoCollections;
import com.opinno.justdelivery.model.Order;
import com.opinno.justdelivery.model.User;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.event.Level;

import java.time.LocalDateTime;

@Slf4j
@Log
public class App {

    public static void main( String[] args ) {
        //log.info viene dalla annotazione @Slf4j e @Log, viene creato dal package di Self4j
        log.info("SYSTEM STARTUP :) ");

        UserDao uDao = new UserDaoCollections();
        OrderDao oDao = new OrderDaoCollections();

        initData(oDao, uDao);
        oDao.printOrders();

        log.info("SYSTEM SHUTDOWN :( ");
    }

    private static void initData(OrderDao oDao, UserDao uDao){
        User u1 = User.builder().name("Name 1").email("email1@gmail.com").build();
        User u2 = User.builder().name("Name 2").email("email2@gmail.com").build();
        User u3 = User.builder().name("Name 3").email("email3@gmail.com").build();

        Order o1 = Order.builder().id(1L).dateTimeOrder(LocalDateTime.now()).user(u1).build();
        Order o2 = Order.builder().id(2L).dateTimeOrder(LocalDateTime.now()).user(u1).build();
        Order o3 = Order.builder().id(3L).dateTimeOrder(LocalDateTime.now()).user(u1).build();
        Order o4 = Order.builder().id(4L).dateTimeOrder(LocalDateTime.now()).user(u1).build();
        Order o5 = Order.builder().id(5L).dateTimeOrder(LocalDateTime.now()).user(u1).build();
        Order o6 = Order.builder().id(6L).dateTimeOrder(LocalDateTime.now()).user(u1).build();

        o1.setUser(u1);
        o2.setUser(u1);
        o3.setUser(u2);
        o4.setUser(u2);
        o5.setUser(u3);
        o6.setUser(u3);

        uDao.saveUser(u1);
        uDao.saveUser(u2);
        uDao.saveUser(u3);

        oDao.saveOrder(o1);
        oDao.saveOrder(o2);
        oDao.saveOrder(o3);
        oDao.saveOrder(o4);
        oDao.saveOrder(o5);
        oDao.saveOrder(o6);
    }
}