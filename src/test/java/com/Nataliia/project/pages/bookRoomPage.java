package com.Nataliia.project.pages;

import com.Nataliia.project.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class bookRoomPage {

    public bookRoomPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//button[.='Let me hack!']")
    public WebElement LetMeHackButton;
    @FindBy(id = "name")
    public WebElement inputName;
    @FindBy(id="email")
    public WebElement inputEmail;
    @FindBy(id="phone")
    public WebElement inputPhone;
    @FindBy(id="subject")
    public WebElement inputSubject;

    @FindBy(id = "description")
    public WebElement textArea;

    @FindBy(xpath = "//button[.='Submit']")
    public WebElement submitButton;

    @FindBy(xpath = "//div[@class='col-sm-5']//h2")
    public WebElement ResponseInfo;

    @FindBy(xpath = "//div[@class='col-sm-5']//p[1]")
    public WebElement ResponseInfo_1;

    @FindBy(xpath = "//div[@class='col-sm-5']//p[2]")
    public WebElement ResponseInfo_2;

    @FindBy(xpath = "//div[@class='col-sm-5']//p[3]")
    public WebElement ResponseInfo_3;

    @FindBy(xpath = "//button[.='Book this room']")
    public WebElement bookRoomButton;

    @FindBy(xpath = "//span[@class='rbc-btn-group']//button")
    public List<WebElement> Months;

    @FindBy(xpath = "//button[@class='rbc-button-link']")
    public List<WebElement> Days;

    @FindBy(xpath = "//input[@aria-label='Firstname']")
    public WebElement FirstName;

    @FindBy(xpath = "//input[@aria-label='Lastname']")
    public WebElement LastName;

    @FindBy(xpath = "//input[@aria-label='Email']")
    public WebElement Email;

    @FindBy(xpath = "//input[@aria-label='Phone']")
    public WebElement Phone;

    @FindBy(xpath = "//button[.='Book']")
    public WebElement bookButton;




}
