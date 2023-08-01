package com.hr.together.board.model.vo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class MainBoard {

	private String idx;
	private String writeNm;
	private String title;
	private String noticeYn = "N";
	private String secretYn = "N";
	private String delYn = "N";
	private Date createDate = new Date();
}
