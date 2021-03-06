package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class RegistrationPage {
    @FindBy(name = "Gender")
    List<WebElement> genderRadioButtons;
    @FindBy(name = "DateOfBirthDay")
    private WebElement dobDropdown;
    @FindBy(name = "DateOfBirthMonth")
    private WebElement domDropdown;
    @FindBy(name = "DateOfBirthYear")
    private WebElement doyDropdown;
    @FindBy(id = "FirstName")
    private WebElement firstnameInput;
    @FindBy(id = "LastName")
    private WebElement lastNameInput;
    @FindBy(id = "Email")
    private WebElement emailInput;
    @FindBy(id = "Company")
    private WebElement companyInput;
    @FindBy(id = "Newsletter")
    private WebElement newsletterCheckbox;
    @FindBy(id = "Password")
    private WebElement passwordInput;
    @FindBy(id = "ConfirmPassword")
    private WebElement confirmPasswordInput;
    @FindBy(id = "register-button")
    private WebElement registerButton;
    @FindBy(xpath = "//div[contains(@class,\"validation-summary-errors\")]//li")
    private WebElement errorMessage;
    @FindBy(id = "Password-error")
    private WebElement errorMessage2;
    @FindBy(id = "Email-error")
    private WebElement errorMessage3;
    @FindBy(xpath = "//span[@class=\"field-validation-error\"]/span")
    private List<WebElement> errorMessages;


    public void selectGender(String gender) {
        if (gender.equalsIgnoreCase("Male")) {
            genderRadioButtons.get(0).click();
        } else {
            genderRadioButtons.get(1).click();
        }
    }

    public WebDriver driver;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void personalDetails(String FirstName, String LastName, String Email,
                                String Company, String Password, String ConfirmPassword) {
        firstnameInput.sendKeys(FirstName);
        lastNameInput.sendKeys(LastName);
        emailInput.sendKeys(Email);
        companyInput.sendKeys(Company);
        passwordInput.sendKeys(Password);
        confirmPasswordInput.sendKeys(ConfirmPassword);
    }

    public void register() {
        registerButton.click();
    }

    public void selectDayOfBirth(String day) {
        Select select = new Select(dobDropdown);
        select.selectByVisibleText(day);


    }

    public void newsLetter() {
        newsletterCheckbox.click();

    }

    public void selectMonthOfBirth(String month) {
        Select select = new Select(domDropdown);
        select.selectByVisibleText(month);
    }

    public void selectYearOfBirth(String year) {
        Select select = new Select(doyDropdown);
        select.selectByVisibleText(year);


    }
    public String getErrorMessage(){
        return errorMessage.getText();
    }
    public String getErrorMessage2(){
        return errorMessage2.getText();



}
public List<String> getErrorMessages(){
        List<String> errors = new ArrayList<>();
        for ( WebElement errorMessage: errorMessages){
            errors.add(errorMessage.getText());
        }
        return errors;
}
public String getErrorMessage3(){
        return errorMessage3.getText();
}

}

