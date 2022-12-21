import enams.Gender;
import model.Animal;
import model.Person;
import service.impl.AnimalServiceImpl;
import service.impl.PersonServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static AnimalServiceImpl animalService = new AnimalServiceImpl();
    public static PersonServiceImpl personService = new PersonServiceImpl();

    public static void main(String[] args) {

        List<Person> people = List.of(
                new Person(1L, "Ilim", (byte) 19, Gender.MALE),
                new Person(2L, "Nuradil", (byte) 18, Gender.MALE),
                new Person(3L, "Dastan", (byte) 20, Gender.FEMALE));

        List<Animal> animals = List.of(
                new Animal(6L, "Cat", (byte) 3, Gender.FEMALE),
                new Animal(4L, "Dog", (byte) 4, Gender.FEMALE),
                new Animal(5L, "Horse", (byte) 5, Gender.MALE));

        while (true) {
            System.out.println("""
                    =====PERSON COMMANDS=====
                    1.ADD PERSON
                    2.GET BY ID PERSON
                    3.GET ALL PERSON
                    4.SORT BY NAME PERSON
                    5.FILTER BY GENDER PERSON
                    6.CLEAR PERSON
                    7.REMOVE PERSON
                    =====================
                    =====ANIMAL COMMANDS=====
                    8.ADD ANIMAL
                    9.GET BY ID ANIMAL
                    10.GET ALL ANIMAL
                    11.SORT BY NAME ANIMAL
                    12.FILTER BY GENDER ANIMAL
                    13.CLEAR ANIMAL
                    14.REMOVE ANIMAL
                                       
                    """);
            System.out.println("Enter by command :");
            int num = new Scanner(System.in).nextInt();
            switch (num) {
                case 1 -> System.out.println(personService.add(people));
                case 2 -> {
                    System.out.println("Enter by id: ");
                    Long id = new Scanner(System.in).nextLong();
                    System.out.println(personService.getById(id));
                }
                case 3 -> System.out.println(personService.getAll());
                case 4 -> System.out.println(personService.sortByName());
                case 5 -> System.out.println(personService.filterByGender());
                case 6 -> {
                    System.out.println(personService.clear());
                }
                case 7 -> {
                    System.out.println("Enter by name :");
                    String name = new Scanner(System.in).nextLine();
                    System.out.println(personService.removeByName(name));
                }
                case 8 -> System.out.println(animalService.add(animals));
                case 9 -> {
                    System.out.println("Enter by id: ");
                    Long id = new Scanner(System.in).nextLong();
                    System.out.println(animalService.getById(id));
                }
                case 10 -> System.out.println(animalService.getAll());
                case 11 -> System.out.println(animalService.sortByName());
                case 12 -> System.out.println(animalService.filterByGender());
                case 13 -> System.out.println(animalService.clear());
                case 14 -> {
                    System.out.println("Enter by name :");
                    String name = new Scanner(System.in).nextLine();
                    System.out.println(animalService.removeByName(name));
                }
            }
        }
    }
}