package com.example.reactappbackend.mapper;

import com.example.reactappbackend.model.dto.Board;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface BoardMapper {
    List<Board> boardList(int auth);

    void insertBoard(Board board);

    Board boardDetail(int boardId);

    void updateBoard(Board board);

    void deleteBoard(Integer boardId);
}

