package bomber.security.oauth2.user

import bomber.models.AuthProvider


class OAuth2UserInfoFactory {

    companion object {
        fun getOAuth2UserInfo(registrationId: String, attributes: Map<String, Any>): OAuth2UserInfo? {
            return when {
                registrationId.equals(AuthProvider.GOOGLE.text, ignoreCase = true) -> GoogleOAuth2UserInfo(attributes)
                registrationId.equals(AuthProvider.FACEBOOK.text, ignoreCase = true) -> FacebookOAuth2UserInfo(attributes)
                registrationId.equals(AuthProvider.GITHUB.text, ignoreCase = true) -> GithubOAuth2UserInfo(attributes)
                //here was eception
                else -> null
            }
        }
    }


}