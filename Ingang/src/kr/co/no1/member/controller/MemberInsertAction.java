package kr.co.no1.member.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import inter.Action;
import inter.ActionForward;
import kr.co.no1.member.db.Member;
import kr.co.no1.member.db.MemberDao;

public class MemberInsertAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("euc-kr");
		System.out.println("ActionForward InsertAction");
		Member member = new Member();
		
		//아이디 받아서 member에 셋팅
		member.setMemberId(request.getParameter("id"));
		
		//이름 받아서 셋팅
		member.setMemberName(request.getParameter("name"));
		
		//생일
		member.setMemberBirth(Integer.parseInt(request.getParameter("birth")));
		
		//전화번호
		String phone = request.getParameter("phone1")+"-"+request.getParameter("phone2")+"-"+request.getParameter("phone3");
		member.setMemberPhone(phone);
		
		//gender
		String gender = "";
		if(request.getParameter("gender").equals("man")){
			gender="남";
		}else if(request.getParameter("gender").equals("woman")){
			gender="여";
		}
		member.setMemberGender(gender);

		
		//주소
		member.setMemberAddr(request.getParameter("addr"));
		
		//비밀번호 셋팅
		member.setMemberPw(request.getParameter("password"));
		
	
		
		MemberDao memberDao = new MemberDao();
		memberDao.mInsert(member);
		
		ActionForward forward= new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/index.jsp");
		
		return forward;
	}

}
