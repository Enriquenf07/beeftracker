package com.umc.BeefTracker.core.controller;

import com.umc.BeefTracker.auth.model.Usuario;
import com.umc.BeefTracker.auth.service.MenuService;
import com.umc.BeefTracker.base.BaseController;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller("/")
public class HomeController extends BaseController {

    public HomeController(MenuService menuService) {
        super(menuService);
    }

    @GetMapping
    public String getHome(Model model, @AuthenticationPrincipal Usuario usuario) {
        configModel(model, usuario);
        return "/pages/home/index";
    }
}
