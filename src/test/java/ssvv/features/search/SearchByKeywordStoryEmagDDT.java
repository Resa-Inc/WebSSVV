package ssvv.features.search;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.*;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.annotations.Qualifier;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ssvv.steps.serenity.EndUserSteps;

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom("src/test/resources/EmagTestData.csv")
public class SearchByKeywordStoryEmagDDT {

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @ManagedPages(defaultUrl = "https://www.emag.ro")
    public Pages pages;

    public String name;
    public String definition;

    @Qualifier
    public String getQualifier() {
        return name;
    }

    @Steps
    public EndUserSteps endUserSteps;

//    @Issue("#WIKI-1")
//    @Test
//    public void searching_by_keyword_apple_should_display_the_corresponding_article() {
//        anna.is_the_home_page();
//        anna.looks_for("apple");
//       anna.should_see_definition("A common, round fruit produced by the tree Malus domestica, cultivated in temperate climates.");
//
//    }

//    @Test
//    public void searching_by_keyword_telefon_should_display_the_corresponding_article() {
//        endUserSteps.is_the_home_page();
//        endUserSteps.looks_for(getName());
//        WebElement webElement = webdriver.findElement(By.xpath("//*[@id=\"card_grid\"]/div[1]"));
//        String namep = webElement.getAttribute("data-name");
//        //endUserSteps.should_see_definition(getDefinition(), namep);
//    }

    @Test
    public void add_to_cart_by_keyword_telefon_should_display_the_corresponding_article() {
        endUserSteps.is_the_home_page();
        endUserSteps.looks_for(getName());
        endUserSteps.should_see_definition(getDefinition());

//        WebElement webElement = webdriver.findElement(By.xpath("//*[@id=\"card_grid\"]/div[2]"));
//        String namep = webElement.getAttribute("data-name");
//        endUserSteps.should_see_definition(getDefinition());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }


} 