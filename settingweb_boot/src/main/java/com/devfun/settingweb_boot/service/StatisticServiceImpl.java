package com.devfun.settingweb_boot.service;
 
 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sound.midi.SysexMessage;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.XML;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.devfun.settingweb_boot.dao.StatisticMapper;
import com.devfun.settingweb_boot.dto.StaticDto;
import com.fasterxml.jackson.databind.ObjectMapper;
 
@Service
public class StatisticServiceImpl implements StatisticService {
    
    
    @Autowired
    private StatisticMapper uMapper;
    
    @Override
    public HashMap<String, Object> yearloginNum (String year) {
        // TODO Auto-generated method stub
        HashMap<String, Object> retVal = new HashMap<String,Object>();
        
        try {
            retVal = uMapper.selectYearLogin(year);
            retVal.put("year", year);
            retVal.put("is_success", true);
            
        }catch(Exception e) {
            retVal.put("totCnt", -999);
            retVal.put("year", year);
            retVal.put("is_success", false);
        }
        
        return retVal;
    }

	@Override
	public HashMap<String, Object> yearMonthAccessNum(String yearMonth) {
		// TODO Auto-generated method stub
		HashMap<String, Object> retVal = new HashMap<String,Object>();
		
		try {
			retVal = uMapper.selectYearMonthAccess(yearMonth);
            retVal.put("yearMonth", yearMonth);
            retVal.put("is_success", true);
		}catch(Exception e) {
            retVal.put("totCnt", -999);
            retVal.put("yearMonth", yearMonth);
            retVal.put("is_success", false);
        }
		return retVal;
	}
 
	@Override
	public HashMap<String, Object> yearMonthDateAccessNum(String yearMonthDate) {
		// TODO Auto-generated method stub
		HashMap<String, Object> retVal = new HashMap<String,Object>();
		
		try {
			retVal = uMapper.selectYearMonthDateAccess(yearMonthDate);
            retVal.put("yearMonthDate", yearMonthDate);
            retVal.put("is_success", true);
		}catch(Exception e) {
            retVal.put("totCnt", -999);
            retVal.put("yearMonthDate", yearMonthDate);
            retVal.put("is_success", false);
        }
		return retVal;
	}
	
	@Override
	public HashMap<String, Object> yearMonthAverageNum(String yearMonth) {
		// TODO Auto-generated method stub
		HashMap<String, Object> retVal = new HashMap<String,Object>();
		
		Calendar cal = Calendar.getInstance();
		cal.set(Integer.parseInt("20"+yearMonth.substring(0,2)), Integer.parseInt(yearMonth.substring(2)), 1);
		int days = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		
		try {
			int loginNum = Integer.parseInt(uMapper.selectYearMonthLogin(yearMonth).get("loginNum").toString());
			retVal.put("totCnt", loginNum/days );
            retVal.put("yearMonth", yearMonth);
            retVal.put("is_success", true);
		}catch(Exception e) {
            retVal.put("totCnt", -999);
            retVal.put("yearMonth", yearMonth);
            retVal.put("is_success", false);
        }
		return retVal;
	}
	
	@Override
	public HashMap<String, Object> yearMonthOrganizationLoginNum(String yearMonth, String organization) {
		// TODO Auto-generated method stub
		HashMap<String, Object> retVal = new HashMap<String,Object>();
		
		try {
			retVal = uMapper.selectYearMonthOrganizationLogin(yearMonth, organization);
            retVal.put("yearMonth", yearMonth);
            retVal.put("organization", organization);
            retVal.put("is_success", true);
		}catch(Exception e) {
            retVal.put("totCnt", -999);
            retVal.put("yearMonth", yearMonth);
            retVal.put("is_success", false);
        }
		return retVal;
	}
	
	@Override
	public HashMap<String, Object> weekDayLoginNum(String year) {
		// TODO Auto-generated method stub
		HashMap<String, Object> retVal = new HashMap<String,Object>();
		
		try {
			List<StaticDto> loginInfo = uMapper.selectDateYearLogin(year);
			ArrayList<String> restDates = getRestDates(year);
			for(int i=0;i<loginInfo.size();i++) {
				String date = "20"+(loginInfo.get(i).getCreateDate().substring(0,6));
				if(restDates.contains(date)){
					loginInfo.remove(i);
				}
			}
			retVal.put("totCnt", loginInfo.size());
            retVal.put("yearMonth", year);
            retVal.put("is_success", true);
		}catch(Exception e) {
            retVal.put("totCnt", -999);
            retVal.put("yearMonth",year);
            retVal.put("is_success", false);
        }
		return retVal;
	}
	
	private ArrayList<String> getRestDates(String year) throws IOException {
		String y ="20"+year.substring(0,2);
//		String m = yearMonth.substring(2);
		
		StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/B090041/openapi/service/SpcdeInfoService/getRestDeInfo"); /*URL*/
		urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=UdJoe0RU%2BfA4noQhiQupw5F43s9H%2BGaTyKVFX9guM4wsuoWR9SWXPtQ4pHzWpcOpP%2FBo6enHnmibSfN55xy7tQ%3D%3D"); /*Service Key*/
		urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지번호*/
        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("100", "UTF-8")); /*한 페이지 결과 수*/
		urlBuilder.append("&" + URLEncoder.encode("solYear","UTF-8") + "=" + URLEncoder.encode(y, "UTF-8")); /*연*/
//        urlBuilder.append("&" + URLEncoder.encode("solMonth","UTF-8") + "=" + URLEncoder.encode("08", "UTF-8")); /*월*/
        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        System.out.println("Response code: " + conn.getResponseCode());
        BufferedReader rd;
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        rd.close();
        conn.disconnect();
        return xmlToList(sb.toString());

	}
	
	private ArrayList<String> xmlToList(String xml) {
		
		JSONObject json = XML.toJSONObject(xml);
		
		
		json = json.getJSONObject("response").getJSONObject("body").getJSONObject("items");
		
		System.out.println(json);
		JSONArray jsonArray = json.getJSONArray("item");
		
		ArrayList<String> restDates = new ArrayList<>();
		if(jsonArray.length() == 0) {
			restDates.add(json.getJSONObject("item").get("locdate").toString());
			System.out.println("hello");
			return restDates;
		}
		
		for(int i=0;i<jsonArray.length();i++) {
			restDates.add( jsonArray.getJSONObject(i).get("locdate").toString());
			System.out.print(jsonArray.getJSONObject(i).get("locdate").toString());
		}
		System.out.print(restDates.size());
		
		return restDates;
    }
}