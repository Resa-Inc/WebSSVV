package ssvv.steps.serenity;

import net.thucydides.core.annotations.Step;
import ssvv.pages.EmagDictionaryPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;

public class EndUserSteps {

    EmagDictionaryPage dictionaryPage;

    @Step
    public void enters(String keyword) {
        dictionaryPage.enter_keywords(keyword);
    }

    @Step
    public void starts_search() {
        dictionaryPage.lookup_terms();
    }

    @Step
    public void should_see_definition(String itemName, String definition, int ok) {
        if(ok==1)
            assert (definition.contains(itemName));
        else
            assert (!definition.contains(itemName));
    }

    @Step
    public void is_the_home_page() {
        dictionaryPage.open();
    }

    @Step
    public void looks_for(String term) {
        enters(term);
        starts_search();
    }

    @Step
    public void add_to_favourites(){
        dictionaryPage.add_to_favourites();
    }
}
