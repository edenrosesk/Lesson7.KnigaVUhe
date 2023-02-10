package KnigaVUhe;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SearchTest extends AbstractTest {

    @Test
    @DisplayName("Кнопка Поиск в header страницы")
    @Description("Проврка кнопки поиска")
    @Severity(SeverityLevel.MINOR)
    void searchTest(){
        SearchPage searchPage = new SearchPage(getWebDriver());
        searchPage.toSearch("Пушкин");
        //Assertions.assertEquals("Пушкин - Поиск на сайте по аудиокнигам, циклам, авторам и исполнителям", getWebDriver().getTitle(),"Не та страница");
        Assertions.assertTrue(getWebDriver().getCurrentUrl().contains("https://knigavuhe.org/search/?q=%D0%9F%D1%83%D1%88%D0%BA%D0%B8%D0%BD"));
        //Assertions.assertDoesNotThrow(() ->searchPage.takeItem(9));
    }
}