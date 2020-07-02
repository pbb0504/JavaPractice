package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 13053
 */
public class Comment {
    private List<Comment> replyComments = new ArrayList<>();
    private Comment parentComment;
    private Long id;
    private String content;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<Comment> getReplyComments() {
        return replyComments;
    }

    public void setReplyComments(List<Comment> replyComments) {
        this.replyComments = replyComments;
    }

    public Comment getParentComment() {
        return parentComment;
    }

    public void setParentComment(Comment parentComment) {
        this.parentComment = parentComment;
    }

    public Comment() {

    }

    public Comment(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "replyComments=" + replyComments +
                ", id=" + id +
                '}';
    }
}
