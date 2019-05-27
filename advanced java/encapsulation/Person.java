package main.advanced.encapsulation;

public class Person {

    private String firstName;

    private String lastName;

    private int age;

    private boolean isMale;

    // constructors
    public Person(String firstName,
                  String lastName,
                  int age,
                  boolean male) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;

        setMale(male);
        //this.isMale = male;
    }

    public Person(String firstName, String lastName) {
        this(firstName, lastName, 0, false);
    }

    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;

        this.isMale = true;

        // this(firstName, lastName, age, true);
    }

    // getters
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public boolean isMale() {
        return isMale;
    }

    // setters
    public void setAge(int age) {
        this.age = age;
    }

    public void setMale(boolean male) {
        isMale = male;
    }

    @Override
    public String toString(){
        return firstName + " " +  lastName
                + " age: " + age + " male: " + isMale;
    }


    public String getFullName(){
        return "Full name: " + firstName + " " +  lastName;
    }

    public void growAge(){
        age++;
    }
}
