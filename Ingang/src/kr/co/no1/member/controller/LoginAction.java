package kr.co.no1.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;

import inter.Action;
import inter.ActionForward;
import kr.co.no1.member.db.Member;
import kr.co.no1.member.db.MemberDao;

public class LoginAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("euc-kr");
		String loginId=request.getParameter("loginId");
		String loginPw=request.getParameter("loginPw");
		
		System.out.println(loginId + "로그인 아이디");
		System.out.println(loginPw + "로그인 비밀번호");
		
		MemberDao memberDao = new MemberDao();
		Member mLogin = memberDao.mLogin(loginId, loginPw);
		System.out.println(mLogin +" : mlogin");
		request.getSession().setAttribute("mLogin", mLogin);
		
		ActionForward forward= new ActionForward();
		forward.setRedirect(false);
		forward.setPath("../top.jsp");
		
		return forward;
	}

}
