package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bin.emp_bo;
import com.dao.emp_dao;

/**
 * Servlet implementation class signup_controller
 */
@WebServlet("/signup_controller")
public class signup_controller extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public signup_controller() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();

        try {
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String phone = request.getParameter("phone");
            String password = request.getParameter("password");


            emp_bo em = new emp_bo();
            em.setName(name);
            em.setEmail(email);
            em.setPhone(phone);
            em.setPassword(password);

            int status = emp_dao.signup(em);

            if (status > 0) 
            {
                pw.println("Signup successful.");
            } 
            else 
            {
                pw.println("Something went wrong during signup.");
            }
        } 
        catch (Exception e) 
        {

            pw.println("Error occurred: " + e.getMessage());
        }
    }
}
