package Page;

import com.microsoft.playwright.Page;

public class LoginPage extends PageBase {

    public LoginPage(Page page) {
        super(page);
    }

    // ===== Locators =====
    private final String username = "input[formcontrolname='email']";
    private final String password = "input[formcontrolname='password']";

    // يفضل عدم الاعتماد على المسافات
    private final String loginButton =
            "//button[text()=' تسجيل الدخول ']";

    // ===== Actions =====
    public void login(String email, String pass) {

        sendText(username, email);
        sendText(password, pass);
        clickButton(loginButton);
    }
}