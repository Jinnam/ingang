package kr.co.no1.LectureController;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import inter.Action;
import inter.ActionForward;
import kr.co.no1.instructor.db.Instructor;
import kr.co.no1.instructor.db.InstructorDao;

public class LectureInsertFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		InstructorDao instructorDao = new InstructorDao();
		List<Instructor> list = instructorDao.instructorList();
		
		return null;
	}

}
