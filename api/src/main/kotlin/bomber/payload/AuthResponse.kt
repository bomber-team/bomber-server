package bomber.payload

class AuthResponse(accessToken: String) {
    private var accessToken: String? = accessToken
    private var tokenType = "Bearer"

    fun getAccessToken(): String? {
        return accessToken
    }

    fun setAccessToken(accessToken: String) {
        this.accessToken = accessToken
    }

    fun getTokenType(): String {
        return tokenType
    }

    fun setTokenType(tokenType: String) {
        this.tokenType = tokenType
    }
}