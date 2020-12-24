package com.example.reactappbackend.mapper;

import com.example.reactappbackend.model.dto.Reply;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ReplyMapper {

    int replyListCount(Reply reply);

    List<Reply> replyList(Reply reply);

    void insertReply(Reply reply);

    void updateReply(Reply reply);

    void deleteReply(Integer replyId);

}
