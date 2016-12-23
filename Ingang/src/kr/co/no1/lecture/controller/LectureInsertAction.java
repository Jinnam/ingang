package kr.co.no1.lecture.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import inter.Action;
import inter.ActionForward;
import kr.co.no1.lecture.db.Lecture;
import kr.co.no1.lecture.db.LectureDao;

public class LectureInsertAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("LectureInsertAction 진입");
		Lecture lecture = new Lecture();
		String classCode = request.getParameter("classCode");
		lecture.setClassCode(request.getParameter("classCode"));
		lecture.setLectureName(request.getParameter("lectureName"));
		lecture.setLectureDetail(request.getParameter("lectureDetail"));
		
		LectureDao lectureDao = new LectureDao();
		int rowCount = lectureDao.lectureInsert(lecture);
		if(rowCount != 0){
			System.out.println("강의 등록 성공^^");
		}else {
			System.out.println("강의 등록 실패 ..ㅠㅠ");
		}
		request.setAttribute("classCode", classCode);
		ActionForward forward = new ActionForward();
		forward.setPath("/lecture/LecListAction.le");
		return forward;
	}

}
