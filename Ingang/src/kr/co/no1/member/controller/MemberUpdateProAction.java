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
		System.out.println("MemberUpdateProAction ����");
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
			gender="��";
		}else if(request.getParameter("gender").equals("woman")){
			gender="��";
		}
		member.setMemberGender(gender);
		member.setMemberAddr(request.getParameter("addr"));
		
		//������Ʈ ����
		MemberDao memberDao = new MemberDao();
		String returnId = memberDao.mUpdate(member);
		System.out.println(returnId+ " : returnId");
		//���ǿ��� ���̵� ��������
		Member memberSession=(Member)request.getSession().getAttribute("mLogin");
		
		//������ ID���� ������Ʈ �Ҷ��� ID���� �� �� �������� ����/���ο� ���� ����
		if(memberSession.getMemberId().equals(returnId)){
			//request.getSession().invalidate();���� ���� ���ص� ��. ���� ���
			request.getSession().setAttribute("mLogin", member);
		}
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/index.jsp");
		
		return forward;
	}

}
