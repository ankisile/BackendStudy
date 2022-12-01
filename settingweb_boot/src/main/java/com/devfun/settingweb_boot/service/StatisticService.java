package com.devfun.settingweb_boot.service;
 
import java.util.HashMap;
 
public interface StatisticService {
    public HashMap<String,Object> yearloginNum (String year);
    
    public HashMap<String, Object> yearMonthAccessNum(String yearMonth);
    
    public HashMap<String, Object> yearMonthDateAccessNum(String yearMonthDate);
    
    public HashMap<String, Object> yearMonthAverageNum(String yearMonth);
    
    public HashMap<String, Object> yearMonthOrganizationLoginNum(String yearMonth, String organization);
    
    public HashMap<String, Object> weekDayLoginNum(String year);
}