package ru.netology;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.*;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

class RegistrationTest {
    @Test
    void shouldRegister() {
        open("http://localhost:9999");
        $("[data-test-id = city] input").setValue("Казань");
        $("[data-test-id = name] input").setValue("Макарова Варвара");
        $("[data-test-id = phone] input").setValue("+79856789456");
        $("[data-test-id=date] input").sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        Date dateNow = new Date();
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("dd.MM.yyyy");
        $("[data-test-id = date] input").setValue(formatForDateNow.format(dateNow));
        $("[data-test-id = agreement] [role= presentation]").click();
        $$("button").find(exactText("Забронировать")).click();
        $(withText("Успешно!")).shouldBe(visible, Duration.ofMillis(15000));
    }
}

