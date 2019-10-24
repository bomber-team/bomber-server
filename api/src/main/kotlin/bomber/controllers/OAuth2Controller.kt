package bomber.controllers

import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.security.oauth2.core.user.OAuth2User
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

@RestController
class OAuth2Controller {

    @GetMapping("/")
    fun index(@AuthenticationPrincipal oauth2User: Mono<OAuth2User>): Mono<String> {
        return oauth2User.map { it.name }.map { String.format("Hi %s", it) }
    }
}