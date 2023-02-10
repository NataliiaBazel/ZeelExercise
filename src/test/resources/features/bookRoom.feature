Feature:: User should be able to enter data into contact form and book the room.

@wip
  Scenario:User enter data into contact form.
    Given user is already logged in and on order page
    When user click the “Let me hack” button.
    When  user In the contact form, enter the following data in the associated fields.
    |Name   | Ada Lovelace|
    |Email  | ada.lovelace@zeel.com|
    |Phone  | 347-555-1212         |
    |Subject| JobDescription            |
    |Message|  In my current framework I use Java language. I am using Selenium for browser automation.|

    And user click the Submit button to submit the form.
    Then User can see a response with the name "Ada Lovelace" and subject "JobDescription"
    Then User navigate to the Rooms section. For a single room, user click the “Book this room” button.
    Then User select to book for a single night "10"
    And User enter the following information into the booking form.
  | First Name | Grace|
  | Last Name  | Hopper|
  | Email      | grace.hopper@zeel.com|
  | Phone      | 347-555-9898         |
    And User click the “Book” button.
    And User can see a message with the following information.
    Then User click the “Close” button.


