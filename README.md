# IF_HW_Bukharov
## ДЗ №6

## Описание

Проект с UI автотестами на Java в рамках ДЗ №6.

## Тесты
* Аутентификация
* Переход в проект 'Test'
* Проверка увеличения счётчика при создании новой задачи
* Переход в задачу TestSeleniumATHomework и проверка статуса и версии
* Создание нового бага(задачи) с заполнением полей


---

## Стек технологий

* Maven
* Java 25
* JUnit 5
* Lombok
* Selenide
* Allure
* AspectJ

---

## Запуск тестов

Запуск всех тестов:

```bash
mvn clean test -Dgroups=DZ6
```
или параллельный запуск всех тестов:

```bash
mvn clean test -Dgroups=DZ6 -Djunit.jupiter.execution.parallel.enabled=true

```

---

## Allure отчёт

### Сгенерировать отчёт:

```bash
mvn allure:report
```

Отчёт будет доступен по пути:

```
target/site/allure-maven-plugin/index.html
```

---

### Открыть отчёт в браузере:

```bash
mvn allure:serve
```

После выполнения откроется локальный сервер с отчётом (например http://127.0.0.1:10650)

## Запуск через IntelliJ IDEA

Можно запустить тесты и собрать отчёт через Maven панель в IntelliJ:

1. Открыть правую панель **Maven**
2. Перейти в раздел **Plugins**
3. Найти:

    * `allure → allure:report` — генерация отчёта
    * `allure → allure:serve` — запуск отчёта
