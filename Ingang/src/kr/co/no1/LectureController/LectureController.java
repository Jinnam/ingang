package kr.co.no1.LectureController;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LectureController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("LectureController doGet() 호출");
		doPro(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("LectureController doPost() 호출");
		doPro(request,response);
	}
	protected void doPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("LectureController doPro() 호출");
    	request.setCharacterEncoding("euc-kr");
		String RequestURI=request.getRequestURI();
		System.out.println(RequestURI + "<-- RequestURI");
		String contextPath=request.getContextPath();
		System.out.println(contextPath + "<-- contextPath");
		System.out.println(contextPath.length() + "<-- contextPath.length()");
		String command=RequestURI.substring(contextPath.length());
		System.out.println(command + "<-- command");
		System.out.println("----------LectureController.java----------------");
		System.out.println();
		ActionForward forward = null;
		Action action = null;
		
		//회원리스트
		if(command.equals("/lecture/ClassListAction.le")){
			System.out.println("조건문 /lecture/ClassListActin.le 과정리스트");
			action = new LectureClassListAction();
			try{
				forward=action.execute(request, response);
			}catch(Exception e){
				e.printStackTrace();
			}
		}else if(command.equals("/lecture/LecListAction.le")){
			System.out.println("조건문 /lecture/LecListAction.le 과정리스트");
			action = new LectureLecListAction();
			try{
				forward=action.execute(request, response);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
		
//--- 포워드 할것인가? 리다이렉트 할것인가?
		if(forward != null){
			if(forward.isRedirect()){
				response.sendRedirect(forward.getPath());
			}else{
				RequestDispatcher dispatcher=
						request.getRequestDispatcher(forward.getPath());
				System.out.println(forward.getPath() + "<--- mforward.getPath()[jsp 이동경로]");
				System.out.println();
				dispatcher.forward(request, response);
			}
		}
	}
	

}
