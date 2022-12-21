package service.impl;

import dao.Database;
import enams.Gender;
import model.Animal;
import model.Person;
import service.GenericService;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class PersonServiceImpl implements GenericService<Person> {
    Database person = new Database();

    @Override
    public String add(List<Person> t) {
        person.getUsers().addAll(t);
        return "Successfully Added ! ";
    }

    @Override
    public Person getById(Long id) {
        List<Person> people = person.getUsers().stream().filter(x -> x.getId().equals(id)).toList();
        for (Person person1 : people) {
            return person1;
        }
        return null;
    }

    @Override
    public String removeByName(String name) {
        List<Person> list = person.getUsers().stream().filter(x -> x.getName().equals(name)).toList();
        person.getUsers().removeAll(list);
        return "Successfully removed !";
    }

    @Override
    public List<Person> getAll() {
        return person.getUsers();
    }

    @Override
    public List<Person> sortByName() {
        System.out.println("Enter by command : (1.ascending/2.descending)");
        int num = new Scanner(System.in).nextInt();
        switch (num) {
            case 1 -> {
                List<Person> list = person.getUsers().stream().sorted(Comparator.comparing(Person::getName)).toList();
                return list;
            }
            case 2 -> {
                List<Person> list = person.getUsers().stream().sorted(Comparator.comparing(Person::getName).reversed()).toList();
                return list;
            }
        }
        return null;
    }

    @Override
    public List<Person> filterByGender() {
        System.out.println("Enter by command : (1.Male/2.Female) ");
        int num = new Scanner(System.in).nextInt();
        switch (num) {
            case 1 -> {
                List<Person> list = person.getUsers().stream().filter(x -> x.getGender().equals(Gender.MALE)).toList();
                return list;
            }
            case 2 -> {
                List<Person> list = person.getUsers().stream().filter(x -> x.getGender().equals(Gender.FEMALE)).toList();
                return list;
            }
        }
        return null;
    }

    @Override
    public List<Person> clear() {
        person.getUsers().clear();
        return person.getUsers();
    }
}
