package com.devfun.settingweb_boot.dto;

import lombok.Data;

@Data
public class StaticDto {
	private String createDate;

	public String getCreateDate() {
		return createDate;
	}	
}
