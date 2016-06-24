package com.nieyue.controller.test;

import static org.junit.Assert.fail;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.nieyue.controller.UserController;
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations={"classpath:config/spring-dao.xml","classpath:config/spring-service.xml","classpath:config/springmvc-servlet.xml"})
public class UserControllerTest {
	@Resource
	UserController userController;
	@Resource
	WebApplicationContext wac;
	MockHttpServletRequest request=new MockHttpServletRequest();
	MockHttpServletResponse response=new MockHttpServletResponse();
	MockMvc mvc;
	@Before
	public void setUp(){
		this.mvc=MockMvcBuilders.webAppContextSetup(this.wac).build();
	}
	@Test
	public void testTest1() {
		fail("Not yet implemented");
	}

	@Test
	public void testTest2() {
		fail("Not yet implemented");
	}

	@Test
	public void testSelectUserByID() {
		fail("Not yet implemented");
	}

	@Test
	public void xsdfsdfsd() throws Exception {
		Integer type=0;//0是get
		String url="/user/login?name=15111336587&password=123456";
		//String url="/user/test2.html?niceName=sdf";
		//String url="/";
		//String url="/user/ysuser.xml?userId=1000&name=15111336587&niceName=聂跃&regTime=2223-11-11 12:11:11";
		//String url="/user/df.xml?date=2015-11-11 11:11:11";//dateformatter
		//String url="/user/model?public=\u007B \"user_id\":\"1000\"\u007D &key=2";
		//String url="/user/model?public=(\"user_id\":\"1000\") &key=(\"format\":\"json\")";
		//String url="/user/model?public=\u007B \"sdf\"\u007D &key=2";
		//String url="/user/connection?url=http://www.baidu.com";
		if(type.equals(0)){
		this.mvc.perform(get(url))
		//.andExpect(status().isOk())
		.andDo(print());
		return;
		}
		this.mvc.perform(post(url))
		//.andExpect(status().isOk())
		.andDo(print());
		
	}

	@Test
	public void testModel() {
		fail("Not yet implemented");
	}

	@Test
	public void testJs() {
		fail("Not yet implemented");
	}

	@Test
	public void testRp() {
		fail("Not yet implemented");
	}

}
