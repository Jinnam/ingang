package kr.co.no1.lecture.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.j256.simplemagic.ContentInfo;
import com.j256.simplemagic.ContentInfoUtil;

import inter.Action;
import inter.ActionForward;
import kr.co.no1.lecture.db.Lecture;
import kr.co.no1.lecture.db.LectureDao;


public class LectureInsertAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("LectureInsertAction 진입");
		request.setCharacterEncoding("euc-kr");
		Lecture lecture = new Lecture();
		String classCode = request.getParameter("classCode");
		lecture.setClassCode(request.getParameter("classCode"));
		lecture.setLectureName(request.getParameter("lectureName"));
		lecture.setLectureDetail(request.getParameter("lectureDetail"));
		System.out.println("lectureName:"+request.getParameter("lectureName"));
				
		
		//파일 업로드
		Part part = request.getPart("lectureFile");
		System.out.println("part : "+part);
		InputStream inputStream = part.getInputStream();
		
		String dir = request.getServletContext().getRealPath("/img/");
		System.out.println("dir:"+dir);
        String filename = UUID.randomUUID().toString().replace("-", "");
		String fileType = "";
		String ext = "";
		
        ContentInfoUtil util = new ContentInfoUtil();
		try {
			ContentInfo info;

			info = util.findMatch(inputStream);
			if (info == null) {
				System.out.println(" Unknown content-type");
			}

			System.out.println(" ContentType : " + info.getName());
			System.out.println(" MimeType : " + info.getMimeType());
			
			fileType = info.getName();

			//해당 mime 타입의 모든 확장자 가져오는 메서드
			/*
			String[] extensions = info.getFileExtensions();
			
			if (extensions != null && extensions.length > 0) {
				for (int j = 0; j < extensions.length; j++) {
					System.out.println(" File Extension " + j + " : "
							+ extensions[j]);
				}
			}*/
		} catch (IOException e) {
			e.printStackTrace();
		}
        
		switch(fileType){
			case "jpeg" :
				ext = ".jpg";
				break;
			case "png" :
				ext = ".png";
				break;
			case "gif" :
				ext = ".gif";
			case "mp4a" :
				ext = ".mp4";
			default : break;
		}
		part.write(dir+"/"+filename+ext);
		
		lecture.setLectureFile(filename+ext);
		
		
		LectureDao lectureDao = new LectureDao();
		int rowCount = lectureDao.lectureInsert(lecture);
		if(rowCount != 0){
			System.out.println("강의 등록	 성공^^");
		}else {
			System.out.println("강의 등록 실패 ..ㅠㅠ");
		}
		ActionForward forward = new ActionForward();
		forward.setRedirect(true);
		forward.setPath(request.getContextPath()+"/lecture/LecListAction.le?classCode="+classCode);
		return forward;
	}

}
