package com.gdu.myapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gdu.myapp.dao.NoticeDao;
import com.gdu.myapp.dto.NoticeDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class NoticeServiceImpl implements NoticeService {
  
  private final NoticeDao noticeDao;
  
  @Override
  public List<NoticeDto> getNoticeList() {
    return noticeDao.getNoticeList();
  }
  
  @Override
  public int noticeAdd(NoticeDto noticeDto) {
    int addResult = noticeDao.noticeAdd(noticeDto);
    return addResult;
  }
  
  @Override
  public NoticeDto noticeDetail(int contact_no) {
    NoticeDto noticeDto = noticeDao.noticeDetail(contact_no);
    return noticeDto;
  }
  
  @Override
  public int noticeUpdate(NoticeDto noticeDto) {
    int updateResult = noticeDao.noticeUpdate(noticeDto);
    return updateResult;
  }
  
  @Override
  public int noticeDelete(int notice_no) {
    int deleteResult = noticeDao.noticeDelete(notice_no);
    return deleteResult;
  }

}
