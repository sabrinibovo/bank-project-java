package com.sabrinibovo.bank.app;

import com.sabrinibovo.bank.model.Person;
import java.util.HashSet;
import java.util.Set;

public class Principal2 {

    public static void main(String[] args) {
        Person person1 = new Person("Jady Bovo", "54748932148");
        Person person2 = new Person("Marcelo Melo", "214974231564");

        Set<Person> persons = new HashSet<>();
        persons.add(person1);
        persons.add(person2);

        System.out.println(persons.toString());

       //Person person3 = persons.get(1);
        //System.out.println(person3);

      //for (int i = 0; i < persons.size(); i++) {
           //System.out.println(persons.get(i).getName());
        //}

       //for (Person person : persons) {
            //System.out.println(person.getName());
      //}

        Person person4 = new Person("Jady Bovo", "54748932148");

        boolean isReal = persons.contains(person4);
        System.out.println(isReal);

       System.out.println(person1.equals(person4));
    }

}
