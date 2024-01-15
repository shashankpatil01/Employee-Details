package com.controller;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bin.emp_bo;
import com.dao.emp_dao;
import com.controller.*;

/**
 * Servlet implementation class fatching_handler
 */
@WebServlet("/fatching_handler")
public class fatching_handler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public fatching_handler() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
        PrintWriter pw= response.getWriter();
        
        pw.println("<h1>EMPLOYEE DETAILS</h1>");
        
        pw.println("<table border='2px'>");
          
           pw.println("<tr> <th>ID </th> <th> NAME </th> <th>EMAIL</th> <th> PHONE </th> <th> PASSWORD </th> </tr>");
        
            List<emp_bo>list= emp_dao.getAllEmployee();
            
            for(emp_bo el:list)
            {
              pw.println("<tr> <td>"+el.getId()+"</td> <td>"+ el.getName()+"</td> <td>"+el.getEmail()+"</td> <td>"+ el.getPhone()+"</td> <td>"+ el.getPassword()+" </td> </tr>");
                 
            }
           
           
           
        pw.println("</table>");
	}
}