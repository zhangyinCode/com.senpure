package com.senpure.learn.derby;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by Administrator on 2017/1/6.
 */
public class Test {
    private static String driver = "org.apache.derby.jdbc.EmbeddedDriver";
    private static String protocol = "jdbc:derby:";
    public static void main(String[] args) throws Exception {

        Class.forName(driver).newInstance();
        Connection connection = DriverManager.getConnection(protocol+"D:\\derby\\first");


        System.out.println(connection);


    }
}
