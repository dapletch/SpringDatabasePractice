package com.spring.jdbc;

import com.spring.jdbc.dao.IpAddressLocationDao;
import com.spring.jdbc.ipaddresslocation.IpAddressLocation;
import com.spring.jdbc.jdbcproperties.JdbcConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(JdbcConfiguration.class);
        IpAddressLocationDao ipAddressLocationDao = context.getBean(IpAddressLocationDao.class);

        List<IpAddressLocation> ipAddressLocationList = ipAddressLocationDao.getIpAddressList();
        for (IpAddressLocation ipAddressLocation : ipAddressLocationList) {
            System.out.println(ipAddressLocation.toString());
        }
    }
}
