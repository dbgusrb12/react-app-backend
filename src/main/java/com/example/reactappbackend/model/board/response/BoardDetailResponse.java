package com.example.reactappbackend.model.board.response;

import lombok.Builder;
import lombok.Data;

import java.sql.Date;

@Data
@Builder
public class BoardDetailResponse {
    private Integer boardId;
    private String userId;
    private String userName;
    private String categoryName;
    private String title;
    private String content;
    private Date createDate;
    private Date updateDate;
}
