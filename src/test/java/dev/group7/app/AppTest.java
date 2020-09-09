package dev.group7.app;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import dev.group7.app.bl.UsersBL;

/**
 * Unit test for simple App.
 */
public class AppTest {

    /**
     * Rigorous Test :-)
     */

    static UsersBL ubl = new UsersBL();

    @Test
    public void checkLogin1() {

        try {

            String result = ubl.checkUserLogin("", "");
            String expected = "";
            assertTrue("not empty", result.equals(expected));
        } catch (Exception e) {

        }

    }

    @Test
    public void checkLogin2() {
        try {

            String result = ubl.checkUserLogin(null, "1010");
            String expected = "";
            assertTrue("Not name", result.equals(expected));
        } catch (Exception e) {

        }

    }

    @Test
    public void checkLogin3() throws Exception {

        try {
            String result = ubl.checkUserLogin("Anhlh", null);
            String expected = "";
            assertTrue("Not Password", result == expected);
        } catch (Exception e) {

        }

    }

    @Test
    public void checkLogin4() {
        try {
            final String result = ubl.checkUserLogin("Anhlh", "1010");
            String expected = "Admin";
            assertTrue("valid", result.equals(expected));
        } catch (Exception e) {
        }

    }

    @Test
    public void checkLogin5() {
        try {
            final String result = ubl.checkUserLogin("Anhlh", "1234");
            String expected = "Customer";
            assertFalse(result.equals(expected));

        } catch (Exception e) {
        }

    }

}
