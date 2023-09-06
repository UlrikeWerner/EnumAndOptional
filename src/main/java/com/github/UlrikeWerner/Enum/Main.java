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
        listOfPerson.put(id1, new Person(id1, "Klaus Peter", DaysOfWeek.WEDNESDAY));
        listOfPerson.put(id2, new Person(id2, "Claudia Grün", DaysOfWeek.MONDAY));
        listOfPerson.put(id3, new Person(id3, "Max Min", DaysOfWeek.SUNDAY));

        PersonRepository pRepo = new PersonRepository(listOfPerson);

        Optional<Person> optionalPersonm = pRepo.findPersonById(new BigInteger("13"));
        if(optionalPersonm.isPresent()){
            System.out.println(optionalPersonm.get().name() + " Lieblingswochentag ist: " + optionalPersonm.get().favoriteDay());
            if(optionalPersonm.get().favoriteDay() == DaysOfWeek.SUNDAY || optionalPersonm.get().favoriteDay() == DaysOfWeek.SATURDAY){
                System.out.println(optionalPersonm.get().favoriteDay() + " ist " + optionalPersonm.get().favoriteDay().getTypeOfDay());
            }else {
                System.out.println(optionalPersonm.get().favoriteDay() + " ist ein " + optionalPersonm.get().favoriteDay().getTypeOfDay());
            }
        } else {
            System.out.println("Person gibt es nicht!");
        }
    }
}
