package com.example.demo.controller;

import com.example.demo.vo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.*;

@Controller
public class UserController {
    @RequestMapping(value = "/user/map", method = RequestMethod.GET)
    public String map(Model model) {
        Map<String, User> allMembers = new HashMap<>();
        for (int x = 0; x < 10; x++) {
            User vo = new User();
            vo.setId(101L + x);
            vo.setName("赵四 - " + x);
            vo.setBirthday(new Date());
            allMembers.put("mldn-" + x, vo);
        }
        model.addAttribute("allUsers", allMembers);
        return "user_map";
    }

    @RequestMapping(value = "/user/list", method = RequestMethod.GET)
    public String list(Model model) {
        List<User> allMembers = new ArrayList<>();
        for (int x = 0; x < 10; x++) {
            User vo = new User();
            vo.setId(101L + x);
            vo.setName("赵四 - " + x);
            vo.setBirthday(new Date());
            allMembers.add(vo) ;
        }
        model.addAttribute("allUsers", allMembers);
        return "user_list";
    }

    @RequestMapping(value = "/footer", method = RequestMethod.GET)
    public String footer(Model model) {
        model.addAttribute("projectName", "谷歌");
        return "footer";
    }

}
