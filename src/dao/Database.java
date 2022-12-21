package dao;

import model.Animal;
import model.Person;

import java.util.ArrayList;
import java.util.List;

public class Database {
    private List<Person> users = new ArrayList<>();
    private List<Animal> animals = new ArrayList<>();

    public List<Person> getUsers() {
        return users;
    }

    public void setUsers(List<Person> users) {
        this.users = users;
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }
}
