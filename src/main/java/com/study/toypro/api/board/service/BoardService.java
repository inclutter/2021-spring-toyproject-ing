package com.study.toypro.api.board.service;

import com.study.toypro.api.board.model.BoardDTO;

import java.util.List;

public interface BoardService {
    BoardDTO getBoard();

    String hello(String name);

    List<BoardDTO> getBoardList();
}
