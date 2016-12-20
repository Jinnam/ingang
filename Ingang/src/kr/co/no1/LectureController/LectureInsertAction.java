package kr.co.no1.LectureController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import inter.Action;
import inter.ActionForward;
import kr.co.no1.instructor.db.Instructor;
import kr.co.no1.lecture.db.Classes;
import kr.co.no1.lecture.db.LectureDao;

public class LectureInsertAction implements Action {
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("LectureInsertAction 진입");
		request.setCharacterEncoding("euc-kr");
		Classes classes = new Classes();
		Instructor instructor = new Instructor();
		instructor.setInstructorCode(request.getParameter("instructorCode"));
		classes.setInstructor(instructor);
		classes.setClassName(request.getParameter("className"));
		classes.setClassLevel(request.getParameter("classLevel"));
		classes.setClassCategory(request.getParameter("classCategory"));
		classes.setClassPeoriod(Integer.parseInt(request.getParameter("classPeoriod")));
		classes.setClassPrice(Integer.parseInt(request.getParameter("classPrice")));
		classes.setDiscount(Integer.parseInt(request.getParameter("discount")));
		classes.setClassDetail(request.getParameter("classDetail"));
		System.out.println("classes : "+classes);
		LectureDao lectureDao = new LectureDao();
		int rowCount = lectureDao.classInsert(classes);
		System.out.println("rowCount : "+rowCount);
		ActionForward forward = new ActionForward();
		if(rowCount != 0){
			System.out.println("과정등록 성공 ^^");
			forward.setRedirect(true);
			forward.setPath(request.getContextPath()+"/lecture/ClassListAction.le");
		}else {
			System.out.println("과정등록 실패 ㅠㅠ");
		}
		return forward;
	}
}
