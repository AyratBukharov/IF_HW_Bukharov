package ru.ifellow.bukharov.ifellowEduJira.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

/**
 * Страница авторизации
 */
public class AuthenticationPage {

    private final SelenideElement userLogin = $x("//input[@id='login-form-username']")
            .as("Вход в систему: поле 'Имя пользователя'");

    private final SelenideElement userPassword = $x("//input[@id='login-form-password']")
            .as("Вход в систему: поле 'Пароль'");

    private final SelenideElement button = $x("//input[@id='login']")
            .as("Вход в систему: кнопка 'Войти'");

    /**
     * Метод авторизации на сайте
     */
    public DashboardPage authentication(String login, String password) {
        userLogin.shouldBe(Condition.visible).setValue(login);
        userPassword.shouldBe(Condition.visible).setValue(password);
        button.shouldBe(Condition.enabled).click();
        return new DashboardPage().shouldBeOpened();
    }
}
