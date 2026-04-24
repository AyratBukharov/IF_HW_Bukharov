package ru.ifellow.bukharov.ifellowEduJira.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class BrowsePage {

    private final SelenideElement search = $x("//input[@class='search-entry text medium-field ajs-dirty-warning-exempt']")
            .as("Строка поиска");

    private final SelenideElement searchButton = $x("//button[@original-title='Поиск задач']")
            .as("Кнопка 'Поиск");

    private final SelenideElement sorted = $x("//div[@class='order-by-fields']")
            .as("Сортировать по ...");

    private final SelenideElement choseCreated = $x("//label[@class='item-label checkbox' and @title='Cоздано']")
            .as("Выбрать 'Создано'");

    private final SelenideElement sortedOldButton = $x("//a[@class='order-by aui-button']")
            .as("Отсортировать по 'Создано'");

    private final SelenideElement status = $x("//span[@id='status-val']")
            .as("Статус задачи");

    private final SelenideElement version = $x("//span[@id='fixVersions-field']")
            .as("Исправить в версиях");

    public BrowsePage inputSearchText(String searchText) {
        search.shouldBe(Condition.visible).setValue(searchText);
        return this;
    }

    public BrowsePage clickSearchButton() {
        searchButton.shouldBe(Condition.visible).click();
        return this;
    }

    public BrowsePage openOrderByDropdown() {
        sorted.shouldBe(Condition.visible).click();
        return this;
    }

    public BrowsePage selectCreatedFilter() {
        choseCreated.shouldBe(Condition.visible).click();
        return this;
    }

    public void clickOrderByCreated() {
        sortedOldButton.shouldBe(Condition.visible).click();
    }

    public String getStatus() {
        return status.shouldBe(Condition.visible).getText();
    }

    public String getVersion() {
        return version.shouldBe(Condition.visible).getText();
    }
}
