package bomber

import org.springframework.security.oauth2.provider.OAuth2Authentication
import org.springframework.security.authentication.TestingAuthenticationToken
import org.springframework.security.oauth2.provider.OAuth2Request
import org.springframework.test.web.servlet.request.RequestPostProcessor
import org.springframework.security.oauth2.provider.token.AuthorizationServerTokenServices
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class OAuthHelper {
    @Autowired
    private lateinit var tokenservice: AuthorizationServerTokenServices

    fun addBearerToken(username: String, vararg authorities: String): RequestPostProcessor {
        return RequestPostProcessor { mockRequest ->
            // Create OAuth2 token
            val oauth2Request = OAuth2Request(null, null, null, true, null, null, null, null, null)
            val userauth = TestingAuthenticationToken(username, null, *authorities)
            val oauth2auth = OAuth2Authentication(oauth2Request, userauth)
            val token = tokenservice.createAccessToken(oauth2auth)

            // Set Authorization header to use Bearer
            mockRequest.addHeader("Authorization", "Bearer " + token.value)
            mockRequest
        }
    }
}