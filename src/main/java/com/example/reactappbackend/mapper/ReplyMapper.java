package com.example.reactappbackend.mapper;

import com.example.reactappbackend.model.dto.Reply;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ReplyMapper {

    List<Reply> replyList(Integer boardId);
}
