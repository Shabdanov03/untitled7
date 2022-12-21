package model;

import enams.Gender;

public class Person {
    private Long id;
    private String name;
    private byte age;
    private Gender gender;

    public Person(Long id, String name, byte age, Gender gender) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte getAge() {
        return age;
    }

    public void setAge(byte age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "  \n Person{" +
                "\nid=" + id +
                "\n name='" + name +
                "\n age=" + age +
                "\n gender=" + gender +
                "\n====================";
    }
}
