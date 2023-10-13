package com.gdu.myapp.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gdu.myapp.dto.NoticeDto;
import com.gdu.myapp.service.NoticeService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class NoticeController {

  private final NoticeService noticeService;
  
  @RequestMapping(value="/notice/list.do", method=RequestMethod.GET)
  public String getNoticeList(Model model) {
    List<NoticeDto> noticeList = noticeService.getNoticeList();
    System.out.println(noticeList);
    model.addAttribute("noticeList", noticeList);
    return "/notice/list";
  }
  
  @RequestMapping(value="/notice/write.do", method=RequestMethod.GET)
  public String write() {
    return "/notice/write";
  }
  
  @RequestMapping(value="/notice/add.do", method=RequestMethod.POST)
  public String noticeAdd(NoticeDto noticeDto, RedirectAttributes redirectAttributes) {
    int addResult = noticeService.noticeAdd(noticeDto);
    redirectAttributes.addFlashAttribute("addResult", addResult);
    return "redirect:/notice/list.do";
  }
  
  @RequestMapping(value="/notice/detail.do", method=RequestMethod.GET)
  public String noticeDetail(@RequestParam(value="notice_no") int notice_no, Model model) {
    NoticeDto noticeDto = noticeService.noticeDetail(notice_no);
    model.addAttribute("noticeDto", noticeDto);
    return "/notice/detail";
  }
  
  @RequestMapping(value="/notice/edit.do", method=RequestMethod.POST)
  public String noticeEdit(@RequestParam(value="notice_no") int notice_no, Model model) {
    NoticeDto noticeDto = noticeService.noticeDetail(notice_no);
    model.addAttribute("noticeDto", noticeDto);
    return "/notice/edit";
  }
  
  @RequestMapping(value="/notice/update.do", method=RequestMethod.POST)
  public String noticeUpdate(NoticeDto noticeDto, RedirectAttributes redirectAttributes) {
    int updateResult = noticeService.noticeUpdate(noticeDto);
    redirectAttributes.addFlashAttribute("updateResult", updateResult);
    return "redirect:/notice/detail.do?notice_no=" + noticeDto.getNotice_no();
  }
  
  @RequestMapping(value="/notice/delete.do", method=RequestMethod.POST)
  public String noticeUpdate(@RequestParam(value="notice_no") int notic_no, RedirectAttributes redirectAttributes) {
    int deleteResult = noticeService.noticeDelete(notic_no);
    redirectAttributes.addFlashAttribute("deleteResult", deleteResult);
    return "redirect:/notice/list.do";
  }
  
  
  
  
  
  
  
  
  
  
  
  
  
  
}
