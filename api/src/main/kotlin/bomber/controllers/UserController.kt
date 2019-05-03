package bomber.controllers

import bomber.exception.ResourceNotFoundException
import bomber.models.User
import bomber.repository.UserRepository
import bomber.security.CurrentUser
import bomber.security.UserPrincipal
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

/**
 * Controller to manipulate user information
 * and get current login user
 * @author kostya05983
 */
@RestController
class UserController {

    @Autowired
    private val userRepository: UserRepository? = null

    @GetMapping("/user/me")
    @PreAuthorize("hasRole('USER')")
    fun getCurrentUser(@CurrentUser userPrincipal: UserPrincipal): User {
        return userRepository!!.findById(userPrincipal.getId())
                .orElseThrow<RuntimeException> { ResourceNotFoundException("User", "id", userPrincipal.getId()!!) }
    }
}