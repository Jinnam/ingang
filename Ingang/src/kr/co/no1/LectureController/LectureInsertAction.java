package kr.co.no1.LectureController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import inter.Action;
import inter.ActionForward;
import kr.co.no1.lecture.db.Classes;
import kr.co.no1.lecture.db.LectureDao;

public class LectureInsertAction implements Action {
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("LectureInsertAction ¡¯¿‘");
		request.setCharacterEncoding("euc-kr");
		Classes classes = new Classes();
		classes.setClassName(request.getParameter("className"));
		classes.setClassLevel(request.getParameter("classLevel"));
		classes.setClassCategory(request.getParameter("classCategory"));
		classes.setClassPeoriod(Integer.parseInt(request.getParameter("classPeoriod")));
		classes.setClassPrice(Integer.parseInt(request.getParameter("classPrice")));
		classes.setDiscount(Integer.parseInt(request.getParameter("discount")));
		classes.setClassDetail(request.getParameter("classDetail"));
		LectureDao lectureDao = new LectureDao();
		lectureDao.classInsert(classes);
		
		
		return null;
	}
}
