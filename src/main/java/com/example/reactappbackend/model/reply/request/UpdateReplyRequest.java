package com.example.reactappbackend.model.reply.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UpdateReplyRequest {
    private String content;
}
