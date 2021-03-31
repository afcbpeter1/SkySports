package skySportsPages;

import org.testng.annotations.DataProvider;

public class enablers {

    // Strings to be able to change in one place rather than paste them in to each individual test.
    public String allArticles = "https://5f99522350d84900163b8737.mockapi.io/tech-test/articles";
    public String dataProviderIds = "https://5f99522350d84900163b8737.mockapi.io/tech-test/articles/{id}";
    public String pathJson = "src/test/java/jsonFiles/articles.json";
    public String schemaJson = "src/test/java/jsonFiles/schema.json";
    public String deleteArticle = "https://5f99522350d84900163b8737.mockapi.io/tech-test/articles/5";
    public String createArticle = "https://5f99522350d84900163b8737.mockapi.io/tech-test/articles/7";


    //Data provider allows me to inject an id into the response string to be able to test multiple Id's like a data table.
    @DataProvider(name = "getId")
    public Object[][] getData() {
        return new Object[][]{
                {"1", },
                {"2", },
                {"3",},
                {"4656364867443",},
                {"5",},


        };

    }
}