package kr.co.no1.LectureController;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import inter.Action;
import inter.ActionForward;
import kr.co.no1.lecture.db.Classes;
import kr.co.no1.lecture.db.Lecture;
import kr.co.no1.lecture.db.LectureDao;

public class LectureLecListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("LectureLecListAction ¡¯¿‘");
		String classCode = request.getParameter("classCode");
		String key = classCode.substring(0, 2);
		System.out.println("key : "+key);
		System.out.println("classCode : "+classCode);
		ActionForward forward = new ActionForward();
		if(key.equals("cc")){
			LectureDao lectureDao = new LectureDao();
			List<Lecture> list = lectureDao.oneClassLectures(classCode);
			Classes classes = lectureDao.selectOneClass(classCode);
			request.setAttribute("list", list);
			request.setAttribute("classes", classes);
			forward.setRedirect(false);
			forward.setPath("/WEB-INF/lecture/lectrueList.jsp");
		}else{
			LectureDao lectureDao = new LectureDao();
			List<Classes> list = lectureDao.packageClassList(classCode);
			Classes classes = lectureDao.selectOneClass(classCode);
			request.setAttribute("list", list);
			request.setAttribute("classes", classes);
			forward.setRedirect(false);
			forward.setPath("/WEB-INF/lecture/classList.jsp");
		}
		return forward;
		
	}

}
