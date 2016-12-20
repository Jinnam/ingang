package kr.co.no1.member.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import inter.Action;
import inter.ActionForward;
import kr.co.no1.member.db.Member;
import kr.co.no1.member.db.MemberDao;

public class MemberUpdateFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("euc-kr");
	//	String memberId = request.getParameter("memberId");
		MemberDao memberDao = new MemberDao();
		Member member = memberDao.mSelectOne("id001");
		
		request.setAttribute("member", member);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/WEB-INF/member/memberUpdateForm.jsp");
		
		
		return forward;
	}

}
