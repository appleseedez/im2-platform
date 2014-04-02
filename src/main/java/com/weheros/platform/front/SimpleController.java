/*
* Copyright HZCW (He Zhong Chuang Wei) Technologies Co.,Ltd. 2013-2015. All rights reserved.
*
*
*/
package com.weheros.platform.front;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.weheros.platform.infrastructure.datasystem.InitializeApplicationDataAndParameters;


/**
 * @ClassName: SimpleController
 * 展示了怎样兼顾application/json,application/xml,jsp请求
 * <p>
 * @author Administrator
 * @date 2013年11月6日 下午3:56:50
 */
@Controller
@RequestMapping("/simple/*")
public class SimpleController extends AbstractController {

	  public @ResponseBody Response uploadFile(HttpServletRequest request,
				HttpServletResponse response,@RequestParam(value="name", required=false, defaultValue="World") String name) {
		  RequestContextUtils.getLocale(request);

	    	return new Response("200","upload success.");
	}
	/**
	 *  能够接受JSON,XML,JSP请求
	 *  Could return json,xml,jsp response.
	  * @author Administrator
	  * @param model
	  * @return 
	  * String
	  *
	 */
	@RequestMapping(value="saywel",method = RequestMethod.GET)	
	public String welcome2(ModelMap model){
		
		model.addAttribute("message",new Response("200","Welcome to simplecontroller"));
		
		return "content";
	}
	/** Json POST
	 *  Only return json response.
	  * @author Administrator
	  * @param newMessage
	  * @param model
	  * @return 
	  * Message
	  *
	 */
	@RequestMapping(value="saveMessage",method = RequestMethod.POST)
	@ResponseBody
	public Response recieveJson(@RequestBody Response newMessage, ModelMap model){
		log.info("---------post the message-----------"+newMessage.getMsg());
		return new Response("9999","recieveJson is success.");
		
	}
	
	@RequestMapping(value="postByParam",method = RequestMethod.POST)	
	public String postByParam(@RequestBody Response newMessage,@RequestParam("jsonString") String ajson, ModelMap model){
		log.info("---------from requestParam-----------"+ajson);
		log.info("---------from requestBody-----------"+newMessage.getMsg());
		//return new Message("99990","recieveJson is success.");
		model.addAttribute("message",new Response("99990","recieveJson to simplecontroller"));
		return "content";
	}
	
	@RequestMapping(value="getme",method = RequestMethod.GET)
	@ResponseBody
	public Response getJson( ModelMap model){		
		return new Response("8888","recieveJson is success.");
		
	}
	
	@Autowired	 
	InitializeApplicationDataAndParameters initialization;
	@RequestMapping(value="getappconfig",method = RequestMethod.GET)
	
	public String getAppconfig( ModelMap model){		
		Response response=new Response("8888","recieveJson is success.");
		response.setData(initialization.getAppconfig());
		model.addAttribute("message",response);
		return "content";
	}
	
}
