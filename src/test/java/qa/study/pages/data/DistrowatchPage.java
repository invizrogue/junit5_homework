package qa.study.pages.data;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class DistrowatchPage {
    public void checkFirstPlace(String distrName) {
        $$(".phr1").first().sibling(0).$("a").shouldHave(text(distrName));
    }
}
