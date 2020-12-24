package com.example.reactappbackend.model.reply.request;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@Builder
public class InsertReplyRequest {
    @NotBlank(message = "userId is empty")
    private String userId;
    @NotNull(message = "parentId is null")
    private Integer parentId;
    @NotEmpty(message = "content is empty")
    private String content;
    @NotNull(message = "replyType is null")
    private Integer replyType;
}
