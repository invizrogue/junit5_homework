package qa.study.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import qa.study.base.BaseTest;
import qa.study.pages.DistrowatchDistroPage;
import qa.study.pages.DistrowatchMainPage;
import qa.study.pages.data.Locale;

import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.Selenide.open;

public class DistrowatchTest extends BaseTest {

    @BeforeEach
    void getStarted() {
        setUp();
        open("https://distrowatch.com");
    }

    @Disabled
    @ValueSource(strings = {"Mint", "Manjaro", "MX Linux", "Fedora", "Ubuntu"})
    @DisplayName("Дистрибутив должен стоять на первом месте по популярности")
    @ParameterizedTest(name = "{index}: distrName = {0}")
    public void distShouldBeOnFirstPlaceByPopularity(String distrName) {
        DistrowatchMainPage distrowatchMainPage = new DistrowatchMainPage();
        distrowatchMainPage.checkFirstPlace(distrName);
    }

    @CsvSource({
            "MX Linux, MX Linux, https://mxlinux.org/, https://us-bz3.devzing.com/mx_antix/",
            "Mint, Linux Mint, https://linuxmint.com/, https://github.com/linuxmint",
            "Manjaro, Manjaro Linux, https://manjaro.org/, https://manjaro.org/feedback/",
            "Fedora, Fedora Linux, https://getfedora.org/, https://bugzilla.redhat.com/",
            "Ubuntu, Ubuntu, https://www.ubuntu.com/, https://bugs.launchpad.net/"
    })
    @DisplayName("Проверка наличия информации на странице дистрибутива")
    @ParameterizedTest(name = "{index}: Дистрибутив {1}")
    public void distrPageShouldContainsInformationAboutProjectUrlAndBugTrackerUrl(
        String distrName,
        String distribution,
        String projectUrl,
        String bugTrackerUrl
    ) {
        DistrowatchMainPage distrowatchMainPage = new DistrowatchMainPage();
        distrowatchMainPage.changeLocale("English").clickOnDistr(distrName);

        DistrowatchDistroPage distrowatchDistroPage = new DistrowatchDistroPage();
        distrowatchDistroPage.checkInfo(distribution, projectUrl, bugTrackerUrl);
    }

    @MethodSource("localeAndItems")
    @DisplayName("Проверка пунктов меню для заданной локали")
    @ParameterizedTest(name = "{index}: locale = {0}")
    void mainMenuShouldContainsAllOfItemsForGivenLocale(
            String locale,
            List<String> items
    ) {
        DistrowatchMainPage distrowatchMainPage = new DistrowatchMainPage();
        distrowatchMainPage.changeLocale(locale).checkMenuItems(items);
    }

    static Stream<Arguments> localeAndItems() {
        return Stream.of(
                Arguments.of(Locale.RU.value, List.of(
                        "Главная страница", "Заголовки", "Еженедельник DistroWatch", "Комментарии", "Пакеты",
                        "Управление пакетами", "Глоссарий", "FAQ", "Mobile Site", "Поиск", "Карта сайта",
                        "Ведущие дистрибутивы", "Предложить дистрибутив", "Ближайшие релизы", "О DistroWatch",
                        "Популярность страницы", "Реклама", "Торренты"
                )),
                Arguments.of(Locale.EN.value, List.of(
                        "Home Page", "Headlines", "DW Weekly", "Comments", "Packages", "Package Management",
                        "Glossary", "FAQ", "Mobile Site", "Search", "Sitemap", "Major Distributions",
                        "Submit Distribution", "Upcoming Releases", "About DistroWatch", "Page Hit Ranking",
                        "Advertise", "Torrent Downloads"
                ))
        );
    }
}
