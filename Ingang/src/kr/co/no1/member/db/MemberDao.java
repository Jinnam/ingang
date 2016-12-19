package kr.co.no1.member.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDao {
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	DataSource ds;
	public MemberDao() {
		try{
			Context init = new InitialContext();
	  		ds = 
	  			(DataSource) init.lookup("java:comp/env/jdbc/OracleDB");
		}catch(Exception ex){
			System.out.println("DB 연결 실패 : " + ex);
			return;
		}
		
	}
	
	public int mInsert(Member member){
		String sql = "INSERT INTO MEMBER("
				+ "MEMBER_ID, MEMBER_PW, MEMBER_NAME, MEMBER_BIRTH,"
				+ " MEMBER_PHONE,MEMBER_GENDER,MEMBER_ADDR,MEMBER_RD,"
				+ "MEMBER_LEVEL) VALUES (?,?,?,?,?,?,?,SYSDATE,'member')";
		int result=-1;
		
		try{
			con = ds.getConnection();
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, member.getMemberId());
			pstmt.setString(2, member.getMemberPw());
			pstmt.setString(3, member.getMemberName());
			pstmt.setInt(4, member.getMemberBirth());
			pstmt.setString(5, member.getMemberPhone());
			pstmt.setString(6, member.getMemberGender());
			pstmt.setString(7, member.getMemberAddr());
			result = pstmt.executeUpdate();
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(pstmt!=null) try{pstmt.close();}catch(SQLException ex){}
			if(con!=null) try{con.close();}catch(SQLException ex){}
		}
		return result;
	}
}
