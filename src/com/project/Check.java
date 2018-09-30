package com.project;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/Check")
public class Check extends HttpServlet {
	private static final long serialVersionUID = 1L;

   
    public Check() {
       
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String st1=request.getParameter("id");
		String st2=request.getParameter("pwd");
		String call=request.getParameter("call");
		String s="login";
		System.out.println(call);
		
		response.setContentType("text/html");
		PrintWriter p=response.getWriter();
		
		HttpSession session=request.getSession();
		DaoLayer obj;
		if(session.getAttribute("mode")=="Register")		//check which page is calling
		{
			int marks=Integer.parseInt(request.getParameter("marks"));
			obj=DaoLayer.setData(st1,st2,marks);
		}
		else if(call.equals(s))
			{
				session.setAttribute("mode", "login");
				obj=(DaoLayer)DaoLayer.setData(st1, st2);
			}
		else
			{
				session.setAttribute("mode","delete");
				obj=DaoLayer.delData(st1,st2);
			}
		
		session.setAttribute("user",st1);
		session.setAttribute("obj", obj);
		
		RequestDispatcher rd=request.getRequestDispatcher("Access.jsp");
		rd.forward(request, response);

		
		/*
		if(st1.equals("Rahul") && st2.equals("Jaswal"))
		{
			//response.sendRedirect("Access.jsp");
			HttpSession session =request.getSession();
			session.setAttribute("user",st1);
			
			RequestDispatcher rd=request.getRequestDispatcher("Access.jsp");
			rd.include(request, response);	//or we can use forward method
			p.print("We are back in servlet");
		}
		else
		{
			
			response.sendRedirect("join.html");
			p.println("Wrong userId/password!");
		}*/
			
	}
}

