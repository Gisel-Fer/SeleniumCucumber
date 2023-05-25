package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.TrademePage;

public class TrademeSteps {
    
    TrademePage trademe = new TrademePage();
    @Given("I navigate to the TradeMe Motor page")
    public void iNavigateToTheTradeMeMotorPage() {
        trademe.navigateToTradeMeMotor();
        trademe.clickMotors();
    }


    @Then("^I can verify that the number of car makes is (\\d+)$")
    public void iCanVerifyThatTheNumberOfCarMakesIs(int makeAmount) {
        int actualAmount = trademe.makeDropdownSize();
        Assert.assertEquals(makeAmount,actualAmount);
    }

    @When("^I select the car make (.*)$")
    public void iSelectTheCarMakeMake(String make) {
        trademe.selectMakeFromDropdown(make);
    }


    @Then("^I can see it has (.*) records in the results$")
    public void iCanSeeItHasAmountRecordsInTheResults(String expectedAmountResults) {
        trademe.clickSearch();
        Assert.assertEquals("Showing "+expectedAmountResults+" results", trademe.resultAmount());
    }
}
