package ru.ifellow.bukharov.ifellowEduJira.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class DashboardPage {

    private final SelenideElement profile = $x("//span[@class='aui-avatar aui-avatar-small']")
            .as("Пользовательский профиль (аватарка)");

    private final SelenideElement projects = $x("//a[@id='browse_link']")
            .as("Раздел 'Проекты'");

    private final SelenideElement test = $x("//a[@id='admin_main_proj_link_lnk']")
            .as("Текущие проекты: Test (TEST)");

    private final SelenideElement createButton = $x("//a[@id='create_link']")
            .as("Кнопка создания задачи");

    public boolean isProfileDisplayed() {
        profile.shouldBe(Condition.visible);
        return profile.isDisplayed();
    }

    public DashboardPage clickProjects() {
        projects.shouldBe(Condition.visible).click();
        return this;
    }

    public void clickTestProject() {
        test.shouldBe(Condition.visible).click();
    }

    public void clickCreateTask() {
        createButton.shouldBe(Condition.visible).click();
    }
}
