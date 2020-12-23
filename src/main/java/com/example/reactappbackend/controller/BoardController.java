package com.example.reactappbackend.controller;

import com.example.reactappbackend.model.board.request.InsertBoardRequest;
import com.example.reactappbackend.model.board.request.UpdateBoardRequest;
import com.example.reactappbackend.model.board.response.BoardDetailResponse;
import com.example.reactappbackend.model.board.response.BoardListResponse;
import com.example.reactappbackend.model.board.response.InsertBoardResponse;
import com.example.reactappbackend.service.BoardService;
import com.example.reactappbackend.utils.response.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api/boards")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;


    /**
     * 게시글 리스트 불러오기
     * @param token : 발급받은 jwt 토큰
     * @param auth : 권한 (0 = 로그인 안한 유저, 1 = 로그인 한 일반 유저, 2 = admin 권한)
     * @return
     */
    // TODO 추후 페이징 작업 및 필터 관련 기능 추가!
    @GetMapping
    public Response<BoardListResponse> boardList(@RequestHeader("token") String token, int auth) {
        BoardListResponse boardListResponse = boardService.boardList(auth, token);
        return new Response<>(boardListResponse);
    }

    /**
     * 게시글 추가하기
     * @param insertBoardRequest : 게시글 insert 할 때 필요한 값들
     * @return
     */
    @PostMapping
    public Response<InsertBoardResponse> insertBoard(@Valid @RequestBody InsertBoardRequest insertBoardRequest) {
        InsertBoardResponse insertBoardResponse = boardService.insertBoard(insertBoardRequest);
        return new Response<>(insertBoardResponse);
    }

    /**
     * 게시글 상세보기
     * @param boardId : 상세보기 할 게시글 id
     * @return
     */
    @GetMapping(value = "/{boardId}")
    public Response<BoardDetailResponse> boardDetail(@PathVariable int boardId) {
        BoardDetailResponse boardDetailResponse = boardService.boardDetail(boardId);
        return new Response<>(boardDetailResponse);
    }

    /**
     * 게시글 수정하기
     * @param boardId : 수정 할 게시글 id
     * @param updateBoardRequest : 게시글 수정 할 내용
     * @return
     */
    @PutMapping(value = "/{boardId}")
    public Response updateBoard(@PathVariable Integer boardId, @RequestBody UpdateBoardRequest updateBoardRequest) {
        boardService.updateBoard(boardId, updateBoardRequest);
        return Response.ok();
    }

    /**
     * 게시글 삭제
     * @param boardId : 삭제 할 게시글 id
     * @return
     */
    @DeleteMapping(value = "/{boardId}")
    public Response deleteBoard(@PathVariable Integer boardId) {
        boardService.deleteBoard(boardId);
        return Response.ok();
    }
}
