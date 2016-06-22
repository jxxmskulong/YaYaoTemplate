package com.nieyue.controller;

import java.io.IOException;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.xml.ws.ResponseWrapper;

import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.nieyue.bean.User;
import com.nieyue.comments.MyObjectMapper;
import com.nieyue.service.UserService;
import com.yayao.weixin.PastUtil;

/**
 * 用户控制类
 * @author yy
 *
 */
@Controller("userController")
@RequestMapping("user")
public class UserController {
	@Resource
	private UserService userService;
	
	/**
	 * 获取单个用户
	 * @param userId
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/test2",method={RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody  String test2(@RequestParam("niceName")String niceName,HttpSession session){
		System.out.println(niceName);
		return niceName;
		
	}
	/**
	 * 获取单个用户
	 * @param userId
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/{userId}",method={RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody User selectUserByID(@PathVariable("userId")Integer userId,HttpSession session){
		User user = userService.loadUser(userId);
		System.err.println(user);
		return user;
		
	}
	/**
	 * 登录
	 * @param userId
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/login",method={RequestMethod.GET,RequestMethod.POST})
	public /*@ResponseBody*/ User login(@ModelAttribute User user,HttpSession session){
		User u = userService.userLogin(user.getName(), user.getPassword());
		System.err.println(u);
		return u;
		
	}
	/**
	 * dataformatter
	 * @param userId
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/df",method={RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody Date dateformatter(@RequestParam(defaultValue="2011-01-05 11:11:22") Date date,HttpSession session){
		System.err.println(date);
		return date;
		
	}
	/**
	 * 获取单个用户
	 * @param userId
	 * @param session
	 * @return
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonParseException 
	 */
	@RequestMapping(value="/model",method={RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody User model(@RequestParam("public") String p,@RequestParam("key") String k,HttpSession session) throws JsonParseException, JsonMappingException, IOException{
		System.err.println(p);
		System.err.println(k);
		//p=p.substring(p.indexOf("public=")).substring(7);
		//p=p.replace('(', '{');
		//p=p.replace(')', '}');
		//k=k.replace('(', '{');
		//k=k.replace(')', '}');
		//System.out.println(p);
		//System.err.println(k);
		User user = (User) MyObjectMapper.getObjectMapper(p, new User());
		System.out.println(user);
		return user;
		
	}
	
	/**
	 * 获取单个用户
	 * @param userId
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/js",method={RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody User js(@RequestBody User user,HttpSession session){
		System.err.println(user);
		return user;
		
	}
	/**
	 * 获取单个用户
	 * @param userId
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/ysuser",method={RequestMethod.GET,RequestMethod.POST})
	public /*@ResponseBody*/ User ysuser(@Valid @ModelAttribute User user,BindingResult result,HttpSession session){
		if(result.hasErrors()){
			System.out.println("getAllErrors:"+result.getAllErrors());
			System.out.println("getErrorCount:"+result.getErrorCount());
			System.out.println("getFieldErrorCount:"+result.getFieldErrorCount());
			System.out.println("getGlobalErrorCount:"+result.getGlobalErrorCount());
			System.out.println("getGlobalErrors:"+result.getGlobalErrors());
			System.out.println("getGlobalError:"+result.getGlobalError());
			System.out.println("getTarget:"+result.getTarget());
			System.out.println("getFieldError:"+result.getFieldError());
			System.out.println("getFieldErrors:"+result.getFieldErrors());
			System.out.println("getModel:"+result.getModel());
			System.out.println("getDefaultMessage:"+result.getFieldError().getDefaultMessage());
		}
		System.err.println(user);
		return user;
		
	}
	
	/**
	 * 获取单个用户
	 * @param userId
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/rp",method={RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody User rp(@RequestPart User user,HttpSession session){
		System.err.println(user);
		return user;
		
	}
	/**
	 * 返回PastUtil的json数据
	 *
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/connection",method={RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody String connectionWeiXin(@RequestParam("url")String url){
		//String json = PastUtil.getParam("wxf70db1421d99a52b", "ba869f32f7b6fff6ab43b8b5ca864448",url);
		String json = PastUtil.getParam("wx0cfdb598d619807e", "d4624c36b6795d1d99dcf0547af5443d",url);//测试号
		//String json = PastUtil.getParam("wx89a3c3d95d687773", "4f3f443ff02c6e74e0ddd0ced5b997af",url);//自家公众号
		return json;
		
	}
	/*同步提交
	 * @RequestMapping(value="/addCustomerContent",method=RequestMethod.POST )
	//@TokenHandler(remove=true)
	public String addCustomerContent(@ModelAttribute Customer customer,@RequestParam("token") String token,ModelMap model,HttpServletRequest request){
		if(TokenSession.isrepeattoken(request)){
			return "foreground/contactUS";
		}
		customerService.addCustomerContent(customer);
		System.out.println(customer.getContent());
		model.addAttribute("customer", customer);
		request.getSession().setAttribute("customer", customer);
		 request.getSession( false ).setAttribute( "token" ,UUID.randomUUID().toString()); 
		return "foreground/contactUS";
		
	}*/
	/**
	 * 异步提交
	 */
	/*@RequestMapping(value="/addCustomerContent",method=RequestMethod.POST)
	public ResponseEntity<Customer> addCustomerContent(@ModelAttribute Customer customer){
			customerService.addCustomerContent(customer);
			return new ResponseEntity<Customer>(customer, HttpStatus.OK);
		}*/
	/*@RequestMapping(value="/addCustomerContent",method=RequestMethod.POST)
	public @ResponseBody Customer addCustomerContent(@ModelAttribute Customer customer){
		customerService.addCustomerContent(customer);
		return  customer;
	}*/
}
