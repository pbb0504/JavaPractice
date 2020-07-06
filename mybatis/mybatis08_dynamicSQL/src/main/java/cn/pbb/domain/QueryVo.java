package cn.pbb.domain;

import lombok.Data;

import java.util.List;

/**
 * @author: pbb
 * @date: 2020/6/27 14:34
 */
@Data
public class QueryVo {
   private User user;
   private List<Integer> idList;
}
