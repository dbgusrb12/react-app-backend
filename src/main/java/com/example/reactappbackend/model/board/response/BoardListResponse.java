package com.example.reactappbackend.model.board.response;

import lombok.Builder;
import lombok.Data;

import java.sql.Date;
import java.util.List;

@Data
@Builder
public class BoardListResponse {
    private List<Board> boardList;

    @Data
    @Builder
    public static class Board {
        private Integer boardId;
        private String userId;
        private String userName;
        private String categoryName;
        private String title;
        private Date createDate;
    }
}
