package techproed.day14_Actions_Faker;

import com.github.javafaker.Faker;
import org.junit.Test;

public class C04_Faker {

    @Test
    public void faker() {

        /**
        "Faker" class'indan sahte verileri kullanabilmek icin obje olusturmamiz gerekir.
                address, name, surname, birthdate, gibi sahte veriler üretir.
         */

        Faker faker = new Faker();

        // Faker objesini kullanarak bir name yazdiriniz.
        System.out.println("Isim : " + faker.name().firstName());

        // Faker objesini kullanarak bir lastname yazdiriniz.
        System.out.println("Soyisim : " + faker.name().lastName());

        // Faker objesini kullanarak bir fullname yazdiriniz.
        System.out.println("Tam Isim : " + faker.name().fullName());

        // Faker objesini kullanarak bir adress yazdiriniz.
        System.out.println("Adres : " + faker.address().fullAddress());

        // Faker objesini kullanarak bir tel_no yazdiriniz.
        System.out.println("Cep_No : " + faker.phoneNumber().cellPhone());
        System.out.println("Tel_No : " + faker.phoneNumber().phoneNumber());

        // Rastgele 15 haneli bir numara yazdiralim.
        System.out.println("Rastgele 15 haneli bir numara : " + faker.number().digits(15));

        System.out.println(faker.job().position());

    }
}
