package com.example.reactappbackend.service;

import com.example.reactappbackend.mapper.BoardMapper;
import com.example.reactappbackend.model.board.request.InsertBoardRequest;
import com.example.reactappbackend.model.board.request.UpdateBoardRequest;
import com.example.reactappbackend.model.board.response.BoardDetailResponse;
import com.example.reactappbackend.model.board.response.BoardListResponse;
import com.example.reactappbackend.model.board.response.InsertBoardResponse;
import com.example.reactappbackend.model.dto.Board;
import com.example.reactappbackend.utils.exception.Error;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

import static com.example.reactappbackend.utils.exception.ErrorCode.*;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardMapper boardMapper;

    public BoardListResponse boardList(int auth, String token) {
        if(!StringUtils.hasText(token)) {
            auth = 0;
        }
        List<Board> boardList = boardMapper.boardList(auth);

        return BoardListResponse.builder()
                .boardList(
                        boardList.stream().map(
                                board -> BoardListResponse.Board.builder()
                                        .boardId(board.getBoardId())
                                        .userId(board.getUserId())
                                        .categoryName(board.getCategoryName())
                                        .title(board.getTitle())
                                        .createDate(board.getCreateDate())
                                        .build())
                                .collect(Collectors.toList()))
                .build();
    }

    public InsertBoardResponse insertBoard(InsertBoardRequest insertBoardRequest) {
        Board board = new Board();
        board.setUserId(insertBoardRequest.getUserId());
        board.setCategoryId(insertBoardRequest.getCategoryId());
        board.setTitle(insertBoardRequest.getTitle());
        board.setContent(insertBoardRequest.getContent());
        board.setIsPublic(insertBoardRequest.getIsPublic());
        try {
            boardMapper.insertBoard(board);
            return InsertBoardResponse.builder()
                    .boardId(board.getBoardId())
                    .build();
        } catch (Exception e) {
            throw Error.of(JdbcError, e.getMessage());
        }
    }

    public BoardDetailResponse boardDetail(int boardId) {
        Board board = boardMapper.boardDetail(boardId);

        if(ObjectUtils.isEmpty(board)) {
            throw Error.of(UnknownBoard);
        }

        return BoardDetailResponse.builder()
                .boardId(board.getBoardId())
                .categoryName(board.getCategoryName())
                .userId(board.getUserId())
                .userName(board.getUserName())
                .title(board.getTitle())
                .content(board.getContent())
                .createDate(board.getCreateDate())
                .updateDate(board.getUpdateDate())
                .build();
    }

    public void updateBoard(Integer boardId, UpdateBoardRequest updateBoardRequest) {
        Board board = new Board();
        board.setBoardId(boardId);
        board.setCategoryId(updateBoardRequest.getCategoryId());
        board.setTitle(updateBoardRequest.getTitle());
        board.setContent(updateBoardRequest.getContent());
        board.setIsPublic(updateBoardRequest.getIsPublic());

        try{
            boardMapper.updateBoard(board);
        } catch (Exception e) {
            throw Error.of(JdbcError, e.getMessage());
        }
    }

    public void deleteBoard(Integer boardId) {
        try {
            boardMapper.deleteBoard(boardId);
        } catch (Exception e) {
            throw Error.of(JdbcError, e.getMessage());
        }
    }
}
