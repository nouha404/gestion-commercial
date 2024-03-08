package com.ism.ismecom.security.controllers.Impl;

import com.ism.ismecom.security.controllers.Security;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class SecurityImpl implements Security {
    @Override
    public String login() {
        return "Security/login";
    }
}
