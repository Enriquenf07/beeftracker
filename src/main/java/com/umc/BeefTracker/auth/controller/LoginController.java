package com.umc.BeefTracker.auth.controller;

import com.umc.BeefTracker.auth.service.MenuService;
import com.umc.BeefTracker.base.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/login")
public class LoginController extends BaseController {
    public LoginController(MenuService menuService) {
        super(menuService);
    }

    @GetMapping
    public String login(Model model, @RequestParam(name = "error", required = false) boolean error) {
        model.addAttribute("error", error);
        return "/pages/login/index";
    }


}
