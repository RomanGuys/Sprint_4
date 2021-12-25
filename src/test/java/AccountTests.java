import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
@DisplayName("Позитивные тесты проверки имени")
public class AccountTests {

    private final String fullName;
    private final boolean expectedResult;
    Account account;

    public AccountTests(String fullName, boolean expectedResult) {
        this.fullName = fullName;
        this.expectedResult = expectedResult;
    }

    @Before
    public void setUp() {
        account = new Account(fullName);
    }

    @Parameterized.Parameters
    public static Object[][] getFullNameData() {
        return new Object[][]{
                {"К C", true},
                {"Кевин Смит", true},
                {"Кевин СмиттМолчалив", true},
                {"КC", false},
                {" Кевин Смит", false},
                {"Кевин Смит ", false},
                {"КевинСмит", false},
                {"Кевин Смит Молчаливый", false},
                {"Кевин  Смит", false}
        };
    }

    @Test
    public void accountTest(){
        Assert.assertEquals(account.checkNameToEmboss(), expectedResult);
    }


}