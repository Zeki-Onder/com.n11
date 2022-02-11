package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import javax.swing.*;


public class N11Page {

    public N11Page() {PageFactory.initElements(Driver.getDriver(), this);}

    @FindBy (xpath="//*[@class='btnSignIn']")
    public WebElement loginPage;

    @FindBy (xpath="//*[@id='email']")
    public WebElement eMailTextbox;

    @FindBy (xpath="//*[@id='password']")
    public WebElement passwordTextbox ;

    @FindBy (id="loginButton")
    public WebElement loginButton ;

    @FindBy (xpath="//*[@class='menuLink user']")
    public WebElement user;

    @FindBy (xpath="//*[text()='E-posta adresiniz veya şifreniz hatalı']")
    public WebElement loginErrorText;

    @FindBy (xpath="//*[text()='Lütfen geçerli bir e-posta adresi girin.']")
    public WebElement emailErrorText;

    @FindBy (xpath="//*[text()='Girilen değer en az 6 karakter olmalıdır.']")
    public WebElement passwordErrorText;

    @FindBy (xpath = "//*[@class='myAccount']")
    public WebElement userAccount;

    @FindBy (xpath = "//*[@id='searchInput']")
    public WebElement searchFirefox;

    @FindBy (xpath = "//*[@id='clearSiteDataButton']")
    public WebElement clearSite;

    public void ClearBrowserCache() throws InterruptedException {
        Driver.getDriver().manage().deleteAllCookies();
        Thread.sleep(7000);
    }







}
