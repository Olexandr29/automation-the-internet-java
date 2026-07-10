package testData;

public final class LoginData {

    private LoginData() {
    }

    public static final String
            VALID_USERNAME = "tomsmith",
            VALID_PASSWORD = "SuperSecretPassword!",
            INVALID_USERNAME = "johndou",
            INVALID_PASSWORD = "dayofbirth01.02.03",
            URL_SECURE_PAGE = "https://the-internet.herokuapp.com/secure",
            URL_LOGIN_PAGE = "https://the-internet.herokuapp.com/login",
            WELCOME_MESSAGE = "Welcome to the Secure Area. When you are done click logout below.",
            ALERT_SUCCESSFUL_LOGIN = "You logged into a secure area!",
            ALERT_LOGOUT = "You logged out of the secure area!",
            ALERT_INVALID_USERNAME = "Your username is invalid!",
            ALERT_INVALID_PASSWORD = "Your password is invalid!",
            SQL_INJECTION = "' OR '1'='1",
            XSS_CROSS_SITE_SCRIPT = "<script>alert('xss')</script>";


}
