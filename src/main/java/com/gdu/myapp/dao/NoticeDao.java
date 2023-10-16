package com.gdu.myapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gdu.myapp.dto.NoticeDto;

@Repository
public class NoticeDao {
  
  @Autowired
  private JdbcConnection jdbcConnection;
  
  private Connection conn;
  private PreparedStatement ps;
  private ResultSet rs;
  
  // 전체 리스트 조회
  public List<NoticeDto> getNoticeList() {
    
    List<NoticeDto> list = new ArrayList<NoticeDto>();
    
    try {
      
      conn = jdbcConnection.getConnection();
      String sql = "SELECT NOTICE_NO, GUBUN, TITLE, CONTENT FROM NOTICE_T ORDER BY NOTICE_NO DESC";
      
      ps = conn.prepareStatement(sql);
      rs = ps.executeQuery();
      
      while(rs.next()) {
        
        NoticeDto noticeDto = new NoticeDto();
        noticeDto.setNotice_no(rs.getInt("NOTICE_NO"));
        noticeDto.setGubun(rs.getString("GUBUN"));
        noticeDto.setTitle(rs.getString("TITLE"));
        noticeDto.setContent(rs.getString("CONTENT"));
        
        list.add(noticeDto);
        
      }
      
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      jdbcConnection.close(conn, ps, rs);
    }
    
    return list;
    
  }
  
  // 삽입 메소드
  public int noticeAdd(NoticeDto noticeDto) {
    
    int insertCount = 0;
    
    try {
      
      conn = jdbcConnection.getConnection();
      
      String sql = "";
      sql += "INSERT INTO NOTICE_T(NOTICE_NO, GUBUN, TITLE, CONTENT) VALUES(NOTICE_SEQ.NEXTVAL, ?, ?, ?)";
      ps = conn.prepareStatement(sql);
      ps.setString(1, noticeDto.getGubun());
      ps.setString(2, noticeDto.getTitle());
      ps.setString(3, noticeDto.getContent());
      
      insertCount = ps.executeUpdate();
      
    } catch(Exception e) {
      e.printStackTrace();
    } finally {
      jdbcConnection.close(conn, ps, rs);
    }
    
    return insertCount;
    
  }
  
  // 1개 조회
  public NoticeDto noticeDetail(int notice_no) {
    
    NoticeDto noticeDto = new NoticeDto();
    
    try {
      
      conn = jdbcConnection.getConnection();
      String sql = "SELECT NOTICE_NO, GUBUN, TITLE, CONTENT FROM NOTICE_T WHERE NOTICE_NO=?";
      
      ps = conn.prepareStatement(sql);
      ps.setInt(1, notice_no);
      rs = ps.executeQuery();
      
      while(rs.next()) {
        
        noticeDto.setNotice_no(rs.getInt("NOTICE_NO"));
        noticeDto.setGubun(rs.getString("GUBUN"));
        noticeDto.setTitle(rs.getString("TITLE"));
        noticeDto.setContent(rs.getString("CONTENT"));
        
      }
      
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      jdbcConnection.close(conn, ps, rs);
    }
    
    return noticeDto;
    
  }
  
  // 업데이트 메소드
  public int noticeUpdate(NoticeDto noticeDto) {
    
    int updateResult = 0;
    
    try {
      conn = jdbcConnection.getConnection();
      String sql = "UPDATE NOTICE_T SET GUBUN = ?, TITLE = ?, CONTENT = ? WHERE NOTICE_NO = ?";
      
      ps = conn.prepareStatement(sql);
      ps.setInt(1, Integer.parseInt(noticeDto.getGubun()));
      ps.setString(2, noticeDto.getTitle());
      ps.setString(3, noticeDto.getContent());
      ps.setInt(4, noticeDto.getNotice_no());
      
      updateResult = ps.executeUpdate();
      
    } catch(Exception e) {
      e.printStackTrace();
    } finally {
      jdbcConnection.close(conn, ps, rs);
    }
    
    return updateResult;
    
  }
  
  // 삭제 메소드
  public int noticeDelete(int notice_no) {
    
    int deleteResult = 0;
    
    try {
      
      conn = jdbcConnection.getConnection();
      String sql = "DELETE FROM NOTICE_T WHERE NOTICE_NO = ?";
      
      ps = conn.prepareStatement(sql);
      ps.setInt(1, notice_no);
      
      deleteResult = ps.executeUpdate();
      
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      jdbcConnection.close(conn, ps, rs);
    }
    
    return deleteResult;
    
  }
  
  public int testCount() {
    
    int count = 0;
    
    try {
      
      conn = jdbcConnection.getConnection();
      String sql = "SELECT COUNT(NOTICE_NO) AS COUNT FROM NOTICE_T";
      
      ps = conn.prepareStatement(sql);
      rs = ps.executeQuery();
      while(rs.next()) {
        count = rs.getInt("COUNT");
      }
      System.out.println(count);
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      jdbcConnection.close(conn, ps, rs);
    }
    
    return count;
  }
  
  
  
  
  
}
