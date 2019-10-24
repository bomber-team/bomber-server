package bomber.repository

import bomber.models.User
import org.springframework.stereotype.Component
import java.util.*

@Component
class UserRepository : IUserRepository {
    override suspend fun findById(id: Long): Optional<User> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun findByEmail(email: String): Optional<User> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun existsByEmail(email: String): Boolean? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}