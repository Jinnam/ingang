package kr.co.no1.LectureController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import inter.Action;
import inter.ActionForward;
import kr.co.no1.lecture.db.Classes;
import kr.co.no1.lecture.db.LectureDao;

public class LectureInsertFormAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String classCode = request.getParameter("classCode");
		System.out.println("classCode : "+classCode);
		LectureDao lectureDao = new LectureDao();
		Classes classes = lectureDao.selectOneClass(classCode);
		
		request.setAttribute("classes", classes);
		ActionForward forward = new ActionForward();
		forward.setPath("/WEB-INF/lecture/lectureInsertForm.jsp");
		return forward;
	}

}
