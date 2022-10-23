package com.ustc.server.controller;

import com.ustc.server.utils.R;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: ffideal
 * @CreateTime: 2022-10-22  19:12
 * @Description: TODO
 * @Version: 1.0
 */
@RestController
@RequestMapping("/admin")
@CrossOrigin
public class LoginController {
    // login 登录
    @PostMapping("/login")
    public R login() {

        return R.ok().data("token","admin");
    }

    // info
    @GetMapping("/info")
    public R info() {
        return R.ok().data("roles","[admin]")
                .data("name","admin")
                .data("avatar","https://online-teach-file.oss-cn-beijing.aliyuncs.com/teacher/2019/10/30/65423f14-49a9-4092-baf5-6d0ef9686a85.png");
    }

}
