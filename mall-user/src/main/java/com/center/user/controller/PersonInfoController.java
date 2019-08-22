package com.center.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author human
 * @since 2019-08-22
 */
@RestController
@RequestMapping("/personinfo")
public class PersonInfoController {
    @GetMapping("index")
    public String index() {
        return "欢迎访问";
    }
}
