package TestingOperation;

import org.junit.jupiter.api.Test;

import static TestingOperation.RegistrationTest.isValidUserName;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RegistrationTestTest {
    String userName = "NiteshYadav";
    String userName1 = "Nitesh Yadav";
    String userName2 = "Nitesh@123";
    String userName3 = "Nitesh_yadav";
    String userName4 = "Nitesh/Yadav";
    String userName5 = "Nitesh#yadav";
    String userName6 = " ";

    @Test
    //first it should show answer with true /expected=false actual true
    public void shouldAnswerWithTrue() {
        assertTrue(isValidUserName(userName));
        assertTrue(isValidUserName(userName1));
        assertTrue(isValidUserName(userName2));
        assertTrue(isValidUserName(userName3));
        assertTrue(isValidUserName(userName4));
        assertTrue(isValidUserName(userName5));
        assertTrue(isValidUserName(userName6));
    }


    @Test
    //it should show answer false /expected=false actual true
    public void shouldAnswerWithFalse() {
        assertFalse(isValidUserName(userName1));
        assertFalse(isValidUserName(userName2));
        assertFalse(isValidUserName(userName3));
        assertFalse(isValidUserName(userName4));
        assertFalse(isValidUserName(userName5));
        assertFalse(isValidUserName(userName6));
    }
}




