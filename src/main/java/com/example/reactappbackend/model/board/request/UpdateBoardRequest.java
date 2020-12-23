package com.example.reactappbackend.model.board.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UpdateBoardRequest {
    private Integer categoryId;
    private String title;
    private String content;
    private Integer isPublic;
}
