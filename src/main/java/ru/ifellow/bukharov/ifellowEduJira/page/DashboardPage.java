package ru.ifellow.bukharov.ifellowEduJira.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.page;

/**
 * Страница рабочего стола
 */
public class DashboardPage {

    private final SelenideElement profile = $x("//span[@class='aui-avatar aui-avatar-small']")
            .as("Пользовательский профиль (аватарка)");

    private final SelenideElement projects = $x("//a[@id='browse_link']")
            .as("Раздел 'Проекты'");

    private final SelenideElement test = $x("//a[@id='admin_main_proj_link_lnk']")
            .as("Текущие проекты: Test (TEST)");

    private final SelenideElement create = $x("//a[@id='create_link']")
            .as("Кнопка создания задачи");

    /**
     * Проверка, что страница открыта
     *
     * @return текущий объект страницы
     */
    public DashboardPage shouldBeOpened() {
        profile.shouldBe(Condition.visible);
        return this;
    }

    /**
     * Проверяет факт открытия страницы.
     *
     * @return true, если страница отображается
     */
    public boolean isOpened() {
        return profile.isDisplayed();
    }


    /**
     * Переход в проект 'Test'.
     */
    public ProjectPage goToTest() {
        projects.shouldBe(Condition.visible).click();
        test.shouldBe(Condition.visible).click();
        return page(ProjectPage.class).shouldBeOpened();
    }

    /**
     * Окно создания задачи
     */
    public CreateTaskPage openCreateTask() {
        create.shouldBe(Condition.visible).click();
        return page(CreateTaskPage.class);
    }
}
