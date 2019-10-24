package bomber.controllers

import bomber.exception.BadRequestException
import bomber.models.AuthProvider
import bomber.models.User
import bomber.payload.ApiResponse
import bomber.payload.AuthResponse
import bomber.payload.LoginRequest
import bomber.payload.SignUpRequest
import bomber.repository.IUserRepository
import bomber.security.TokenProvider
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.servlet.support.ServletUriComponentsBuilder
import javax.validation.Valid


/**
 * Controller is used for auth
 * @author kostya05983
 */
@RestController
@RequestMapping("/auth")
class AuthController {
    companion object {
        const val LOGIN = "login"
        const val SIGN_UP = "signup"
    }

    @Autowired
    private val authenticationManager: AuthenticationManager? = null

    @Autowired
    private val IUserRepository: IUserRepository? = null

    @Autowired
    private val passwordEncoder: PasswordEncoder? = null

    @Autowired
    private val tokenProvider: TokenProvider? = null

    @PostMapping(LOGIN)
    fun authenticateUser(@Valid @RequestBody loginRequest: LoginRequest): ResponseEntity<*> {
        val authentication = authenticationManager!!.authenticate(
                UsernamePasswordAuthenticationToken(
                        loginRequest.getEmail(),
                        loginRequest.getPassword()
                )
        )

        SecurityContextHolder.getContext().authentication = authentication

        val token = tokenProvider!!.createToken(authentication)
        return ResponseEntity.ok<Any>(AuthResponse(token))
    }

    @PostMapping(SIGN_UP)
    fun registerUser(@Valid @RequestBody signUpRequest: SignUpRequest): ResponseEntity<*> {
        if (IUserRepository!!.existsByEmail(signUpRequest.getEmail()!!)!!) {
            throw BadRequestException("Email address already in use.")
        }

        // Creating user's account
        val user = User()
        user.name = signUpRequest.getName()!!
        user.email = signUpRequest.getEmail()!!
        user.password = signUpRequest.getPassword()
        user.provider = AuthProvider.LOCAL

        user.password = passwordEncoder!!.encode(user.password)

        val result = IUserRepository.save(user)

        val location = ServletUriComponentsBuilder
                .fromCurrentContextPath().path("/user/me")
                .buildAndExpand(result.id).toUri()

        return ResponseEntity.created(location)
                .body<Any>(ApiResponse(true, "User registered successfully@"))
    }
}