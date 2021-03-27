package skySportsPages;

import org.testng.annotations.DataProvider;

public class enablers {


    String singleArticles = "https://5f99522350d84900163b8737.mockapi.io/tech-test/articles/{id}";
    String allArticles = "https://5f99522350d84900163b8737.mockapi.io/tech-test/articles";
    String pathJson = "src/test/java/jsonFiles/articles.json";
    String deleteArticle = "https://5f99522350d84900163b8737.mockapi.io/tech-test/articles";
    String createArticle = "https://5f99522350d84900163b8737.mockapi.io/tech-test/articles/6";

    @DataProvider(name = "getId")
    public Object[][] getData() {
        return new Object[][]{
                {"1"},
                {"2"},
                {"3"},
                {"4656364867443"},
                {"5"},


        };

    }
}