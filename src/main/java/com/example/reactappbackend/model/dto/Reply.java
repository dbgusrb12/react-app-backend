package com.example.reactappbackend.model.dto;

import com.example.reactappbackend.utils.Paging;
import lombok.Data;

import java.sql.Date;

@Data
public class Reply extends Paging {
    private Integer replyId;
    private String userId;
    private String userName;
    private Integer parentId;       // 댓글, 대댓글 부모 id
    private String content;
    private Integer replyType;      // 댓글, 대댓글 flag ( 0 = 댓글, 1 = 대댓글)
    private Integer commentCount;   // 댓글일때 대댓글 개수
    private Date createDate;
    private Date updateDate;
}
