package com.example.reactappbackend.model.board.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class InsertBoardResponse {
    private Integer boardId;
}
