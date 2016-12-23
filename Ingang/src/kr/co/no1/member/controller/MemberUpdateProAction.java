package kr.co.no1.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import inter.Action;
import inter.ActionForward;
import kr.co.no1.member.db.Member;
import kr.co.no1.member.db.MemberDao;

public class MemberUpdateProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("MemberUpdateProAction 진입");
		request.setCharacterEncoding("euc-kr");
		Member member = new Member();
		member.setMemberId(request.getParameter("memberId"));
		member.setMemberPw(request.getParameter("password"));
		member.setMemberName(request.getParameter("name"));
		member.setMemberBirth(Integer.parseInt(request.getParameter("birth")));
		String memberPhone=request.getParameter("phone1")+"-"+request.getParameter("phone2")+"-"+request.getParameter("phone3");
		member.setMemberPhone(memberPhone);
		//gender
		String gender = "";
		if(request.getParameter("gender").equals("man")){
			gender="남";
		}else if(request.getParameter("gender").equals("woman")){
			gender="여";
		}
		member.setMemberGender(gender);
		member.setMemberAddr(request.getParameter("addr"));
		
		//업데이트 실행
		MemberDao memberDao = new MemberDao();
		String returnId = memberDao.mUpdate(member);
		System.out.println(returnId+ " : returnId");
		//세션에서 아이디값 가져오기
		Member memberSession=(Member)request.getSession().getAttribute("mLogin");
		
		//세션의 ID값과 업데이트 할때의 ID값을 비교 후 기존세션 만료/새로운 세션 생성
		if(memberSession.getMemberId().equals(returnId)){
			//request.getSession().invalidate();세션 만료 안해도 됨. 세션 덮어씀
			request.getSession().setAttribute("mLogin", member);
		}
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/index.jsp");
		
		return forward;
	}

}
