package kr.co.no1.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import inter.Action;
import inter.ActionForward;


public class MemberController extends HttpServlet {

	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String RequestURI=request.getRequestURI();
		String contextPath=request.getContextPath();
		String command=RequestURI.substring(contextPath.length());
		System.out.println(RequestURI + "<-- RequestURI BoardFrontController.java");
		System.out.println(contextPath + "<-- contextPath BoardFrontController.java");
		System.out.println(command + "<-- command BoardFrontController.java");
		System.out.println("----BoardFrontController.java ----- ");
		System.out.println();
		ActionForward forward=null;
		Action action=null;
		
		if(command.equals("/member/InsertForm.me")){
			forward=new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/WEB-INF/member/InsertForm.jsp");
		}else if(command.equals("/member/InsertAction.me")){
			action = new MemberInsertAction();
			try{
				forward = action.execute(request, response);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
		if(forward != null){
			if(forward.isRedirect()){
				response.sendRedirect(forward.getPath());
			   }else{
				   RequestDispatcher dispatcher=
					   request.getRequestDispatcher(forward.getPath());
				   dispatcher.forward(request, response);
			   }
			   }
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet 돌입!");
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost 돌입!");
		doProcess(request, response);
		
	}

}
