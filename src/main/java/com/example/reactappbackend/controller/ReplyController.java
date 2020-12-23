package com.example.reactappbackend.controller;

import com.example.reactappbackend.model.reply.response.ReplyListResponse;
import com.example.reactappbackend.service.ReplyService;
import com.example.reactappbackend.utils.response.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/reply")
@RequiredArgsConstructor
public class ReplyController {
    private final ReplyService replyService;

    @GetMapping(value = "/{boardId}")
    public Response<ReplyListResponse> replyList(@PathVariable Integer boardId) {
        ReplyListResponse replyListResponse = replyService.replyList(boardId);
        return new Response<>(replyListResponse);
    }
}
