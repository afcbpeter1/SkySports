package stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.matcher.RestAssuredMatchers;
import io.restassured.response.Response;


import org.testng.Assert;
import org.testng.annotations.Test;
import skySportsPages.enablers;


import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;


public class articlesCucumberTests extends enablers {

    private Response response;

    @Given("I have a set of articles containing individual ID's")
    public void i_have_a_set_of_articles_containing_individual_id_s() {
        baseURI = singleArticles;
    }

    @When("I get an article {string}")
    public void i_get_an_article(String articlesId) {
        // Object obj = articlesId;
        System.out.println(articlesId);
        response = given().
                //log().all().and().
                        pathParam("id", articlesId).
                        when().
                        get("/{id}").
                        then().extract().response();
    }

    @Then("I should see the response code as {string}")
    public void i_should_see_the_response_code_as(String responseCode) {
        Object obj = responseCode;
        Assert.assertEquals(200, response.getStatusCode());
    }

    @Then("I will receive an individual article based on expected {string}")
    public void i_will_receive_an_individual_article_based_on_expected(String expectedId) {
        Object obj = expectedId;
        Assert.assertEquals(obj, response.jsonPath().get("id"));
    }

//    @Test
//    @Given("I have a set of articles containing individual ID's")
//    public void i_have_a_set_of_articles_containing_individual_id_s() {
//        RestAssured.baseURI = singleArticles;
//        System.out.println(baseURI);
//    }
//
//    @Test(dataProvider = "getId")
//    @When("I get an the article ID")
//    public void i_get_an_the_article_id(String articlesId) {
//
//        response = given().
//                log().all().and().
//                pathParam("id", articlesId).
//                when().
//                get(singleArticles).
//                then().extract().response();
//
//    }
//
//    @Test(dataProvider = "getId")
//    @Then("I will receive an individual article")
//    public void i_will_receive_an_individual_article(String articlesId) {
//
//
//
//        Assert.assertEquals(200,response.getStatusCode());
//        Assert.assertEquals("",response.jsonPath());
//
//    }
//
//    @Test
//    @Given("I have a set of articles")
//    public void i_have_a_set_of_articles(String articlesId) {
//
//    }
//
//    @Test
//    @When("I get the list of articles")
//    public void i_get_the_list_of_articles() {
//
//    }
//
//    @Test
//    @Then("It will match the json file")
//    public void it_will_match_the_json_file() {
//
//    }

}
