package com.github.UlrikeWerner.Enum;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

public class PersonRepository {
    Map<BigInteger, Person> personMap;

    public PersonRepository(Map<BigInteger, Person> personMap) {
        this.personMap = personMap;
    }

    public Map<BigInteger, Person> getPersonMap() {
        return personMap;
    }

    public void setPersonMap(Map<BigInteger, Person> personMap) {
        this.personMap = personMap;
    }

    public Optional<Person> findPersonById(BigInteger personId){
        if(personMap.containsKey(personId)){
            return Optional.ofNullable(personMap.get(personId));
        }
        return Optional.empty();
    }

    public Optional<Person> findPersonByName(String name){
        if(!personMap.isEmpty()){
            for(Map.Entry<BigInteger, Person> entry : personMap.entrySet()){
                Optional<Person> person = Optional.of(entry.getValue());
                if(person.get().name().equals(name)){
                    return person;
                }
            }
        }
        return Optional.empty();
    }

    public Optional<Map<Gender, Integer>> countGender(){
        Map<Gender, Integer> genderCount = new HashMap<>();
        if(!personMap.isEmpty()){
            for(Map.Entry<BigInteger, Person> entry : personMap.entrySet()){
                genderCount.putIfAbsent(entry.getValue().gender(), 0);
                genderCount.put(entry.getValue().gender(), genderCount.get(entry.getValue().gender()) +1);
            }
            return Optional.of(genderCount);
        }
        return Optional.empty();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonRepository that = (PersonRepository) o;
        return Objects.equals(personMap, that.personMap);
    }

    @Override
    public int hashCode() {
        return Objects.hash(personMap);
    }

    @Override
    public String toString() {
        return "PersonRepository{" +
                "personMap=" + personMap +
                '}';
    }
}
