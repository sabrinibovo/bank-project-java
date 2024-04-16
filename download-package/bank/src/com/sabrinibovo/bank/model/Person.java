package com.sabrinibovo.bank.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

public class Person {

    private String name;
    private String document;
    private BigDecimal purchase;
    private PersonType type = PersonType.NATURAL;
    private LocalDateTime dateLastUpdate = LocalDateTime.now();

    public Person() {

    }

    public Person(String name, String document) {
        this.name = name;
        this.document = document;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public BigDecimal getPurchase() {
        return purchase;
    }

    public void setPurchase(BigDecimal purchase) {
        this.purchase = purchase;
    }

    public PersonType getType() {
        return type;
    }

    public void setType(PersonType type) {
        this.type = type;
    }

    public LocalDateTime getDateLastUpdate() {
        return dateLastUpdate;
    }

    public void setDateLastUpdate(LocalDateTime dateLastUpdate) {
        this.dateLastUpdate = dateLastUpdate;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", document='" + document + '\'' +
                ", type=" + type +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(document, person.document);
    }

    @Override
    public int hashCode() {
        return Objects.hash(document);
    }

}
