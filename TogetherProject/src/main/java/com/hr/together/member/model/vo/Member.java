package com.hr.together.member.model.vo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Member {
	private String userNo;
	private String userName;
	private String phone;
	private String email;
	private Date regDate;
	private String del_yn;
}
