package com.umc.BeefTracker.auth.service;

import com.umc.BeefTracker.auth.dto.Menu;
import com.umc.BeefTracker.auth.model.Usuario;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MenuService {
    private final List<Menu> menuGeral = List.of(
            new Menu(List.of("all"), "home", "Home", "/", "house")
    );
    public List<Menu> getMenus(Usuario usuario) {
        List<String> rolesDoUsuario = getRoles(usuario);

        return menuGeral.stream()
                .filter(menu -> menu.roles().stream()
                        .anyMatch(roleMenu -> rolesDoUsuario.contains(roleMenu)))
                .collect(Collectors.toList());
    }

    public List<String> getRoles(Usuario usuario){
        return List.of("teste", "all");
    }
}

