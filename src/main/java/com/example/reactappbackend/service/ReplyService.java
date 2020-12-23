package com.example.reactappbackend.service;

import com.example.reactappbackend.mapper.ReplyMapper;
import com.example.reactappbackend.model.dto.Reply;
import com.example.reactappbackend.model.reply.response.ReplyListResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReplyService {
    private final ReplyMapper replyMapper;

    public ReplyListResponse replyList(Integer boardId) {
        List<Reply> replyList = replyMapper.replyList(boardId);

        return ReplyListResponse.builder()
                .replyList(
                        replyList.stream().map(
                                reply -> ReplyListResponse.Reply.builder()
                                        .replyId(reply.getReplyId())
                                        .userId(reply.getUserId())
                                        .userName(reply.getUserName())
                                        .boardId(reply.getParentId())
                                        .content(reply.getContent())
                                        .commentCount(reply.getCommentCount())
                                        .createDate(reply.getCreateDate())
                                        .updateDate(reply.getUpdateDate())
                                        .build())
                        .collect(Collectors.toList()))
                .build();
    }
}
