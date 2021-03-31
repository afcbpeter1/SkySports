package stepdefs;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import io.restassured.response.Response;


import org.testng.Assert;
import skySportsPages.enablers;

import java.nio.file.Files;
import java.nio.file.Paths;


import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class articlesCucumberTests extends enablers {

    private Response response;
    private String expectedJson;
    private String actualJson;

    @Given("I have a set of articles containing individual ID's")
    public void i_have_a_set_of_articles_containing_individual_id_s() {

        baseURI = allArticles;
    }

    @When("I get an article {string}")
    public void i_get_an_article(String articlesId) {

        System.out.println(articlesId);
        response = given().

                pathParam("id", articlesId).
                when().
                get("/{id}").
                then().extract().response();
    }

    @Then("I should see the response code as {string}")
    public void i_should_see_the_response_code_as(String responseCode) {
        Object obj = responseCode;
        Assert.assertEquals(response.getStatusCode(), 200);

    }

    @Then("I will receive an individual article based on expected {string}")
    public void i_will_receive_an_individual_article_based_on_expected(String expectedId) {
        Object obj = expectedId;
        Assert.assertEquals(obj, response.jsonPath().get("id"));
    }

    @Given("I have a set of articles")
    public void i_have_a_set_of_articles() {

        baseURI = allArticles;
    }

    @When("I get the list of articles")
    public void i_get_the_list_of_articles() {
        response = given().
                when().
                get(allArticles).
                then().body(matchesJsonSchemaInClasspath("articlesSchema.json")).extract().response();
    }


    @Then("It will match the json file")
    public void it_will_match_the_json_file() {

        try {
            expectedJson = new String(Files.readAllBytes(Paths.get(pathJson))).replaceAll("[\\n\\s+]", "");
            actualJson = response.asString().replaceAll("[\\n\\s+]", "");
        } catch (Exception e) {
            System.out.println("this is from expected Json " + expectedJson);
        } finally {
            System.out.println("this is from expected Json " + expectedJson);
            System.out.println("this is from actual Json " + actualJson);
            Assert.assertEquals(actualJson, expectedJson);
        }


    }

    @Given("I want to create a new article")
    public void i_want_to_create_a_new_article() {
        baseURI = allArticles;
    }

    @When("I post a new article")
    public void i_post_a_new_article() {


        response = given().
                contentType(ContentType.JSON).
                when().
                post()
                .then()
                .extract()
                .response();


    }

    @Then("I will see the response code as {string}")
    public void i_will_see_the_response_code_as(String responseCode) {
        Object obj = responseCode;
        Assert.assertEquals(response.getStatusCode(), 404);
        System.out.println(response);
    }


    @Given("I want to delete an article")
    public void i_want_to_delete_an_article() {
        RestAssured.baseURI = allArticles;


    }

    @When("I delete an article")
    public void i_delete_an_article() {

        response = given().
                contentType(ContentType.JSON).
                pathParam("id", "5").
                when().
                delete("/{id}")
                .then()
                .extract()
                .response();


    }

    @Then("the response code will be {string}")
    public void the_response_code_will_be(String responseCode) {
        Object obj = responseCode;
        Assert.assertEquals(response.getStatusCode(), 404);
        System.out.println(response);
    }

}



