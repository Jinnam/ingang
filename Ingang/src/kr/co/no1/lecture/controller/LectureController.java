package kr.co.no1.lecture.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import inter.Action;
import inter.ActionForward;

public class LectureController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("LectureController doGet() ȣ��");
		doPro(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("LectureController doPost() ȣ��");
		doPro(request,response);
	}
	protected void doPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("LectureController doPro() ȣ��");
    	request.setCharacterEncoding("euc-kr");
		String RequestURI=request.getRequestURI();
		System.out.println(RequestURI + "<-- RequestURI");
		String contextPath=request.getContextPath();
		System.out.println(contextPath + "<-- contextPath");
		System.out.println(contextPath.length() + "<-- contextPath.length()");
		String command=RequestURI.substring(contextPath.length());
		System.out.println(command + "<-- command");
		System.out.println("----------LectureController.java----------------");
		ActionForward forward = null;
		Action action = null;
		
		//���� ����Ʈ
		if(command.equals("/lecture/ClassListAction.le")){
			System.out.println("���ǹ� /lecture/ClassListActin.le ��������Ʈ");
			action = new LectureClassListAction();
			try{
				forward=action.execute(request, response);
			}catch(Exception e){
				e.printStackTrace();
			}
			
		//���� ����Ʈ
		}else if(command.equals("/lecture/LecListAction.le")){
			System.out.println("���ǹ� /lecture/LecListAction.le ���Ǹ���Ʈ");
			action = new LectureLecListAction();
			try{
				forward=action.execute(request, response);
			}catch(Exception e){
				e.printStackTrace();
			}
		
		//���� ��� ��
		}else if(command.equals("/lecture/ClassInsertFormAction.le")){
			System.out.println("���ǹ� /lecture/ClassInsertFormAction.le �����߰� ��");
			action = new ClassInsertFormAction();
			try{
				forward=action.execute(request, response);
			}catch(Exception e){
				e.printStackTrace();
			}
			
		//���� ��� ����
		}else if(command.equals("/lecture/ClassInsertAction.le")){
			System.out.println("���ǹ� /lecture/ClassInsertAction.le �����߰�");
			action = new ClassInsertAction();
			try{
				forward=action.execute(request, response);
			}catch(Exception e){
				e.printStackTrace();
			}
		
		//���� ��� ��
		}else if(command.equals("/lecture/LectureInsertFormAction.le")){
			System.out.println("���ǹ� /lecture/LectureInsertFormAction.le �����߰� ��");
			action = new LectureInsertFormAction();
			try{
				forward=action.execute(request, response);
			}catch(Exception e){
				e.printStackTrace();
			}
		
			
		//���� ���
		}else if(command.equals("/lecture/LectureInsertAction.le")){
			System.out.println("���ǹ� /lecture/LectureInsertAction.le �����߰� ��");
			action = new LectureInsertAction();
			try{
				forward=action.execute(request, response);
			}catch(Exception e){
				e.printStackTrace();
			}
		
		}
		
		
		
		
		
		
		
		
		
//--- ������ �Ұ��ΰ�? �����̷�Ʈ �Ұ��ΰ�?
		if(forward != null){
			if(forward.isRedirect()){
				response.sendRedirect(forward.getPath());
			}else{
				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
				System.out.println(forward.getPath() + "<--- forward.getPath()[jsp �̵����]");
				System.out.println();
				dispatcher.forward(request, response);
			}
		}
	}
	

}