package com.study.toypro.api.board.controller;

import com.study.toypro.api.board.model.BoardDTO;
import com.study.toypro.api.board.service.BoardService;
import com.study.toypro.api.board.service.impl.BoardServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BoardController {
    @Autowired
    private BoardService boardService;

    public BoardController() {
        System.out.println("====> BoardController was created");
    }

    @GetMapping("/hello")
    public String hello(String name) {
        return boardService.hello(name);
    }

    @GetMapping("/boards/board")
    public BoardDTO getBoard() {
        return boardService.getBoard();
    }

    @GetMapping("/boards/boardlist")
    public List<BoardDTO> getBoardList() {
        return boardService.getBoardList();
    }
}
