package com.study.toypro.api.home.controller;

import com.study.toypro.api.home.model.BoardVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
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
    public List<BoardVO> getBoardList() {
        List<BoardVO> boardVOArrayList = new ArrayList<>();
        for(int i = 1; i <= 10; i++) {
            BoardVO boardVO = new BoardVO();
            boardVO.setSeq(i);
            boardVO.setTitle("제목" + i);
            boardVO.setWriter("테스터");
            boardVO.setContent(i + "번 내용입니다.");
            boardVO.setCreateDate(new Date());
            boardVO.setCnt(0);
            boardVOArrayList.add(boardVO);
        }
        return boardVOArrayList;
    }

    @GetMapping("/home/getBoardList5")
    public List<BoardVO> getBoardList1() {
        List<BoardVO> boardVOArrayList = new ArrayList<>();
        for(int i = 1; i <= 10; i++) {
            BoardVO boardVO = new BoardVO();
            boardVO.setSeq(i);
            boardVO.setTitle("제목" + i);
            boardVO.setWriter("테스터");
            boardVO.setContent(i + "번 내용입니다.");
            boardVO.setCreateDate(new Date());
            boardVO.setCnt(0);
            boardVOArrayList.add(boardVO);
        }
        return boardVOArrayList;
    }


}
