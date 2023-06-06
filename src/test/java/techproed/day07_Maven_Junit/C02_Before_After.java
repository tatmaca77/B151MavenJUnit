package techproed.day07_Maven_Junit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C02_Before_After {

    /**
         Notasyonlara (Annotations) sahip methodlar olusturabilmek icin mause+sagtik+generate ( kisayol --> alt+insert) yaparak
      after methodu icin teardown'u seceriz
     before methodu icin setup'i seceriz.
     test methodu icin de test'i seceriz.

         JUnit framework'de testlerimizi siralama yapabilmek icin ekstra bir Annotation yoktur.
     Eger belli bir siralamada calistirmak istersek method isimlerini alfabetik ve sayisal olarak belirtiriz.
     */


    @After
    public void tearDown() throws Exception {
        System.out.println("Her test methodundan sonra bir kez calısır");
    }

    @Before
    public void setUp() throws Exception {
        System.out.println("Her test methodu öncesi bir kez calısır");
    }

    @Before
    public void setUp2() throws Exception {
        System.out.println("Her test methodu öncesi birrrrrrrrrr kez calısır");
    }


    @Test
    public void test01() {

        System.out.println("Test 1 methodu calisti");

    }

    @Test
    public void test02() {

        System.out.println(" Test 2 methodu calisti");

    }

    @Test
    public void test03() {

        System.out.println("Test 3 methodu calisti");
    }
}
