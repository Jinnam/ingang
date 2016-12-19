package kr.co.no1.LectureController;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import inter.Action;
import inter.ActionForward;
import kr.co.no1.lecture.db.Classes;
import kr.co.no1.lecture.db.LectureDao;

public class LectureClassListAction implements Action {
	private ArrayList<Classes> list;
	private Classes cl;
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		LectureDao dao = new LectureDao();
		list = dao.classList();
		/*for(int i = 0 ; i<list.size();i++){
			cl = list.get(i);
			System.out.println(cl.getClassCode());
			System.out.println(cl.getInstructorCode());
			System.out.println(cl.getClassName());
		}*/
		request.setAttribute("list", list);
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/WEB-INF/lecture/classList.jsp");
		return forward;
	}

}
