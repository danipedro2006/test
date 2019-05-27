package main.advanced.encapsulation;

import org.junit.jupiter.api.Test;

public class PersonTest {


    @Test
    public void test1(){

        Person employee = new Person(
                "John",
                "Doe",
                30,
                true);


        // uses Person.toString();
        System.out.println(employee);

        System.out.println(
                employee.getFirstName() + " "
                +  employee.getLastName()
                + " age: " + employee.getAge() + " male: " + employee.isMale());


        employee.setAge(40);
        System.out.println(employee);





    }


    @Test
    public void test2(){

        Person person = new Person("Maria", "Popescu");
        person.setAge(20);
        person.setMale(false);

        System.out.println(person);

        System.out.println("After one year:");
        person.growAge();

        System.out.println(person.getFullName() + " age: " + person.getAge() );


    }

}


