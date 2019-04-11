package hx.insist.service;

import hx.insist.pojo.Comment;

import java.util.List;

public interface CommentService {

    void addComment(Comment comment);
    List findAllByFid(String fid);

}
