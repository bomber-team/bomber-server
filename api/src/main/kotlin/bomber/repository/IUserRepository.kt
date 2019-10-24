package bomber.repository

import bomber.models.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

interface IUserRepository {
    suspend fun findById(id: Long): Optional<User>

    suspend fun findByEmail(email: String): Optional<User>

    suspend fun existsByEmail(email: String): Boolean?

    suspend fun saveUser(user: User): User
}