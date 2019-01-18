package com.luv2code.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:postgresql://localhost:5430/postgres?currentSchema=hb_01_one_to_one_uni";
        String user = "hbstudent";
        String pass = "hbstudent";

        try {
            System.out.println("Connecting to DB" + jdbcUrl);
            Connection myConn = DriverManager.getConnection(jdbcUrl,user,pass);
            System.out.println(myConn);

            System.out.println("Connection complete");

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
