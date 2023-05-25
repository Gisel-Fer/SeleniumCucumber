package steps;

import io.cucumber.java.en.*;
import org.junit.Assert;
import pages.GooglePage;

public class GoogleSteps {

    GooglePage google = new GooglePage();
    @Given("^navego a google$")
    public void navegoAGoogle() {
        google.navigateToGoogle();

    }

    @When("^busco algo$")
    public void buscoAlgo() {
        google.enterSearchCriteria("Tiempo en resistencia");
    }


    @And("hago clic en el boton de buscar")
    public void hagoClicEnElBotonDeBuscar() {
        google.clickGoogleSearch();
    }

    @Then("^obtengo resultados$")
    public void obtengoResultados() {
        Assert.assertEquals("Resistencia, Chaco",google.firstResult());
    }
}
