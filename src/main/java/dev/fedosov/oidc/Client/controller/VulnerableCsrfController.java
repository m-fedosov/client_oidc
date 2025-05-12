package dev.fedosov.oidc.Client.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class VulnerableCsrfController {

    // POST /api/change-email
    @PostMapping("/change-email")
    public ResponseEntity<String> changeEmail(@RequestParam String email,
                                              @AuthenticationPrincipal OidcUser user) {
        // Эмулируем изменение email в профиле:
        String username = user.getPreferredUsername();
        // В реальности здесь обновление в БД...
        System.out.printf("User %s changed email to %s%n", username, email);
        return ResponseEntity.ok("Email успешно изменён на " + email);
    }
}
