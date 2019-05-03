package bomber.security.oauth2.user


abstract class OAuth2UserInfo(var attributes: Map<String, Any>) {

    public abstract fun getId(): String;

    public abstract fun getName(): String;

    public abstract fun getEmail(): String;
}