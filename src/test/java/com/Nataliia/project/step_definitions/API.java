package com.Nataliia.project.step_definitions;

import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

import static org.hamcrest.Matchers.*;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import static io.restassured.RestAssured.*;


public class API  {




    @Test
    public void test1() {

        Response response = given().accept(ContentType.JSON)
                .queryParams("api_key", "13019011880102541120230208").
                when().get("https://iezapt5vu6.execute-api.us-east-1.amazonaws.com/test/patient")
                .then().statusCode(200).extract().response();

        response.prettyPeek();

        JsonPath jsonPath = response.jsonPath();
        List<Map<String, Object>> allPatientsList = jsonPath.getList("");
        for (Map<String, Object> eachPatient : allPatientsList) {
            System.out.println("eachPatient = " + eachPatient);

        }

    }
    //In a test, using the response data from the previous step, verify there is at least 1 patient
    //with an appointment date in the month of June 2022.
    @Test
    public void test2(){

        Response response = given().accept(ContentType.JSON)
                .queryParams("api_key", "13019011880102541120230208").
                when().get("https://iezapt5vu6.execute-api.us-east-1.amazonaws.com/test/patient")
                .then().statusCode(200).extract().response();

        JsonPath jsonPath=response.jsonPath();
        System.out.println("jsonPath.getString(\"appointment_date\") = " + jsonPath.getString("appointment_date"));
        Assert.assertTrue(jsonPath.getString("appointment_date").contains("2022-06"));

    }

    @Test
    public void test3() {
        Response response = given().accept(ContentType.JSON)
                .queryParams("api_key", "13019011880102541120230208").
                when().get("https://iezapt5vu6.execute-api.us-east-1.amazonaws.com/test/patient")
                .then().statusCode(200).
                body("id",is ("SR19760827202206208364"),
                        "birthdate",is("1976-08-27"),
                        "phone",is ("347-555-9876"),
                        "appointment_date",is( "2022-06-20"),
                        "name.lastName",is("Rogers"),
                        "name.firstName",is ("Steve"),
                        "address.street",is( "45 W 45th St"),
                        "address.city",is("New York"),
                        "address.state",is( "NY"),
                        "address.zip",is ("10036")).
                        extract().response();

        JsonPath jsonPath = response.jsonPath();

        Assert.assertTrue(jsonPath.getString("name.lastName").contains("Rogers"));
        Assert.assertTrue(jsonPath.getString("name.firstName").contains("Steve"));

    }

    @Test
    public void test4() {

        //In a test, verify the “id” for all of the patients returned follows the format below:
        //[patient first initial] + [patient last initial] + [patient 4
        //digit birth year] + [patient 2 digit birth month] + [patient 2
        //digit birth day] + [patient 4 digit appointment year] +
        //[patient 2 digit appointment month] + [patient 2 digit
        //appointment day] + [4 random digits]
        //Example ID: AB19800121202206019999
        //Example “exploded” ID: A B 1980 01 21 2022 06 01 9999
        Response response = given().accept(ContentType.JSON)
                .queryParams("api_key", "13019011880102541120230208").
                when().get("https://iezapt5vu6.execute-api.us-east-1.amazonaws.com/test/patient");

        JsonPath jsonPath = response.jsonPath();

        String name = jsonPath.getString("[0].name.firstName");
        String ID = jsonPath.getString("[0].id");
        Assert.assertEquals(ID.substring(0,1),name.substring(0,1));
        String str= String.valueOf(name.charAt(0));
        String str2=String.valueOf(ID.charAt(0));
        Assert.assertEquals(str2,str);
        String lastName = jsonPath.getString("[0].name.lastName");
        String str1= String.valueOf(lastName.charAt(0));
        String str3=String.valueOf(ID.charAt(1));
        Assert.assertEquals(str3,str1);
        String digits=jsonPath.getString("[0].birthdate");
        Assert.assertEquals(ID.substring(2,6),digits.substring(0, 4));
        Assert.assertEquals(ID.substring(6,8),digits.substring(5,7));
        Assert.assertEquals(ID.substring(8,10),digits.substring(8));
        String apYear=jsonPath.getString("[0].appointment_date");
        Assert.assertEquals(ID.substring(10,14),apYear.substring(0,4));
        Assert.assertEquals(ID.substring(14,16),apYear.substring(5,7));
        Assert.assertEquals(ID.substring(16,18),apYear.substring(8));

        /*
        List<String> firstName = jsonPath.getList("name.firstName");
        List<String> id = jsonPath.getList("id");
        for (String eachID : id) {
            String firstLetter=String.valueOf(eachID.charAt(0));
            for (String each : firstName) {
                String first=String.valueOf(each.charAt(0));
                Assert.assertEquals(firstLetter, first );

            }*/
        }




    @Test
    public void test5(){
        List<Map<String,Object>> finalPayload=new ArrayList<Map<String,Object>>();
        Map<String,Object> firstJsonObject=new HashMap<String,Object>();
        firstJsonObject.put("id","SR19760827202206208364");

        Map<String,Object>name=new HashMap<String,Object>();
        name.put("firstName","Tester");
        name.put("lastName","Awesome");

        Map<String,Object>address=new HashMap<String,Object>();
        address.put("street","Roger Drive");
        address.put("city","Chicago");
        address.put("state","IL");
        address.put("zip","60004");
        finalPayload.add(firstJsonObject);
        finalPayload.add(name);
        finalPayload.add(address);



                 Response response=given().accept(ContentType.JSON)
                .queryParams("api_key", "13019011880102541120230208").
                 body(finalPayload).
                when().patch("https://iezapt5vu6.execute-api.us-east-1.amazonaws.com/test/update").
                then().extract().response();


        JsonPath jsonPath = response.jsonPath();

    }




    }



