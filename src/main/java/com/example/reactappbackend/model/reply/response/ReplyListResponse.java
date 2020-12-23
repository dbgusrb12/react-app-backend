package com.example.reactappbackend.model.reply.response;

import lombok.Builder;
import lombok.Data;

import java.sql.Date;
import java.util.List;

@Data
@Builder
public class ReplyListResponse {
    private List<Reply> replyList;

    @Data
    @Builder
    public static class Reply {
        private Integer replyId;
        private String userId;
        private String userName;
        private Integer boardId;
        private String content;
        private Integer commentCount;
        private Date createDate;
        private Date updateDate;
    }
}
