package com.ssafy.edu.vue.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepCountDto {
	private Integer dept_id;
	private String name;
	private Integer count;
}
