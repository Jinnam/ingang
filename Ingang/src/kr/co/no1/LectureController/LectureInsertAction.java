package kr.co.no1.LectureController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import inter.Action;
import inter.ActionForward;

public class LectureInsertAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("LectureInsertAction ¡¯¿‘");
		String classCode = "";
		
		
		request.setAttribute("classCode", classCode);
		ActionForward forward = new ActionForward();
		forward.setPath("/lecture/LecListAction.le");
		return forward;
	}

}
