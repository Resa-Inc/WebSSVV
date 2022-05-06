package ssvv.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

import java.util.List;
import java.util.stream.Collectors;

@DefaultUrl("https://www.emag.ro")
public class EmagDictionaryPage extends PageObject {

    @FindBy(name = "query")
    private WebElementFacade searchTerms;

    @FindBy(xpath = "//*[@id=\"masthead\"]/div/div/div[2]/div/form/div[1]/div[2]/button[2]")
    private WebElementFacade searchButton;

    @FindBy(xpath = "/html/body/div[3]/div[2]/div/section[1]/div/div[3]/div[2]/div[5]/div[1]/div/div/div[2]/button[1]")
    private WebElementFacade addToFavouritesButton;

    public void enter_keywords(String keyword) {
        searchTerms.type(keyword);
    }

    public void lookup_terms() {
        searchButton.click();
    }

    public void add_to_favourites(){
        System.out.println(addToFavouritesButton ==null);
        addToFavouritesButton.click();
    }

    public List<String> getDefinitions() {
        WebElementFacade definitionList = find(By.className("card-v2-info"));
        List<String> result = definitionList.findElements(By.className("card-v2-title semibold mrg-btm-xxs js-product-url")).stream()
                .map( element -> element.getText() )
                .collect(Collectors.toList());
        System.out.println(result.toString());
        return result;
    }
}
