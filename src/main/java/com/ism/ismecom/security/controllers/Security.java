package com.ism.ismecom.security.controllers;

import org.springframework.web.bind.annotation.GetMapping;

public interface Security {
    @GetMapping("/login")
    String login();
}
