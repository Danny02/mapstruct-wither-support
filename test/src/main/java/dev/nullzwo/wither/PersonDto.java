package dev.nullzwo.wither;

public class PersonDto {
    private final String name;
    private final int age;

    public PersonDto(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person withName(String name) {
        return new Person(name, age);
    }

    public Person withAge(int age) {
        return new Person(name, age);
    }
}
