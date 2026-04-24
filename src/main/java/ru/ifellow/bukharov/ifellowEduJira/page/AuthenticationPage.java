package ru.ifellow.bukharov.ifellowEduJira.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.SetValueOptions.withText;

public class AuthenticationPage {

    private final SelenideElement userLogin = $x("//input[@id='login-form-username']")
            .as("Вход в систему: поле 'Имя пользователя'");

    private final SelenideElement userPassword = $x("//input[@id='login-form-password']")
            .as("Вход в систему: поле 'Пароль'");

    private final SelenideElement button = $x("//input[@id='login']")
            .as("Вход в систему: кнопка 'Войти'");

    public AuthenticationPage setLogin(String login) {
        userLogin.shouldBe(Condition.visible).setValue(login);
        return this;
    }

    public AuthenticationPage setPassword(String password) {
        userPassword.shouldBe(Condition.visible).setValue(withText(password).sensitive());
        return this;
    }

    public void clickLoginButton() {
        button.shouldBe(Condition.enabled).click();
    }
}
