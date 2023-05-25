package pages;

public class GooglePage extends BasePage{
    private String searchButton = "//input[@value='Buscar con Google']";
    private String searchTextField = "//textarea[@title='Buscar']";
    private String firstResult = "//span[@class='BBwThe' and contains(text(),'Resistencia, Chaco')]";
    public GooglePage(){
        super(driver);
    }
    public void navigateToGoogle(){
        navigateTo("https://www.google.com");
    }
    public void clickGoogleSearch(){
        clicElement(searchButton);
    }

    public void enterSearchCriteria(String criteria){
        write(searchTextField,criteria);
    }

    public String firstResult(){
        return textFromElement(firstResult);
    }
}
