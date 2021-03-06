package kr.co.no1.lecture.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import inter.Action;
import inter.ActionForward;
import kr.co.no1.instructor.db.Instructor;
import kr.co.no1.instructor.db.InstructorDao;

public class ClassInsertFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("ClassInsertFormAction ����");
		InstructorDao instructorDao = new InstructorDao();
		List<Instructor> instructorList = instructorDao.instructorList();
		request.setAttribute("instructorList", instructorList);
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/WEB-INF/lecture/classInsertForm.jsp");
		return forward;
	}
}
