package io.github.m_moris.azuread.simple.web.controller;

import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index(final Model model, final OAuth2AuthenticationToken token) {
        return "index";
    }

    @GetMapping("/home")
    public String home(final Model model, final OAuth2AuthenticationToken token) {
        return "index";
    }
}