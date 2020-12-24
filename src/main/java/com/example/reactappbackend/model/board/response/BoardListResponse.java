package com.example.reactappbackend.model.board.response;

import com.example.reactappbackend.utils.Paging;
import lombok.Builder;
import lombok.Data;

import java.sql.Date;
import java.util.List;

@Data
@Builder
public class BoardListResponse {
    private boolean hasNext;
    private boolean hasPrevious;
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
