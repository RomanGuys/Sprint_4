import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@DisplayName("Негативные тесты проверки имени")
@RunWith(Parameterized.class)
public class AccountNegativeTests {

    private final String fullName;
    Account account;

    public AccountNegativeTests(String fullName) {
        this.fullName = fullName;
    }

    @Before
    public void setUp() {
        account = new Account(fullName);
    }

    @Parameterized.Parameters
    public static Object[][] getFullNameData() {
        return new Object[][]{
                {"КC"},
                {" Кевин Смит"},
                {"Кевин Смит "},
                {"КевинСмит"},
                {"Кевин Смит Молчаливый"},
        };
    }

    @Test
    public void accountNegativeTest(){
        Assert.assertFalse(account.checkNameToEmboss());
    }


}