package qa.study.pages.components;

import static com.codeborne.selenide.Selenide.*;

public class HeaderComponent {

    public void changeLocale(String locale) {
        $("[title='" + locale + "']").click();
    }
}
