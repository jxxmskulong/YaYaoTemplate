package com.nieyue.controller;

import javax.xml.ws.ResponseWrapper;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nieyue.bean.User;
import com.yayao.weixin.CheckUtil;
/**
 * 微信接口
 * @author yy
 *
 */
@Controller("weixinController")
public class WeixinController {
	

	@RequestMapping(value="/weixin",method={RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody String connectionWeiXin(@RequestParam("signature")String signature,@RequestParam("timestamp")String timestamp,@RequestParam("nonce")String nonce,@RequestParam("echostr")String echostr){
		if(CheckUtil.checkSignature(signature, timestamp, nonce)){
			return echostr;
		}
		return null;
	}
	
	/**
	 * 消息的接收与响应
	 */
	@RequestMapping(value="/msg",method={RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody String msgWeiXin(@ModelAttribute User user){
		/*try {
			Map<String, String> map = MessageUtil.xmlToMap(req);
			String fromUserName = map.get("FromUserName");
			String toUserName = map.get("ToUserName");
			String msgType = map.get("MsgType");
			String content = map.get("Content");
			
			String message = null;
			if(MessageUtil.MESSAGE_TEXT.equals(msgType)){
				if("1".equals(content)){
					message = MessageUtil.initText(toUserName, fromUserName, MessageUtil.firstMenu());
				}else if("2".equals(content)){
					message = MessageUtil.initNewsMessage(toUserName, fromUserName);
				}else if("3".equals(content)){
					//message = MessageUtil.initText(toUserName, fromUserName, MessageUtil.threeMenu());
				}else if("?".equals(content) || "？".equals(content)){
					message = MessageUtil.initText(toUserName, fromUserName, MessageUtil.menuText());
				}else if(content.startsWith("翻译")){
					String word = content.replaceAll("^翻译", "").trim();
					if("".equals(word)){
						//message = MessageUtil.initText(toUserName, fromUserName, MessageUtil.threeMenu());
					}else{
						//message = MessageUtil.initText(toUserName, fromUserName, WeixinUtil.translate(word));
					}
				}
			}else if (MessageUtil.MESSAGE_EVNET.equals(msgType)){
				String eventType=map.get("Event");
				if(MessageUtil.MESSAGE_SUBSCRIBE.equals(eventType)){
					message=MessageUtil.initText(toUserName, fromUserName, MessageUtil.menuText());
				}
			}
			out.print(message);
		} catch (DocumentException e) {
			e.printStackTrace();
		}finally{
			out.close();
		}*/
		return null;
	}
}
