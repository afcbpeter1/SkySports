package skySportsPages;

import static io.restassured.RestAssured.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.*;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("unchecked")
public class articlesTestNg extends enablers {

    //Checks articles individual ID's.
    @Test(dataProvider = "getId")
    public void TestAllArticles(String articlesId) {

        given().
                pathParam("id", articlesId).
                when().
                get(singleArticles).
                then().
                assertThat().
                statusCode(200).
                //asserting that the body id injected from the data provider equals the actual api ID response.
                body(("id"), equalTo(articlesId));
    }

    //Checks the whole content of the json file using an expected outcome in the project structure.
    @Test
    public void GetArticlesJson() {
        JsonPath expectedJson = new JsonPath(new File(pathJson));

        given().
                when().
                get(allArticles).
                then().
                assertThat().
                statusCode(200).
                and().
                body("", hasItem(expectedJson.getMap("")));
    }

// I wanted to see what the output was for the below.
//    @Test
//    public void DeleteArticles() {
//        RestAssured.baseURI = deleteArticle;
//
//
//        RestAssured.given()
//                .contentType(ContentType.JSON.toString())
//                .delete("/5")
//                .then()
//                .assertThat()
//                .body(("body"), equalTo("Endpoint disabled"));
//
//    }
//
//    @Test
//    public void PostArticle() {
//        Map<String, Object> jsonAsMap = new HashMap();
//        jsonAsMap.put("id", "6");
//
//        given().
//                log().all().
//                contentType(ContentType.JSON).
//                body(jsonAsMap).
//                when().
//                post(createArticle).
//                then().
//                body(("id"), equalTo("6"));
//    }
}
