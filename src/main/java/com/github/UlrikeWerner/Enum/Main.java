package com.github.UlrikeWerner.Enum;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        Map<BigInteger, Person> listOfPerson = new HashMap<>();
        BigInteger id1 = new BigInteger("1");
        BigInteger id2 = new BigInteger("2");
        BigInteger id3 = new BigInteger("3");
        BigInteger id4 = new BigInteger("4");
        BigInteger id5 = new BigInteger("5");
        listOfPerson.put(id1, new Person(id1, "Klaus Peter", Gender.MALE, DaysOfWeek.WEDNESDAY));
        listOfPerson.put(id2, new Person(id2, "Claudia Grün", Gender.FEMALE, DaysOfWeek.MONDAY));
        listOfPerson.put(id3, new Person(id3, "Max Min", Gender.VARIOUS, DaysOfWeek.SUNDAY));
        listOfPerson.put(id4, new Person(id4, "Sabine Insekt", Gender.FEMALE, DaysOfWeek.SUNDAY));
        listOfPerson.put(id5, new Person(id5, "Max Jung", Gender.FEMALE, DaysOfWeek.FRIDAY));

        PersonRepository pRepo = new PersonRepository(listOfPerson);

        Optional<Person> optionalPerson = pRepo.findPersonById(new BigInteger("13"));
        if(optionalPerson.isPresent()){
            System.out.println(optionalPerson.get().name() + " Lieblingswochentag ist: " + optionalPerson.get().favoriteDay());
            if(optionalPerson.get().favoriteDay() == DaysOfWeek.SUNDAY || optionalPerson.get().favoriteDay() == DaysOfWeek.SATURDAY){
                System.out.println(optionalPerson.get().favoriteDay() + " ist " + optionalPerson.get().favoriteDay().getTypeOfDay());
            }else {
                System.out.println(optionalPerson.get().favoriteDay() + " ist ein " + optionalPerson.get().favoriteDay().getTypeOfDay());
            }
        } else {
            System.out.println("Person gibt es nicht!");
        }

        Optional<Map<Gender, Integer>> genderOfTheRepo = pRepo.countGender();
        if(genderOfTheRepo.isPresent() && !genderOfTheRepo.get().isEmpty()){
            System.out.println("Die Verteilung von den Geschlechter ist: " + genderOfTheRepo.get());
        } else {
            System.out.println("Die Liste ist leer!");
        }
    }
}
