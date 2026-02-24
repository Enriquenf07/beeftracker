package com.umc.BeefTracker.auth.dto;

import java.util.List;

public record Menu(List<String> roles, String id, String descricao, String path, String icon){}

