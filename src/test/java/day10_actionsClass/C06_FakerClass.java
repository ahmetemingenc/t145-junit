package day10_actionsClass;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import utilities.TestBase_Each;

public class C06_FakerClass extends TestBase_Each {

    @Test
    public void test01(){

        Faker faker = new Faker();

        System.out.println(faker.name().fullName());
        System.out.println(faker.name().fullName());
        System.out.println(faker.name().fullName());

        System.out.println(faker.name().firstName());

        System.out.println(faker.name().lastName());

        System.out.println(faker.internet().password());

        System.out.println(faker.internet().emailAddress());

        System.out.println(faker.backToTheFuture().character());

        System.out.println(faker.gameOfThrones().city());
    }
}
