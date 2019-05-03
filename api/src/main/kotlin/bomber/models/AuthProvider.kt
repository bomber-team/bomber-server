package bomber.models

enum class AuthProvider(val text: String) {
    LOCAL("local"),
    FACEBOOK("facebook"),
    GOOGLE("google"),
    GITHUB("github");

    companion object {
        fun primaryValueOf(id: String): AuthProvider {
            return when (id) {
                LOCAL.text -> LOCAL
                FACEBOOK.text -> FACEBOOK
                GOOGLE.text -> GOOGLE
                GITHUB.text -> GITHUB
                else -> {
                    throw NoSuchFieldException("Not found such provider")
                }
            }
        }
    }

}