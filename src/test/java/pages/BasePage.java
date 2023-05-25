package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.time.Instant;
import java.util.List;

public class BasePage {
    static Instant first = Instant.now();
    static Instant second = Instant.now().plusSeconds(10);

   private static Duration duration = Duration.between(first, second);
    //Se crea una instancia de chrome
    //De esta manera hay una sola instancia para todas las clases
    protected static WebDriver driver;
    private static WebDriverWait wait;
    private static Actions action;
    static {
        System.setProperty("webdriver.chrome.driver", "C:/Users/Gise/Downloads/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(chromeOptions);
        wait = new WebDriverWait(driver,duration);
    }

    public BasePage(WebDriver driver){
        BasePage.driver = driver;
        //Se inicializan los elementos que van a ser utilizados en la pageFactory
        PageFactory.initElements(driver,this);
        wait = new WebDriverWait(driver,duration);
    }

    public static void navigateTo(String url){
        driver.get(url);
    }

    public static void closeBrowser(){
        driver.quit();
    }
    //Creamos una funcion que cree un web element una sola vez y a la vez que nos lo devuelva pero con una espera hasta que este o sino que espere 10 seg mas
    private WebElement Find(String locator){
        return  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    }

    public void clicElement(String locator){
        Find(locator).click();
    }

    public void write(String locator, String textToWrite){
        Find(locator).clear();
        Find(locator).sendKeys(textToWrite);
    }

    public void selectFromDropdownbyValue(String locator, String valueToSelect){
        Select dropdown = new Select(Find(locator));
        dropdown.selectByValue(valueToSelect);

    }

    public void selectFromDropdownbyIndex(String locator, int valueToSelect){
        Select dropdown = new Select(Find(locator));
        dropdown.selectByIndex(valueToSelect);

    }

    public void selectFromDropdownbyText(String locator, String valueToSelect){
        Select dropdown = new Select(Find(locator));
        dropdown.selectByVisibleText(valueToSelect);

    }
    //Funcion para pasar el mouse por arriba del elemento
    public void hoverOverElement(String locator){
        action.moveToElement(Find(locator));
    }

    public void doubleClick(String locator){
        action.doubleClick(Find(locator));
    }

    public void rightClick(String locator){
        action.contextClick(Find(locator));
    }

    public String getValueFromTable(String locator, int row, int col){
        String cellINeed = locator+"/table/tbody/tr["+row+"]/td["+col+"]";
        return Find(cellINeed).getText();
    }

    public void setValueOnTable(String locator, int row, int column, String stringToSend){
        String cellToFill = locator+"/table/tbody/tr["+row+"]/td["+column+"]";
        Find(cellToFill).sendKeys(stringToSend);
    }

    //Para pasar entre pantallas
    public void switchToiFrame(int iFrameID){
        driver.switchTo().frame(iFrameID);
    }

    public void switchToParentFrame(){
        driver.switchTo().parentFrame();
    }
    //para rechazar una alerta
    //Se agrega un try/catch para el manejo de errores
    public void dismissAlert(){
        try{
            driver.switchTo().alert().dismiss();
        }catch(NoAlertPresentException e){
            e.printStackTrace();
        }
    }

    //Assertions
    //Nos va a devolver el texto de un web element
    public String textFromElement(String locator){
        return Find(locator).getText();
    }
    //Validar que un elemento esta siendo mostrado
    public  boolean elementIsDisplayed(String locator){
        return Find(locator).isDisplayed();
    }

    public boolean elementIsSelected(String locator){
        return Find(locator).isSelected();
    }

    //Validar si el elemento esta habilitado para ser clickeado

    public boolean elementIsEnable(String locator){ return Find(locator).isEnabled();}

    //Devuelve una lista de webelements
    public List<WebElement> bringMeAllElements(String locator){
        return driver.findElements(By.className(locator));
    }

    //devuelve la cantidad de elementos de una lista o dropdown
    public int dropdownSize(String locator){
        Select dropdown = new Select(Find(locator));
        List<WebElement> dropdownOptions = dropdown.getOptions();
        return dropdownOptions.size();
    }
}
