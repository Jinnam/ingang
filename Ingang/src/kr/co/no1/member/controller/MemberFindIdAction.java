package kr.co.no1.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import inter.Action;
import inter.ActionForward;
import kr.co.no1.member.db.MemberDao;

public class MemberFindIdAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String findName = request.getParameter("findName");
		String findPhone = request.getParameter("findPhone");
		
		MemberDao memberDao = new MemberDao();
		String findIdResult = memberDao.mFindId(findName, findPhone);
		System.out.println(findIdResult+ " : findIdResult ");
		request.setAttribute("findIdResult", findIdResult);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/WEB-INF/member/memberFindResult.jsp");
		
		return forward;
	}

}
