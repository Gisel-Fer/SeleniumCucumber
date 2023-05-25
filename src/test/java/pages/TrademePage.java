package pages;

public class TrademePage extends BasePage{
    private String makeDropdown = "//select[@name='selectedMake']";
    private String searchButton = "//button[@type='submit']";
    private String resultsLabel = "//h3[@class='tm-search-header-result-count__heading ng-star-inserted']";

    private String motors = "//a[@routerlink='/motors']";
    public TrademePage(){
        super(driver);
    }
    public void navigateToTradeMeMotor(){
        navigateTo("https://www.trademe.co.nz/a/");
    }
    public void selectMakeFromDropdown(String make){
        selectFromDropdownbyText(makeDropdown,make);
    }
    public void clickSearch(){
        clicElement(searchButton);
    }

    public int makeDropdownSize(){
        return dropdownSize(makeDropdown);
    }

    public String resultAmount(){
        return textFromElement(resultsLabel);
    }

    public void clickMotors(){
        clicElement(motors);
    }
}
