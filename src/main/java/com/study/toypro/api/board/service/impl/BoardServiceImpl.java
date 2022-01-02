package com.study.toypro.api.board.service.impl;

import com.study.toypro.api.board.model.BoardDTO;
import com.study.toypro.api.board.service.BoardService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class BoardServiceImpl implements BoardService {
    @Override
    public BoardDTO getBoard() {
        BoardDTO board = new BoardDTO();
        board.setSeq(1);
        board.setTitle("테스트 제목...");
        board.setWriter("테서터");
        board.setContent("테스트 내용입니다.....");
        board.setCreateDate(new Date());
        board.setCnt(0);
        return board;
    }

    @Override
    public String hello(String name) {
        return "Hello : " + name;
    }

    @Override
    public List<BoardDTO> getBoardList() {
        List<BoardDTO> boardList = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            BoardDTO board = new BoardDTO();
            board.setSeq(i);
            board.setTitle("제목" + i);
            board.setWriter("테스터");
            board.setContent(i + "번 내용입니다.");
            board.setCreateDate(new Date());
            board.setCnt(0);
            boardList.add(board);
        }
        return boardList;
    }
}
