package com.gdu.myapp;

import static org.junit.Assert.assertEquals;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.gdu.myapp.dao.NoticeDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml")
public class NoticeUnitTest {

  @Autowired
  private NoticeDao noticeDao;
  
  public void test_행개수() {
    
    int count = noticeDao.testCount();
    assertEquals(5, count);
  }
  
}
