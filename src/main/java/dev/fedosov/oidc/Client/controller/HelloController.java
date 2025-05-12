package dev.fedosov.oidc.Client.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("/hello")
    public String getHello(Model model, Authentication authentication, @RegisteredOAuth2AuthorizedClient("my_authorization_server") OAuth2AuthorizedClient client) {
        String accessToken = client.getAccessToken().getTokenValue();

        model.addAttribute("accessToken", accessToken);
        model.addAttribute("username", authentication.getName());
        model.addAttribute("authorities", authentication.getAuthorities());
        return "hello";
    }
}
