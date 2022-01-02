package com.study.toypro.api.home.controller;

import com.study.toypro.api.home.dto.BoardDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//@RestController
public class HomeController {
    @GetMapping("/")
    public String index() {
        return "home";
    }

    @PostMapping("/")
    public String postHome() {
        return "home";
    }

    @GetMapping("/home/getBoardList")
    public List<BoardDto> getBoardList() {
        List<BoardDto> boardDtoArrayList = new ArrayList<>();
        for(int i = 1; i <= 10; i++) {
            BoardDto boardDto = new BoardDto();
            boardDto.setSeq(i);
            boardDto.setTitle("제목" + i);
            boardDto.setWriter("테스터");
            boardDto.setContent(i + "번 내용입니다.");
            boardDto.setCreateDate(new Date());
            boardDto.setCnt(0);
            boardDtoArrayList.add(boardDto);
        }
        return boardDtoArrayList;
    }

    @GetMapping("/home/getBoardList5")
    public List<BoardDto> getBoardList1() {
        List<BoardDto> boardDtoArrayList = new ArrayList<>();
        for(int i = 1; i <= 10; i++) {
            BoardDto boardDto = new BoardDto();
            boardDto.setSeq(i);
            boardDto.setTitle("제목" + i);
            boardDto.setWriter("테스터");
            boardDto.setContent(i + "번 내용입니다.");
            boardDto.setCreateDate(new Date());
            boardDto.setCnt(0);
            boardDtoArrayList.add(boardDto);
        }
        return boardDtoArrayList;
    }


}
