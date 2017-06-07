package org.spring.hibernate.website.controllers;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.spring.hibernate.entity.bpo.FileInfo;
import org.spring.hibernate.utils.LocaleUtils;
import org.spring.hibernate.website.controllers.abs.AbstractControllerObject;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

/**
 * 描述：测试控制器类
 * <i>该类</i>
 * 
 * @author Aaric
 *
 */
@Controller
@Scope("prototype")
@RequestMapping("/test")
public class TestController extends AbstractControllerObject {
	
	/**
	 * 测试国际化示例
	 * 
	 * @param languageString 遗留国际化字符串
	 * @param localeString 标准国际化字符串
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/index.shtml", method=RequestMethod.GET)
	public ModelAndView index(@RequestParam(value="language",required=false)String languageString, 
			@RequestParam(value="locale",required=false)String localeString,
			HttpServletResponse response) throws Exception {
			/*兼容旧遗留的国际化，同时支持JAVA标准国际化*/
			System.out.println("--prev:" + super.getLocale());
			if (null != languageString || null != localeString) {
				Locale locale = LocaleUtils.parse(languageString, localeString);
				super.setLocale(super.getRequest(), response, locale);
				System.out.println("--update:" +super.getLocale());
			}
			
			/**
			 * 测试获得国际化语言资源字符串
			 */
			String languageName = super.getMessage("language.name");
			String languageName2 = super.getMessage("language.name", Locale.ENGLISH);
			// 说明：控制台字符集不支持会出现控制台乱码
			System.out.println("--languageName:" + languageName);
			System.out.println("--languageName2:" + languageName2);
			modelAndView.addObject("languageName", languageName);
		
		return modelAndView;
	}
	
	/**
	 * 测试持久层引入情况
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/persist.shtml", method=RequestMethod.GET)
	public ModelAndView testPersist() throws Exception {
		/*构建虚拟文件信息对象*/
		FileInfo fileInfo = new FileInfo();
		fileInfo.setFileName("test.png");
		fileInfo.setFileOppPath("path/test.png");
		fileInfo.setFileSize(425L);
		fileInfo.setFileType("images/png");
		fileInfo.setRemarks("this is a test file.");
		fileInfo.setInsertTime(new Timestamp(Calendar.getInstance().getTimeInMillis()));
		
		/*保持到数据库*/
		Serializable id = this.getServiceHelper().getFileInfoService().save(fileInfo);
		System.out.println("database id --> " + id);
		
		return modelAndView;
	}
	
	/**
	 * 测试JSON数据
	 * 
	 * @param id 
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value="/json.shtml", method=RequestMethod.GET, produces=HTTP_TEXT_TYPE_PLAIN_UTF_8)
	public String testJson(@RequestParam(value="id", required=false) Long id) throws Exception {
		StringBuffer sb = new StringBuffer();
		Map<String, Long> mapDatas = new HashMap<String, Long>();
		mapDatas.put("random", Calendar.getInstance().getTimeInMillis());
		mapDatas.put("input", id);
		sb.append(new Gson().toJson(mapDatas));
		
		return sb.toString();
	}
	
	/**
	 * 测试显示客户端IP地址
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/clientip.shtml", method=RequestMethod.GET)
	public ModelAndView testClientIpAddr(HttpServletResponse response) throws Exception {
		/*获得客户端IP，并且显示到前台*/
		String ip = super.getClientIpAddr();
		logger.debug("print client ip:" + ip);
		modelAndView.addObject("message", ip);
		
		/**
		 * 备注: 拦截器ViewNameInterceptor启用后，以下代码失效，
		 * 程序会默认找WEB-INF/view/jsp/test/clientip.jsp
		 */
		// modelAndView.setViewName("template");
		
		return modelAndView;
	}
	
	/**
	 * 测试表单校验
	 * 
	 * @return
	 */
	@RequestMapping(value="/form.shtml")
	public ModelAndView form() throws Exception {
		/**
		 * 模拟数据
		 */
		modelAndView.addObject("person", new Person());
		
		return modelAndView;
	}

	/**
	 * 测试数据校验
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/submit.shtml")
	public ModelAndView submit(@Valid Person persion,
			BindingResult result) throws Exception {
		/*服务端数据校验*/
		if (result.hasErrors()) {
			/*数据校验失败*/
			modelAndView.addObject("message", "There are validation errors!");
			modelAndView.setViewName("test/form");
		} else {
			/*数据校验成功，跳转到list页面*/
			modelAndView.addObject("message", "Success!");
			modelAndView.setViewName("redirect:/test/form.shtml");
		}
		
		return modelAndView;
	}

	
	/**
	 * 测试@PathVariable注解的用法
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/delete/{deleteId}.shtml", method=RequestMethod.GET)
	public ModelAndView index(@PathVariable("deleteId") long id) throws Exception {
		System.out.println("--delete: " + id);
		modelAndView.addObject("person", new Person());
		modelAndView.setViewName("test/form");
		return modelAndView;
	}
	
	/**
	 * 描述：测试对象
	 * 
	 * @author Aaric
	 *
	 */
	public static class Person {
		
		@NotEmpty(message="{person.name.not.null}")
		private String name;
		
		@NotEmpty(message="{person.password.not.null}")
		@Length(min=6, max=32, message="{person.password.min.max.length}")
		private String password;

		public Person() {
			super();
		}

		public Person(String name, String password) {
			super();
			this.name = name;
			this.password = password;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}
		
	}
	
}
