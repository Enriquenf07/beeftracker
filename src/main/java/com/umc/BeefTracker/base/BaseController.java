package com.umc.BeefTracker.base;

import com.umc.BeefTracker.auth.model.Usuario;
import com.umc.BeefTracker.auth.service.MenuService;
import org.springframework.ui.Model;

public abstract class BaseController {
    private final MenuService menuService;

    public BaseController(MenuService menuService) {
        this.menuService = menuService;
    }
    public void configModel(Model model, Usuario usuario){
        model.addAttribute("menus", menuService.getMenus(usuario));
    }

}
