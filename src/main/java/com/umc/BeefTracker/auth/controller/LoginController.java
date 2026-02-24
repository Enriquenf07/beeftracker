package com.umc.BeefTracker.auth.controller;

import com.umc.BeefTracker.auth.model.Usuario;
import com.umc.BeefTracker.auth.service.MenuService;
import com.umc.BeefTracker.base.BaseController;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class LoginController extends BaseController {
    public LoginController(MenuService menuService) {
        super(menuService);
    }

    @GetMapping("login")
    public String login(Model model, @RequestParam(name = "error", required = false) boolean error) {
        model.addAttribute("error", error);
        return "login";
    }

    @GetMapping("")
    public String teste(Model model, @AuthenticationPrincipal Usuario usuario) {
        configModel(model, usuario);
        model.addAttribute("mensagem", "Bem-vindo ao Thymeleaf!");
        return "teste";
    }

}
