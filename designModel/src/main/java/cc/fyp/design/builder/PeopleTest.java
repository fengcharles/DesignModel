package cc.fyp.design.builder;

/**
 * @author von
 * @description:
 * @date 2020/12/11 09:34
 */
public class PeopleTest {
    public static void main(String[] args) {

        Person person = Person.builder().name("12").age(32).build();

        System.out.println(person);
    }
}
