package qa.study.pages;

import qa.study.pages.components.HeaderComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.withTagAndText;
import static com.codeborne.selenide.Selenide.*;

public class DistrowatchDistroPage {
    HeaderComponent headerComponent = new HeaderComponent();

    public DistrowatchDistroPage changeLocale(String locale) {
        headerComponent.changeLocale(locale);
        return this;
    }

    public void checkInfo(String distribution, String projectUrl, String bugTrackerUrl) {
        verifyKeyValue("Distribution", distribution);
        verifyKeyValue("Home Page", projectUrl);
        verifyKeyValue("Bug Tracker", bugTrackerUrl);
    }

    private void verifyKeyValue(String key, String value) {
        $(withTagAndText("th", key)).sibling(0).shouldHave(text(value));
    }
}
