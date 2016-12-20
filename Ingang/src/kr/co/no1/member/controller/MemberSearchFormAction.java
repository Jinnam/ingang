package kr.co.no1.member.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import inter.Action;
import inter.ActionForward;
import kr.co.no1.member.db.Member;
import kr.co.no1.member.db.MemberDao;

public class MemberSearchFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("euc-kr");
		String searchId = request.getParameter("searchId");
		String searchName = request.getParameter("searchName");
		String birthStart = request.getParameter("birthStart");
		String birthEnd = request.getParameter("birthEnd");
		String phone1 = request.getParameter("phone1");
		String phone2 = request.getParameter("phone2");
		String phone3 = request.getParameter("phone3");
		String gender1 = request.getParameter("gender1");
		String gender2 = request.getParameter("gender2");
		String searchAddr = request.getParameter("searchAddr");
		String rdStart = request.getParameter("rdStart");
		String rdEnd=request.getParameter("rdEnd");
		String levelSelect = request.getParameter("levelSelect");
		
		MemberDao memberDao = new MemberDao();
		List<Member> member = memberDao.mSelectAll();
		
		request.setAttribute("member", member);
		
		ActionForward forward= new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/WEB-INF/member/memberList.jsp");
		
		return forward;
		
	}

}
