package bomber.security

import bomber.exception.ResourceNotFoundException
import bomber.repository.IUserRepository
import kotlinx.coroutines.runBlocking
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.transaction.annotation.Transactional

/**
 * @author Konstantin Volivach
 */
@Service
class CustomUserDetailsService(
    private val userRepository: IUserRepository
) : UserDetailsService {

    @Transactional
    @Throws(UsernameNotFoundException::class)
    override fun loadUserByUsername(email: String): UserDetails {
        val user = runBlocking {
            userRepository.findByEmail(email)
                .orElseThrow { UsernameNotFoundException("User not found with email : $email") }
        }
        return UserPrincipal.create(user)
    }

    @Transactional
    suspend fun loadUserById(id: Long): UserDetails {
        val user = userRepository.findById(id)
            .orElseThrow<RuntimeException> { ResourceNotFoundException("User", "id", id as Any) }

        return UserPrincipal.create(user)
    }
}