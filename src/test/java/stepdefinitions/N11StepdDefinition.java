package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.asserts.SoftAssert;
import pages.N11Page;
import utilities.ConfigReader;
import utilities.Driver;

public class N11StepdDefinition {

    N11Page n11Page=new N11Page();
    JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
    SoftAssert softAssert=new SoftAssert();

    @Given("User goes to {string} page")
    public void userGoesToPage(String url) throws InterruptedException {
        Driver.getDriver().navigate().to(ConfigReader.getProperty(url));
        n11Page.ClearBrowserCache();
    }

    @Then("Opens the Login page")
    public void opensTheLoginPage() {
        n11Page.loginPage.click();
    }

    @Given("User enters {string} and {string}")
    public void userEntersAnd(String email, String password) {
        js.executeScript("window.scrollBy(0,100)");
        n11Page.eMailTextbox.sendKeys(ConfigReader.getProperty(email));
        n11Page.passwordTextbox.sendKeys(ConfigReader.getProperty(password));
    }

    @Then("User clicks login button")
    public void userClicksLoginButton()  {
        n11Page.loginButton.click();
    }

    @And("User verifies login")
    public void userVerifiesLogin()  {
        softAssert.assertTrue(n11Page.user.getText().equals("Test Test"),"Login failed");
        softAssert.assertAll();
    }

    @And("User verifies login failed")
    public void userVerifiesLoginFailed() {
        System.out.println("Goruntulenen yazi: "+n11Page.loginErrorText.getText());
        softAssert.assertTrue(n11Page.loginErrorText.getText().equals("E-posta adresiniz veya şifreniz hatalı"),
                "Error text element can not be displayed");
        softAssert.assertAll();
    }

    @And("User closes the page")
    public void userClosesThePage()  {
        Driver.closeDriver();
    }

    @And("User verifies that the homepage is opened and the username is displayed")
    public void userVerifiesThatTheHomepageIsOpenedAndTheUsernameIsDisplayed() throws InterruptedException {
        Thread.sleep(4000);
        softAssert.assertTrue(Driver.getDriver().getCurrentUrl().equals(ConfigReader.getProperty("expectedUrl")),
                "homepage is not opened");
        softAssert.assertTrue(n11Page.user.isDisplayed(),"Username is not displayed");
        softAssert.assertAll();
    }

    @Given("User enters {string} at the email textbox and verifies that invalid email warning message is displayed")
    public void userEntersAtTheEmailTextboxAndVerifiesThatInvalidEmailWarningMessageIsDisplayed(String email) {
        n11Page.eMailTextbox.sendKeys(ConfigReader.getProperty(email));
        n11Page.passwordTextbox.click();
        softAssert.assertTrue(n11Page.emailErrorText.isDisplayed()
                ,"invalid email message is not displayed");
        n11Page.eMailTextbox.clear();
        softAssert.assertAll();
    }

    @Then("User enters {string} at the password textbox and verifies that invalid password warning message is displayed")
    public void userEntersAtThePasswordTextboxAndVerifiesThatInvalidPasswordWarningMessageIsDisplayed(String password) {
        n11Page.passwordTextbox.sendKeys(ConfigReader.getProperty(password));
        n11Page.eMailTextbox.click();
        softAssert.assertTrue(n11Page.passwordErrorText.isDisplayed()
                ,"invalid email message is not displayed");
        softAssert.assertAll();
        n11Page.eMailTextbox.clear();
    }

    @And("Verifies that incorrect password or email warning message is displayed")
    public void verifiesThatIncorrectPasswordOrEmailWarningMessageIsDisplayed() {
        softAssert.assertTrue(n11Page.loginErrorText.isDisplayed()
                ,"Wrong email or password error message is not displayed");
        softAssert.assertAll();
    }

    @Given("User enters wrong {string} and {string}")
    public void userEntersWrongAnd(String email, String password) {
        js.executeScript("window.scrollBy(0,100)");
        n11Page.eMailTextbox.sendKeys(email);
        n11Page.passwordTextbox.sendKeys(password);
    }
}


