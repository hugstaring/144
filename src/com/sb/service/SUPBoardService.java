package com.sb.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import com.lol.comm.DBConn;
import com.sb.dao.SUPBoardDAO;
import com.sb.dto.SUPBoardDTO;


public class SUPBoardService {
	private static SUPBoardService instance = new SUPBoardService();
	
	private SUPBoardService() {
		
		
		
	}
	
	public static SUPBoardService sbGetBoardService() {
		
		return instance;
		
	}
	
	public List<SUPBoardDTO> sbList(){
		DBConn db = DBConn.getDB();
		Connection conn=null;
		List<SUPBoardDTO> list = null;
		try {
			conn=db.getConn();
			conn.setAutoCommit(false);
			SUPBoardDAO dao = SUPBoardDAO.sbGetBoardDAO();
			list=dao.sbList(conn);
			
			conn.commit();
			
		}catch(SQLException | NamingException e) {
			System.out.println(e);
		}finally {
			if(conn!=null) try {conn.close();} catch(SQLException e) {}
		}
		
		return list;
	}

	public void sbInsert(SUPBoardDTO dto) {
		DBConn db = DBConn.getDB();
		Connection conn = null;
		
		
		
		
		try {
			conn=db.getConn();
			conn.setAutoCommit(false);
			SUPBoardDAO dao = SUPBoardDAO.sbGetBoardDAO();
			dao.sbInsert(conn,dto);
			
			conn.commit();
			
			
		}catch(SQLException | NamingException e) {
			System.out.println(e);
			try {conn.rollback();} catch(Exception e2) {}
			
		}finally {
			if(conn!=null) try {conn.close();} catch(SQLException e) {}
		}
		
		
	}

	public SUPBoardDTO sbDetail(int bno) {
		DBConn db = DBConn.getDB();
		Connection conn = null;
		SUPBoardDTO dto = null;
		try {
			conn= db.getConn();
			conn.setAutoCommit(false);
			SUPBoardDAO dao = SUPBoardDAO.sbGetBoardDAO();
			dto=dao.sbDetail(conn,bno);
			
			conn.commit();
			
		}catch(SQLException| NamingException e) {
			System.out.println(e);
			try {conn.rollback();} catch(Exception e2) {}
		}finally {
			if(conn!=null) try {conn.close();} catch(SQLException e) {}
		}
		
		return dto;
	}

	public void sbDelete(int bno) {
		DBConn db = DBConn.getDB();
		Connection conn = null;
		
		try {
			conn= db.getConn();
			conn.setAutoCommit(false);
			SUPBoardDAO dao = SUPBoardDAO.sbGetBoardDAO();
			dao.sbDelete(conn,bno);
			
			conn.commit();
			
		}catch(SQLException| NamingException e) {
			System.out.println(e);
			try {conn.rollback();} catch(Exception e2) {}
		}finally {
			if(conn!=null) try {conn.close();} catch(SQLException e) {}
		}
		
		
		
	}

	public void sbUpdate(SUPBoardDTO dto) {
		DBConn db = DBConn.getDB();
		Connection conn=null;
		
		try {
			conn=db.getConn();
			conn.setAutoCommit(false);
			SUPBoardDAO dao = SUPBoardDAO.sbGetBoardDAO();
			dao.sbUpdate(conn,dto);
			
			conn.commit();
		}catch(SQLException | NamingException e) {
			System.out.println(e);
			try {conn.rollback();} catch(Exception e2) {}
		}finally {
			if(conn!=null) try {conn.close();} catch(SQLException e) {}
		}
	
		
	}
	
	
	
}