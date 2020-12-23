package com.example.reactappbackend.model.board.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class InsertBoardRequest {
    @NotBlank(message = "userId is empty")
    private String userId;
    private Integer categoryId;
    @NotBlank(message = "제목을 입력해주세요.")
    private String title;
    @NotBlank(message = "내용을 입력해주세요.")
    private String content;
    private int isPublic;
}
