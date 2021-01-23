package com.example.demo.controller;

import com.example.demo.vo.User;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Controller
public class ShowUser {
    @GetMapping(value = "getUser")
    public String getUser(Model model) {
        User user = new User();
        user.setId(111L);
        user.setBirthday(new Date());
        user.setName("name");
        user.setSex(1);
        model.addAttribute("user", user);
        return "getUser";
    }

    @GetMapping(value = "/user/set")
    public String set(Model model) {
        Set<String> names = new HashSet<>();
        List<Integer> ids = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            names.add("username: " + i);
            ids.add(i);
        }
        model.addAttribute("names",names);
        model.addAttribute("ids",ids);
        model.addAttribute("date",new Date());
        return "user_set";
    }

    @GetMapping(value = "/pathHandle")
    public String pathHandle(Model model) {
        return "path_handle";
    }

    @GetMapping(value = "/inner")
    public String inner(Model model, HttpServletRequest request) {
        request.setAttribute("requestMessage", "springboot-request");
        request.getSession().setAttribute("sessionMessage", "springboot-session");
        request.getServletContext().setAttribute("applicationMessage",
                "springboot-application");
        model.addAttribute("url", "www.baidu.cn");
        request.setAttribute("url2",
                "<span style='color:red'>www.baidu.cn</span>");
        return "show_inner";
    }
}
