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
		
		//회원가입 폼
		if(command.equals("/member/InsertForm.me")){
			forward=new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/WEB-INF/member/InsertForm.jsp");
		}
		//회원가입 액션
		else if(command.equals("/member/InsertAction.me")){
			action = new MemberInsertAction();
			try{
				forward = action.execute(request, response);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		//로그인 폼 이동
		else if(command.equals("/login/Login.me")){
			forward=new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/WEB-INF/login/login.jsp");
		}
		//로그인 처리 후 session생성
		else if(command.equals("/login/LoginAction.me")){
			action = new LoginAction();
			try{
				forward = action.execute(request, response);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		//로그아웃
		else if(command.equals("/login/logoutAction.me")){
			action = new LogoutAction();
			try{
				forward = action.execute(request, response);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		//아이디 찾기 폼
		else if(command.equals("/member/FindIdForm.me")){
			forward=new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/WEB-INF/member/memberFindIdForm.jsp");
		}
		//아이디찾기 액션
		else if(command.equals("/member/FindIdAction.me")){
			action = new MemberFindIdAction();
			try{
				forward = action.execute(request, response);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		//삭제 화면
	/*	else if(command.equals("/login/LoginAction.me")){
			
		}
*/		
		
		//회원 검색 폼
		else if(command.equals("/member/SearchForm.me")){
			forward = new ActionForward();
			forward.setPath("/WEB-INF/member/memberSearchForm.jsp");
			forward.setRedirect(false);	
		}//회원 검색 액션
		else if(command.equals("/member/SearchAction.me")){
			action = new MemberSearchFormAction();
			try{
				forward = action.execute(request, response);
			}catch(Exception e){
				e.printStackTrace();
			}
		}//회원 정보 수정 폼
		else if(command.equals("/member/UpdateForm.me")){
			action = new MemberUpdateFormAction();
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
