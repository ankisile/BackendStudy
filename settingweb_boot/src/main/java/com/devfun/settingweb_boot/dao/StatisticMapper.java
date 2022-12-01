package com.devfun.settingweb_boot.dao;
import java.util.HashMap;
import java.util.List;

import com.devfun.settingweb_boot.dto.StaticDto;
  
public interface  StatisticMapper {
    public HashMap<String, Object> selectYearLogin(String year);
 
    public HashMap<String, Object> selectYearMonthAccess(String yearMonth);

    public HashMap<String, Object> selectYearMonthDateAccess(String yearMonthDate); 
    
    public HashMap<String, Object> selectYearMonthLogin(String yearMonth); 

    public HashMap<String, Object> selectYearMonthOrganizationLogin(String yearMonth, String organization); 

    public List<StaticDto> selectDateYearLogin(String year); 
    
}
