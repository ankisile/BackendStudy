package com.devfun.settingweb_boot.test;
 
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.devfun.settingweb_boot.service.StatisticService;
 
@RestController
public class settingTest {
	
	@Autowired
	private StatisticService service;
	    
 
    @GetMapping("/sqlyearStatistic")
    public Map<String, Object> sqltest(String year) throws Exception{ 
        
        return service.yearloginNum(year);
    }
    
    @GetMapping("/access/month/{yearMonth}")
    public Map<String, Object> getAccessYearMonth(@PathVariable String yearMonth) throws Exception{
    	return service.yearMonthAccessNum(yearMonth);
    }
    
    @GetMapping("/access/date/{yearMonthDate}")
    public Map<String, Object> getAccessYearMonthDate(@PathVariable String yearMonthDate) throws Exception{
    	return service.yearMonthDateAccessNum(yearMonthDate);
    }
    
    @GetMapping("/login/average/{yearMonth}")
    public Map<String, Object> getLoginAverage(@PathVariable String yearMonth) throws Exception{
    	return service.yearMonthAverageNum(yearMonth);
    }
    
    @GetMapping("/login/{organization}/{yearMonth}")
    public Map<String, Object> getOrganizationLogin(@PathVariable String organization, @PathVariable String yearMonth) throws Exception{
    	return service.yearMonthOrganizationLoginNum(yearMonth, organization);
    }
    
    @GetMapping("/login/weekday/{year}")
    public Map<String, Object> getWeekdayLogin(@PathVariable String year) throws Exception{
    	return service.weekDayLoginNum(year);
    }
    
    
    
    @RequestMapping("/test") 
    public ModelAndView test() throws Exception{ 
        ModelAndView mav = new ModelAndView("test"); 
        mav.addObject("name", "devfunpj"); 
        List<String> resultList = new ArrayList<String>(); 
        resultList.add("!!!HELLO WORLD!!!"); 
        resultList.add("설정 TEST!!!"); 
        resultList.add("설정 TEST!!!"); 
        resultList.add("설정 TEST!!!!!"); 
        resultList.add("설정 TEST!!!!!!"); 
        mav.addObject("list", resultList); 
        return mav; 
    }
 
}