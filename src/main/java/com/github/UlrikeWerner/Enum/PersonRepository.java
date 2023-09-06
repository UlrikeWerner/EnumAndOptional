package com.github.UlrikeWerner.Enum;

import java.math.BigInteger;
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
