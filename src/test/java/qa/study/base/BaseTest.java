package qa.study.base;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class BaseTest {
    public void setUp() {
        Configuration.browser = "chrome";
        Configuration.browserSize = "1366x768";
        Configuration.pageLoadStrategy = "eager";
    }

    @AfterEach
    public void tearDown() {
        closeWebDriver();
    }
}
