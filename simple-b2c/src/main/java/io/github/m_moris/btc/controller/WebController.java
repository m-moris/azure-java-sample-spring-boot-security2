// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package io.github.m_moris.btc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {
 

    @GetMapping(value = "/")
    public String index(final Model model) {
        return "index";
    }

    @GetMapping(value = "/home")
    public String home(final Model model) {
        return "index";
    }
}
