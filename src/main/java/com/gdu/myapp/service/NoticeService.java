package com.gdu.myapp.service;

import java.util.List;

import com.gdu.myapp.dto.NoticeDto;

public interface NoticeService {
  public List<NoticeDto> getNoticeList();
  public int noticeAdd(NoticeDto noticeDto);
  public NoticeDto noticeDetail(int contact_no);
  public int noticeUpdate(NoticeDto noticeDto);
  public int noticeDelete(int notice_no);
}
