import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class AccountTest {

    private final String name;
    private final boolean expected;

    public AccountTest(String name, boolean expected) {
        this.name = name;
        this.expected = expected;
    }

    @Parameterized.Parameters(name = "data: {0}, result: {1}")
    public static Object[][] dateParameters() {
        return new Object[][] {
                {"John Smith", true},
                {"J S", true},
                {"John Smithhhhhhhhhh", true},
                {"JS", false},
                {"John Smithhhhhhhhhhh", false},
                {"JohnSmith", false},
                {" JohnSmith", false},
                {"JohnSmith ", false},
                {"John. Smith", false},
        };
    }

    @Test
    @DisplayName("Check name validation")
    @Description("Positive and negative parameters")
    public void accountNameTest() {

        Account account = new Account(name);
        assertEquals(expected, account.checkNameToEmboss());
    }
}