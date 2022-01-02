package com.study.toypro.api.board.controller;

import com.study.toypro.api.board.model.BoardDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class BoardTestController {
    public BoardTestController() {
        System.out.println("====> BoardTestController");
    }

    @GetMapping("/hello1")
    public String hello(String name) {
        return "Hello : " + name;
    }

    @GetMapping("/boards1/read")
    public BoardDTO getBoard() {
        BoardDTO board = new BoardDTO();
        board.setSeq(1);
        board.setTitle("테스트 제목...");
        board.setWriter("테스터");
        board.setContent("테스트 내용입니다.....");
        board.setCreateDate(new Date());
        board.setCnt(0);
        return board;
    }
}
