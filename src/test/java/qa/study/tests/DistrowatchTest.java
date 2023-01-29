package qa.study.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import qa.study.base.BaseTest;
import qa.study.pages.data.DistrowatchPage;

import static com.codeborne.selenide.Selenide.open;

public class DistrowatchTest extends BaseTest {

    @ValueSource(strings = {"Mint", "Manjaro", "MX Linux", "Fedora", "Ubuntu"})
    @ParameterizedTest
    @DisplayName("Дистрибутив {0} должен стоять на первом месте по популярности")
    public void distShouldBeOnFirstPlaceByPopularity(String distrName) {
        open("https://distrowatch.com");
        DistrowatchPage distrowatchPage = new DistrowatchPage();
        distrowatchPage.checkFirstPlace(distrName);
    }

}
