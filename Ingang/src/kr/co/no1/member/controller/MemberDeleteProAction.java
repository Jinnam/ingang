package kr.co.no1.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import inter.Action;
import inter.ActionForward;
import kr.co.no1.member.db.Member;
import kr.co.no1.member.db.MemberDao;

public class MemberDeleteProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Member member=(Member)request.getSession().getAttribute("mLogin");
		String memberId=member.getMemberId();
		String password = request.getParameter("password");
		System.out.println(memberId+"  :  memberId");
		System.out.println(password+"  :  password");
		
		MemberDao memberDao = new MemberDao();
		int result = memberDao.mDelete(memberId, password);
		
		ActionForward forward = new ActionForward();
		if(result==1){
			request.getSession().invalidate();
			System.out.println("Å»Åð·Î ¼¼¼Ç¸¸·á");
			forward.setRedirect(false);
			forward.setPath("/index.jsp");
		}else{
			forward.setRedirect(false);
			forward.setPath("/WEB-INF/member/memberDeleteForm.jsp");
		}
		return forward;
	}

}
