package com.example.reactappbackend.service;

import com.example.reactappbackend.mapper.ReplyMapper;
import com.example.reactappbackend.model.dto.Reply;
import com.example.reactappbackend.model.reply.request.InsertReplyRequest;
import com.example.reactappbackend.model.reply.request.UpdateReplyRequest;
import com.example.reactappbackend.model.reply.response.ReplyListResponse;
import com.example.reactappbackend.utils.exception.Error;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.example.reactappbackend.utils.exception.ErrorCode.*;

@Service
@RequiredArgsConstructor
public class ReplyService {
    private final ReplyMapper replyMapper;

    public ReplyListResponse replyList(Integer parentId, Integer replyType) {
        Reply filterReply = new Reply();
        filterReply.setParentId(parentId);
        filterReply.setReplyType(replyType);
        filterReply.setTotalCount(replyMapper.replyListCount(filterReply));
        filterReply.setPaging();
        List<Reply> replyList = replyMapper.replyList(filterReply);

        return ReplyListResponse.builder()
                .replyList(
                        replyList.stream().map(
                                reply -> ReplyListResponse.Reply.builder()
                                        .replyId(reply.getReplyId())
                                        .userId(reply.getUserId())
                                        .userName(reply.getUserName())
                                        .parentId(reply.getParentId())
                                        .content(reply.getContent())
                                        .commentCount(reply.getCommentCount())
                                        .createDate(reply.getCreateDate())
                                        .updateDate(reply.getUpdateDate())
                                        .build())
                        .collect(Collectors.toList()))
                .hasNext(filterReply.isHasNext())
                .build();
    }

    public void insertReply(InsertReplyRequest insertReplyRequest) {
        Reply reply = new Reply();
        reply.setUserId(insertReplyRequest.getUserId());
        reply.setParentId(insertReplyRequest.getParentId());
        reply.setContent(insertReplyRequest.getContent());
        reply.setReplyType(insertReplyRequest.getReplyType());

        try {
            replyMapper.insertReply(reply);
        } catch (Exception e) {
            throw Error.of(JdbcError, e.getMessage());
        }
    }

    public void updateReply(Integer replyId, UpdateReplyRequest updateReplyRequest) {
        Reply reply = new Reply();
        reply.setReplyId(replyId);
        reply.setContent(updateReplyRequest.getContent());
        try {
            replyMapper.updateReply(reply);
        } catch (Exception e) {
            throw Error.of(JdbcError, e.getMessage());
        }
    }

    public void deleteReply(Integer replyId) {
        try {
            replyMapper.deleteReply(replyId);
        } catch (Exception e) {
            throw Error.of(JdbcError, e.getMessage());
        }
    }

}
