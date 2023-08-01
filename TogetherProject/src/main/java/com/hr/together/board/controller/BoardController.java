package com.hr.together.board.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hr.together.board.model.service.BoardService;
import com.hr.together.board.controller.BoardController;

@Controller
public class BoardController {

	private Logger logger = LoggerFactory.getLogger(BoardController.class);
	private BoardService boardService;
	
	public BoardController() {
		
	}
	
	@Autowired
	public BoardController(BoardService boardService) {
		this.boardService = boardService;
	}
	
	@RequestMapping(value = "/board/boardList", method = {RequestMethod.GET })
	public String boardList(Model model, HttpSession session) {

		logger.info(">> 방명록 이동");
		return "board/boardList";
	}
}
