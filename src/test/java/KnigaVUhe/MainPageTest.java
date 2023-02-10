package KnigaVUhe;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MainPageTest extends AbstractTest {

    @Test
    @DisplayName("Кнопка Жанры в header страницы")
    @Description("Переход в категорию жанры с помощью кнопки в header")
    @Severity(SeverityLevel.NORMAL)
    void clickToGenres(){
        new MainPage(getWebDriver()).goToGenresPage();
        Assertions.assertEquals("https://knigavuhe.org/genres/", getWebDriver().getCurrentUrl());
    }

    @Test
    @DisplayName("Кнопка Авторы в header страницы")
    @Description("Переход в категорию авторы с помощью кнопки в header")
    @Severity(SeverityLevel.NORMAL)
    void clickToAuthors(){
        new MainPage(getWebDriver()).goToAuthorsPage();
    }

    @Test
    @DisplayName("Кнопка Исполнители в header страницы")
    @Description("Переход в категорию исполнители с помощью кнопки в header")
    @Severity(SeverityLevel.NORMAL)
    void clickToReaders(){
        new MainPage(getWebDriver()).goToReadersPage();
    }

    @Test
    @DisplayName("Кнопка логотипа в header страницы")
    @Description("Переход на главную страницу с помощью кнопки в header")
    @Severity(SeverityLevel.NORMAL)
    void clickToLogo(){
        new MainPage(getWebDriver()).goToMainPage();
    }
}

