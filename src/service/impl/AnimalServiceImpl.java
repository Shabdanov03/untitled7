package service.impl;

import dao.Database;
import enams.Gender;
import model.Animal;
import service.GenericService;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class AnimalServiceImpl implements GenericService<Animal> {
    Database animals = new Database();

    @Override
    public String add(List<Animal> t) {
        this.animals.getAnimals().addAll(t);
        return "Successfully Added !";
    }

    @Override
    public Animal getById(Long id) {
        return (Animal) animals.getAnimals().stream().filter(x->x.getId().equals(id));
    }

    @Override
    public String removeByName(String name) {
        List<Animal> animals1 = animals.getAnimals().stream().filter(x -> x.getName().equals(name)).toList();
        animals.getAnimals().removeAll(animals1);
        return "Successfully removed !";
    }

    @Override
    public List<Animal> getAll() {
        return animals.getAnimals();
    }

    @Override
    public List<Animal> sortByName() {
        System.out.println("Enter by command : (1.ascending/2.descending)");
        int num = new Scanner(System.in).nextInt();
        switch (num) {
            case 1 -> {
                List<Animal> list = animals.getAnimals().stream().sorted(Comparator.comparing(Animal::getName)).toList();
                return list;
            }
            case 2 -> {
                List<Animal> list = animals.getAnimals().stream().sorted(Comparator.comparing(Animal::getName).reversed()).toList();
                return list;
            }
        }
        return null;
    }

    @Override
    public List<Animal> filterByGender() {
        System.out.println("Enter by command : (1.Male/2.Female) ");
        int num = new Scanner(System.in).nextInt();
        switch (num) {
            case 1 -> {
                List<Animal> list = animals.getAnimals().stream().filter(x -> x.getGender().equals(Gender.MALE)).toList();
                return list;
            }
            case 2 -> {
                List<Animal> list = animals.getAnimals().stream().filter(x -> x.getGender().equals(Gender.FEMALE)).toList();
                return list;
            }
        }
        return null;
    }

    @Override
    public List<Animal> clear() {
      animals.getAnimals().clear();
        return animals.getAnimals();
    }
}