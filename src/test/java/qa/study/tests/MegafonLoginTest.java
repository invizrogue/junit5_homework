package qa.study.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import qa.study.base.BaseTest;
import qa.study.pages.MegafonLoginPage;

import static com.codeborne.selenide.Selenide.open;

public class MegafonLoginTest extends BaseTest {

    @BeforeEach
    void getStarted() {
        setUp();
        open("https://lk.megafon.ru/login");
    }

    @ValueSource(strings = {"9210000000", "9270000000", "9990000000"})
    @DisplayName("Поле ввода номера телефона допускает введённый номер")
    @ParameterizedTest(name = "{index} телефон = {0}")
    void phoneFieldShouldAcceptGivenPhoneNumber(String phoneNumber) {
        MegafonLoginPage megafonLoginPage = new MegafonLoginPage();
        megafonLoginPage.fillPhoneNumberField(phoneNumber).checkValidFormFormat();
    }

    @ValueSource(strings = {"7777777777", "0987654321", "1234567890"})
    @DisplayName("Поле ввода номера телефона не допускает введённый номер")
    @ParameterizedTest(name = "{index} телефон = {0}")
    void phoneFieldShouldNotAcceptGivenPhoneNumber(String phoneNumber) {
        MegafonLoginPage megafonLoginPage = new MegafonLoginPage();
        megafonLoginPage.fillPhoneNumberField(phoneNumber).checkErrorFormFormat();
    }

}
