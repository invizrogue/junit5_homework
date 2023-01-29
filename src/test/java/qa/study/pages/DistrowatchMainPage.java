package qa.study.pages;

import qa.study.pages.components.HeaderComponent;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class DistrowatchMainPage {

    HeaderComponent headerComponent = new HeaderComponent();

    public DistrowatchMainPage changeLocale(String locale) {
        headerComponent.changeLocale(locale);
        return this;
    }

    public void checkFirstPlace(String distrName) {
        $$(".phr1").first().sibling(0).$("a").shouldHave(text(distrName));
    }

    public void clickOnDistr(String distrName) {
        $$(".phr2 a").findBy(text(distrName)).scrollTo().click();
    }

    public void checkMenuItems(List<String> items) {
        $$("th.NavMenu a").shouldHave(texts(items));
    }
}
