package qa.study.pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class MegafonLoginPage {

    static final SelenideElement phoneNumberField = $("[data-testid='PhoneInput-input']");

    public MegafonLoginPage fillPhoneNumberField(String phoneNumber) {
        phoneNumberField.setValue(phoneNumber).pressTab();
        return this;
    }

    public MegafonLoginPage checkValidFormFormat() {
        $("div.login-form-otp-phone div.mfui-text-field_valid").should(exist);
        return this;
    }

    public MegafonLoginPage checkErrorFormFormat() {
        $("div.login-form-otp-phone div.mfui-text-field_error").should(exist);
        return this;
    }

}
