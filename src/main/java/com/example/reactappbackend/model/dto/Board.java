package com.example.reactappbackend.model.dto;

import lombok.Data;

import java.sql.Date;
import java.util.List;

@Data
public class Board {
    private Integer boardId;
    private String userId;
    private String userName;
    private Integer categoryId;
    private String categoryName;
    private String title;
    private String content;
    private Integer isPublic;
    private Date createDate;
    private Date updateDate;
    private List<Reply> replyList;
}
