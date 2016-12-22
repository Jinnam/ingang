package kr.co.no1.member.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
	//아이디 찾기
	public String mFindId(String name, String phone){
		String result=null;
		String sql = "SELECT MEMBER_ID FROM MEMBER WHERE MEMBER_NAME=? AND MEMBER_PHONE=?";
		try{
			con=ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, phone);
			rs = pstmt.executeQuery();
			if(rs.next()){
				result = rs.getString("MEMBER_ID");
				System.out.println(result +" : result");
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(rs!=null) try{rs.close();}catch(SQLException ex){}
			if(pstmt!=null) try{pstmt.close();}catch(SQLException ex){}
			if(con!=null) try{con.close();}catch(SQLException ex){}	
		}
		return result;
	}
	
	
	//로그인 1명 정보가져오기
	public Member mLogin(String loginId, String loginPw){
		Member member=null;
		String sql = "SELECT MEMBER_ID, MEMBER_PW, MEMBER_LEVEL, MEMBER_NAME FROM MEMBER "
				+ "WHERE MEMBER_ID=?";
		try{
			con = ds.getConnection();
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, loginId);
			rs = pstmt.executeQuery();
			if(rs.next()){
				if(loginPw.equals(rs.getString("MEMBER_PW"))){
					member = new Member();
					member.setMemberId(rs.getString("MEMBER_ID"));
					member.setMemberLevel(rs.getString("MEMBER_LEVEL"));
					member.setMemberName(rs.getString("MEMBER_NAME"));
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(rs!=null) try{rs.close();}catch(SQLException ex){}
			if(pstmt!=null) try{pstmt.close();}catch(SQLException ex){}
			if(con!=null) try{con.close();}catch(SQLException ex){}	
		}
		return member;
	}
	//수정
	public String mUpdate(Member member){
		String sql = "UPDATE MEMBER SET MEMBER_PW=?, MEMBER_NAME=?, MEMBER_BIRTH=?, MEMBER_PHONE=?, MEMBER_GENDER=?, MEMBER_ADDR=? WHERE MEMBER_ID=?";
		int result=-1;
		String memberId=null;
		System.out.println(member + " : : :member");
		try{
			con = ds.getConnection();
			pstmt=con.prepareStatement(sql);
			System.out.println(pstmt+" : pstmt update");
			pstmt.setString(1, member.getMemberPw());
			pstmt.setString(2, member.getMemberName());
			pstmt.setInt(3, member.getMemberBirth());
			pstmt.setString(4, member.getMemberPhone());
			pstmt.setString(5, member.getMemberGender());
			pstmt.setString(6, member.getMemberAddr());
			pstmt.setString(7, member.getMemberId());
			result = pstmt.executeUpdate();
			if(result ==1){
				memberId =member.getMemberId();
			}

		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(pstmt!=null) try{pstmt.close();}catch(SQLException ex){}
			if(con!=null) try{con.close();}catch(SQLException ex){}
		}
		return memberId;
	
		
	}
	
	
	
	//한명 정보 가져오기
	public Member mSelectOne(String memberId){
		Member member=null;
		String sql="SELECT MEMBER_ID, MEMBER_PW, MEMBER_NAME, MEMBER_BIRTH,"
				+ " MEMBER_PHONE, MEMBER_GENDER, MEMBER_ADDR, MEMBER_RD, "
				+ "MEMBER_LEVEL FROM MEMBER WHERE MEMBER_ID=?";
		try{
			con = ds.getConnection();
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, memberId);
			rs = pstmt.executeQuery();
			if(rs.next()){
				member = new Member();
				member.setMemberId(rs.getString("MEMBER_ID"));
				member.setMemberPw(rs.getString("MEMBER_PW"));
				member.setMemberName(rs.getString("MEMBER_NAME"));
				member.setMemberBirth(rs.getInt("MEMBER_BIRTH"));
				member.setMemberPhone(rs.getString("MEMBER_PHONE"));
				member.setMemberGender(rs.getString("MEMBER_GENDER"));
				member.setMemberAddr(rs.getString("MEMBER_ADDR"));
				member.setMemberRd(rs.getString("MEMBER_RD"));
				member.setMemberLevel(rs.getString("MEMBER_LEVEL"));;
			}
		}catch(Exception e){
			e.printStackTrace();
			
		}finally{
			if(rs!=null) try{rs.close();}catch(SQLException ex){}
			if(pstmt!=null) try{pstmt.close();}catch(SQLException ex){}
			if(con!=null) try{con.close();}catch(SQLException ex){}
		}
		return member;
	}
	
	//전체회원 목록
	public List<Member> mSelectAll(){
		Member member=null;
		List<Member> arm = new ArrayList<Member>();
		String sql="SELECT MEMBER_ID, MEMBER_PW, MEMBER_NAME, MEMBER_BIRTH,"
				+ " MEMBER_PHONE, MEMBER_GENDER, MEMBER_ADDR, MEMBER_RD, "
				+ "MEMBER_LEVEL FROM MEMBER";
		System.out.println(sql+" : mSelectAll sql");
		try{
			con = ds.getConnection();
			pstmt=con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			System.out.println(rs+" : rs mSelectAll");
			while(rs.next()){
				member = new Member();
				member.setMemberId(rs.getString("MEMBER_ID"));
				member.setMemberPw(rs.getString("MEMBER_PW"));
				member.setMemberName(rs.getString("MEMBER_NAME"));
				member.setMemberBirth(rs.getInt("MEMBER_BIRTH"));
				member.setMemberPhone(rs.getString("MEMBER_PHONE"));
				member.setMemberGender(rs.getString("MEMBER_GENDER"));
				member.setMemberAddr(rs.getString("MEMBER_ADDR"));
				member.setMemberRd(rs.getString("MEMBER_RD"));
				member.setMemberLevel(rs.getString("MEMBER_LEVEL"));
				arm.add(member);
			}
		}catch(Exception e){
			e.printStackTrace();
			
		}finally{
			if(rs!=null) try{rs.close();}catch(SQLException ex){}
			if(pstmt!=null) try{pstmt.close();}catch(SQLException ex){}
			if(con!=null) try{con.close();}catch(SQLException ex){}
		}
		return arm;
	}
	
	
	//Member Insert
	public int mInsert(Member member){
		String sql = "INSERT INTO MEMBER("
				+ "MEMBER_ID, MEMBER_PW, MEMBER_NAME, MEMBER_BIRTH,"
				+ " MEMBER_PHONE,MEMBER_GENDER,MEMBER_ADDR,MEMBER_RD,"
				+ "MEMBER_LEVEL) VALUES (?,?,?,?,?,?,?,(TO_DATE(SYSDATE,'YY/MM/DD')),'member')";
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
