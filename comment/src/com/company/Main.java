package com.company;

import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author 13053
 */
public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        // write your code here

        Comment comment1 = new Comment();
        comment1.setId(1L);
        comment1.setParentComment(null);


        Comment comment2 = new Comment();
        comment2.setId(2L);
        comment2.setParentComment(comment1);


        Comment comment3 = new Comment();
        comment3.setId(3L);
        comment3.setParentComment(comment2);


        Comment comment4 = new Comment();
        comment4.setId(4L);
        comment4.setParentComment(null);




        /*Comment comment1 = new Comment();
        comment1.setId(1L);
        comment1.setContent("content of comment1");

        Comment comment2 = new Comment();
        comment2.setId(2L);
        comment2.setParentComment(comment1);
        comment2.setContent("content of comment2");

        Comment comment3 = new Comment();
        comment3.setId(3L);
        comment3.setParentComment(comment2);
        comment3.setContent("content of comment3");

        Comment comment4 = new Comment();
        comment4.setId(4L);
        comment4.setContent("content fo comment4");
        comment4.setParentComment(comment2);*/

        ArrayList<Comment> comments1 = new ArrayList<>();
        comments1.add(comment1);
        comments1.add(comment2);
        comments1.add(comment3);
        comments1.add(comment4);

        Iterator<Comment> it = comments1.iterator();
        while(it.hasNext()){
            Comment comment = it.next();
            System.out.println(comment);
        }

        comments1 = commentFactory2(comments1);

        Iterator iterator = comments1.iterator();
        while (iterator.hasNext()) {
            Object next = iterator.next();
            System.out.println("父评论：" + next);
            Method aa = next.getClass().getMethod("getReplyComments");
            ArrayList<Comment> sons = new ArrayList<>();
            sons = (ArrayList<Comment>) aa.invoke(next, null);
            Iterator iterator1 = sons.iterator();
            while (iterator1.hasNext()) {
                Object o = iterator1.next();
                Method bb = o.getClass().getMethod("getReplyComments");
                ArrayList<Comment> sons2 = (ArrayList<Comment>) bb.invoke(o,null);
                System.out.println(next + "的子评论：" + o + sons2);
            }
        }
    }

    public static ArrayList<Comment> commentFactory(ArrayList<Comment> before) {
        ArrayList<Comment> result = new ArrayList<>();
        ArrayList<Comment> sonComments = new ArrayList<>();
        ArrayList<Comment> replyComments = new ArrayList<>();
        Iterator<Comment> iterator = before.iterator();
        while (iterator.hasNext()) {
            Comment next = iterator.next();
            if (next.getParentComment() == null) {
                result.add(next);
                next.setReplyComments(replyComments);
            } else {
                sonComments.add(next);
            }
        }

        // 到此没问题
        for (Comment e :
                sonComments) {
            System.out.println("sonComments: " + e);
        }
        for (Comment e :
                result) {
            System.out.println("result: " + e + e.getReplyComments());
        }

        Iterator<Comment> iterator1 = sonComments.iterator();
        while (iterator1.hasNext()) {
            // 子评论
            Comment next = iterator1.next();

            Iterator<Comment> iterator2 = result.iterator();

            System.out.println("当前子评论：" + next + "父评论的id：" + next.getParentComment().getId());

            while (iterator2.hasNext()) {
                // 父评论
                Comment next2 = iterator2.next();
                if (next.getParentComment().getId().equals(next2.getId())) {
                    System.out.println("当前比较 子：" + next.getParentComment().getId());
                    System.out.println("当前比较 父" + next2.getId());
                    next2.getReplyComments().add(next);
                }
            }
        }
        return result;
    }

    public static ArrayList<Comment> commentFactory2(ArrayList<Comment> before) {
        ArrayList<Comment> result;
        Iterator<Comment> iterator = before.iterator();
        while (iterator.hasNext()) {
            Comment comment = iterator.next();
            if (comment.getParentComment() == null) {
                ArrayList<Comment> init = new ArrayList<>();
                comment.setReplyComments(init);
            }
            if (comment.getParentComment() != null) {
                // 如果发现有父评论,找到父评论
                comment.getParentComment().getReplyComments().add(comment);
            }
        }
        result = before;
        Iterator<Comment> it = result.iterator();
        while(it.hasNext()){
            Comment comment = it.next();
            if(comment.getParentComment() != null){
                it.remove();
            }
        }
        return result;
    }


}
