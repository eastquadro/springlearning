package com.luv2code.testdb;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

import java.io.PrintWriter;
import java.sql.*;


@WebServlet("/TestDbServlet")
public class TestDbServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        //setup connection
        String user = "hbstudent";
        String pass = "hbstudent";

        String jdbcUrl = "jdbc:postgresql://localhost:5430/postgres?currentSchema=public";
        String driver = "org.postgresql.Driver";

        try{
            PrintWriter out = response.getWriter();
            out.println("Connecting to database: " + jdbcUrl);

            Class.forName(driver);

            Connection myConn = DriverManager.getConnection(jdbcUrl,user,pass);

            out.println("Connection Success!!!");

            myConn.close();

        }catch (Exception e){
            e.printStackTrace();
            throw new ServletException(e);
        }

    }
}
