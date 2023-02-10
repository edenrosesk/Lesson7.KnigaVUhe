package KnigaVUhe;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.time.Duration;

public abstract class AbstractTest {

    static EventFiringWebDriver eventDriver;

    @BeforeAll
    static void init(){
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--incognito");
        //options.addArguments("--headless");
        options.addArguments("start-maximized");
        //webDriver = new FirefoxDriver(options);
        //webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        eventDriver = new EventFiringWebDriver(new FirefoxDriver(options));
        eventDriver.register(new MyWebDriverEventListener());
        eventDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

    }

    @BeforeEach
    void goTo(){
        Assertions.assertDoesNotThrow( ()-> eventDriver.navigate().to("https://knigavuhe.org"),
                "Страница не доступна");
    }

    @AfterAll
    public static void exit(){

        if(eventDriver !=null) eventDriver.quit();
    }

    public WebDriver getWebDriver(){
        return this.eventDriver;
    }
}

