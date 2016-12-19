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
		
		//���̵� �޾Ƽ� member�� ����
		member.setMemberId(request.getParameter("id"));
		
		//�̸� �޾Ƽ� ����
		member.setMemberName(request.getParameter("name"));
		
		//����
		member.setMemberBirth(Integer.parseInt(request.getParameter("birth")));
		
		//��ȭ��ȣ
		String phone = request.getParameter("phone1")+"-"+request.getParameter("phone2")+"-"+request.getParameter("phone3");
		member.setMemberPhone(phone);
		
		//gender
		member.setMemberGender(request.getParameter("gender"));
		
		//�ּ�
		member.setMemberAddr(request.getParameter("addr"));
		
		//��й�ȣ�� ���üũ �޾Ƽ� �� �� member�� ����
		member.setMemberPw(request.getParameter("password"));
		
	
		
		MemberDao memberDao = new MemberDao();
		memberDao.mInsert(member);
		
		ActionForward forward= new ActionForward();
		forward.setRedirect(false);
		forward.setPath("");
		
		return forward;
	}

}
