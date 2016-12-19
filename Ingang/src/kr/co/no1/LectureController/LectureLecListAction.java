package kr.co.no1.LectureController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import inter.Action;
import inter.ActionForward;
import kr.co.no1.lecture.db.LectureDao;

public class LectureLecListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("LectureLecListAction ¡¯¿‘");
		String classCode = request.getParameter("classCode");
		System.out.println(classCode);
		LectureDao lectureDao = new LectureDao();
		lectureDao.oneClassLectures(classCode);
		
		return null;
		
	}

}
