package com.spring.test.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.test.pageutil.PaginationCriteria;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) { // session 꺼질때까지 , model 지금 당장 넘겨주는 값.
		logger.info("HomeController is home :: Welcome home! The client locale is {}.", locale);
		logger.info("HomeController is home :: 기억이 안난다");
		Date date = new Date(); //날짜 정보
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate ); // 시간값을 String으로 저장후 model에 serverTime으로 jsp에 전달.
		
		return "home"; //views/home으로 리턴.
	}//end home
	
	@RequestMapping(value="/board", method=RequestMethod.GET)
	public String board(Model m, Integer page, Integer perPage) {
		PaginationCriteria c;
		if (page!=null&&perPage!=null) {
			c = new PaginationCriteria(page, perPage);
		}else {
			page=1;
			c = new PaginationCriteria(page,10);
		}
		logger.info("board :: "+page+" / "+perPage);
		return "list";
	}
	
	
	
}
