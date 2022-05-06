package ssvv.features.search;

import net.serenitybdd.core.annotations.findby.FindBy;
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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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
//        System.out.println(namep);
//        endUserSteps.should_see_definition("Telefon", namep, 1);
//    }
//
//    @Test
//    public void searching_by_keyword_telefon_should_not_display_the_corresponding_article() {
//        endUserSteps.is_the_home_page();
//        endUserSteps.looks_for(getName());
//        WebElement webElement = webdriver.findElement(By.xpath("//*[@id=\"card_grid\"]/div[1]"));
//        String namep = webElement.getAttribute("data-name");
//        System.out.println(namep);
//        endUserSteps.should_see_definition("Portocala", namep, 0);
//    }

    @Test
    public void add_to_cart_by_keyword_telefon_should_display_the_corresponding_article(){


        endUserSteps.is_the_home_page();
        endUserSteps.looks_for(getName());
        WebElement webElement = webdriver.findElement(By.xpath("//*[@id=\"card_grid\"]/div[1]"));
        String namep = webElement.getAttribute("data-name");
        //System.out.println(namep);
        //endUserSteps.should_see_definition("Telefon", namep, 1);
//        WebDriverWait wait = new WebDriverWait(webdriver, 10);
//        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[3]/div[2]/div/section[1]/div/div[3]/div[2]/div[5]/div[1]/div/div/div[4]/div[2]/form/button")));
//        webdriver.manage().window().maximize();
        endUserSteps.add_to_cart();
        WebElement cart = webdriver.findElement(By.xpath("/html/body/div[3]/nav[1]/div/div/div[3]/div/div[4]/a"));
        cart.click();
        WebElement cartItem = webdriver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/div[1]/form/div/div[3]/div/div[1]/div/div[2]/div[1]/div[1]/a"));
        String cartItemText = cartItem.getText();
        endUserSteps.should_see_definition("Telefon",cartItemText,1);


//        endUserSteps.is_the_home_page();
//        endUserSteps.looks_for(getName());
//        WebElement webElement = webdriver.findElement(By.xpath("/html/body/div[3]/div[2]/div/section[1]/div/div[3]/div[2]/div[5]/div[1]/div/div/div[3]/div"));
//        String
//        assert webElement.getText().toString().toLowerCase().contains(itemName);
//        endUserSteps.should_see_definition(itemDefinition,getDefinition());

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
