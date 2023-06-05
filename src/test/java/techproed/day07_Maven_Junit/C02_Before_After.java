package techproed.day07_Maven_Junit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C02_Before_After {

    @Before
    public void setUp() throws Exception {
        System.out.println("Her test methodu öncesi bir kez calısır");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("Her test methodu sonrası bir kez calısır");
    }

    @Test
    public void test01() {

        System.out.println("ilk test");

    }

    @Test
    public void test02() {

        System.out.println("ikinci test");

    }


}
