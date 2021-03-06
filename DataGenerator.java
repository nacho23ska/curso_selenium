package ExamenNivelInicial;

import org.testng.annotations.DataProvider;

public class DataGenerator {

    @DataProvider(name = "emails")
    public Object[][] mailsTest(){
        return new Object[][]{
                { "primertest@gmail.com", "holamundo"},
                { "segundotest@gmail.com", "holamundo" },
                { "tercertest@gmail.com", "holamundo"}
        };
    }
}
