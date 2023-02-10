package com.Nataliia.project.step_definitions;

import com.Nataliia.project.pages.bookRoomPage;
import com.Nataliia.project.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


import java.time.Month;
import java.util.List;
import java.util.Map;

public class BookRoom_StepDef {

    bookRoomPage bookRoomPage=new bookRoomPage();

    @Given("user is already logged in and on order page")
    public void user_is_already_logged_in_and_on_order_page() {
        Driver.getDriver().get("https://automationintesting.online/.");
    }
    @When("user click the “Let me hack” button.")
    public void user_click_the_let_me_hack_button(){
        bookRoomPage.LetMeHackButton.click();

    }
    @When("user In the contact form, enter the following data in the associated fields.")
    public void user_in_the_contact_form_enter_the_following_data_in_the_associated_fields(Map<String,String> userInfo) {
        bookRoomPage.inputName.sendKeys(userInfo.get("Name"));
        bookRoomPage.inputEmail.sendKeys(userInfo.get("Email"));
        bookRoomPage.inputPhone.sendKeys(userInfo.get("Phone"));
        bookRoomPage.inputSubject.sendKeys(userInfo.get("Subject"));
        bookRoomPage.textArea.sendKeys(userInfo.get("Message"));


    }
    @When("user click the Submit button to submit the form.")
    public void user_click_the_submit_button_to_submit_the_form() {
        bookRoomPage.submitButton.click();

    }
    @Then("User can see a response with the name {string} and subject {string}")
    public void user_can_see_a_response_with_the_name_and_subject(String name, String subject) {
       String actualResult=bookRoomPage.ResponseInfo.getText();
       String expectedResult="Thanks for getting in touch "+name+"!";
       Assert.assertEquals(expectedResult,actualResult);
        String actualResult_1=bookRoomPage.ResponseInfo_1.getText();
        String expectedResult_1="We'll get back to you about";
        Assert.assertEquals(expectedResult_1,actualResult_1);
        String actualResult_2=bookRoomPage.ResponseInfo_2.getText();
        String expectedResult_2=""+subject;
        Assert.assertEquals(expectedResult_2,actualResult_2);
        String actualResult_3=bookRoomPage.ResponseInfo_3.getText();
        String expectedResult_3="as soon as possible.";
        Assert.assertEquals(expectedResult_3,actualResult_3);

    }
    @Then("User navigate to the Rooms section. For a single room, user click the “Book this room” button.")
    public void user_navigate_to_the_rooms_section_for_a_single_room_user_click_the_book_this_room_button() {
        bookRoomPage.bookRoomButton.click();
    }
    @Then("User select to book for a single night {string}")
    public void user_select_to_book_for_a_single_night_any_date(String date) {
        List<WebElement> month=bookRoomPage.Months;
        for (WebElement m:month) {
            System.out.println("m.getText() = " + m.getText());
            if(m.getText().equals("Today")){
                List<WebElement>days=bookRoomPage.Days;
                for(WebElement d:days){
                    if(d.getText().equals(date)){
                        Actions actions=new Actions(Driver.getDriver());
                        actions.doubleClick(d).perform();
                    }


                }
            }

        }

            }







    @Then("User enter the following information into the booking form.")
    public void user_enter_the_following_information_into_the_booking_form(Map<String,String> userInformation) {
       bookRoomPage.FirstName.sendKeys(userInformation.get("First Name"));
       bookRoomPage.LastName.sendKeys(userInformation.get("Last Name"));
       bookRoomPage.Email.sendKeys(userInformation.get("Email"));
       bookRoomPage.Phone.sendKeys(userInformation.get("Phone"));
    }
    @Then("User click the “Book” button.")
    public void user_click_the_book_button() {
        bookRoomPage.bookButton.click();

    }
    @Then("User can see a message with the following information.")
    public void user_can_see_a_message_with_the_following_information() {



    }
    @Then("User click the “Close” button.")
    public void user_click_the_close_button() {

    }

}
