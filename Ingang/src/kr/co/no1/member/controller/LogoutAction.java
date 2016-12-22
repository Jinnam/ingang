package kr.co.no1.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import inter.Action;
import inter.ActionForward;

public class LogoutAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("action logout ����");
		if(request.getSession().getAttribute("mLogin") != null){
			request.getSession().invalidate();
			System.out.println("session ����");
		}
	
		ActionForward forward= new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/index.jsp");
		return forward;
	}

}
