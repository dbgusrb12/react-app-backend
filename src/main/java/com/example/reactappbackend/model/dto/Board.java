package com.example.reactappbackend.model.dto;

import com.example.reactappbackend.utils.Paging;
import lombok.Data;

import java.sql.Date;
import java.util.List;

@Data
public class Board extends Paging {
    private Integer boardId;
    private String userId;
    private String userName;

    private int auth;

    private Integer categoryId;
    private String categoryName;
    private String title;
    private String content;
    private Integer isPublic;
    private Date createDate;
    private Date updateDate;
}
