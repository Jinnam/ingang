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
		String memberId = request.getParameter("memberId");
		MemberDao memberDao = new MemberDao();
		Member member = memberDao.mSelectOne(memberId);
		String phone1 = member.getMemberPhone().substring(0, 3);
		String phone2 = member.getMemberPhone().substring(4, 8);
		String phone3 = member.getMemberPhone().substring(9, 13);
		
		request.setAttribute("member", member);
		request.setAttribute("phone1", phone1);
		request.setAttribute("phone2", phone2);
		request.setAttribute("phone3", phone3);
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/WEB-INF/member/memberUpdateForm.jsp");
		
		
		return forward;
	}

}
