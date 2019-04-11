package hx.insist.service;

import hx.insist.mapper.CommentMapper;
import hx.insist.pojo.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentMapper commentMapper;

    @Override
    public void addComment(Comment comment) {
        comment.setCid(UUID.randomUUID().toString());//设置ID
        comment.setCtime(new Date());//补充时间
        commentMapper.insert(comment);
    }

    @Override
    public List findAllByFid(String fid) {
        List<Comment> list = commentMapper.selectByFid(fid);
        if(list.isEmpty())
            return null;
        else
            return list;
    }
}
