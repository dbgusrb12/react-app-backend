package com.example.reactappbackend.controller;

import com.example.reactappbackend.model.reply.request.InsertReplyRequest;
import com.example.reactappbackend.model.reply.request.UpdateReplyRequest;
import com.example.reactappbackend.model.reply.response.ReplyListResponse;
import com.example.reactappbackend.service.ReplyService;
import com.example.reactappbackend.utils.response.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/reply")
@RequiredArgsConstructor
public class ReplyController {
    private final ReplyService replyService;

    @GetMapping(value = "/{parentId}")
    public Response<ReplyListResponse> replyList(@PathVariable Integer parentId, @RequestParam Integer replyType) {
        ReplyListResponse replyListResponse = replyService.replyList(parentId, replyType);
        return new Response<>(replyListResponse);
    }

    @PostMapping
    public Response insertReply(@RequestBody InsertReplyRequest insertReplyRequest) {
        replyService.insertReply(insertReplyRequest);
        return Response.ok();
    }

    @PutMapping(value = "/{replyId}")
    public Response updateReply(@PathVariable Integer replyId, @RequestBody UpdateReplyRequest updateReplyRequest) {
        replyService.updateReply(replyId, updateReplyRequest);
        return Response.ok();
    }

    @DeleteMapping(value = "/{replyId}")
    public Response deleteReply(@PathVariable Integer replyId) {
        replyService.deleteReply(replyId);
        return Response.ok();
    }

}
