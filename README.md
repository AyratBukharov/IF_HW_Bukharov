# IF_HW_Bukharov
## ДЗ №7

## Описание

Проект с API автотестами на Java в рамках ДЗ №7.

## Тесты
* Тест по сериалу Рик и Морти
* Тест на регистрацию, авторизацию, выход из учётки

---

## Стек технологий

* Maven
* Java 25
* JUnit 5
* Lombok
* Allure
* AspectJ
* REST Assured
* Cucumber
* Cucumber-PicoContainer
* Jackson Databind

---

## Проверить соответствие шагов без запуска тестов
```bash
mvn clean test -Dcucumber.execution.dry-run=true
```

## Запуск тестов

Запуск всех тестов:

```bash
mvn clean test
```

Запуск теста сервера (регистрация, авторизация, выход из учётки)
```bash
mvn clean test -Dcucumber.filter.tags=@auth
```
Запуск теста по сериалу Рик и Морти
```bash
mvn clean test -Dcucumber.filter.tags=@rickandmorty
```

Запуск всех позитивных сценариев
```bash
mvn clean test -Dcucumber.filter.tags=@positive
```

Запуск всех негативных сценариев
```bash
mvn clean test -Dcucumber.filter.tags=@negative
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