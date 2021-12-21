import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
@DisplayName("Позитивные тесты проверки имени")
public class AccountPositiveTests {

    private final String fullName;
    Account account;

    public AccountPositiveTests(String fullName) {
        this.fullName = fullName;
    }

    @Before
    public void setUp() {
        account = new Account(fullName);
    }

    @Parameterized.Parameters
    public static Object[][] getFullNameData() {
        return new Object[][]{
                {"К C"},
                {"Кевин Смит"},
                {"Кевин Смит Молчалив"},
        };
    }

    @Test
    public void accountPositiveTest(){
        Assert.assertTrue(account.checkNameToEmboss());
    }


}