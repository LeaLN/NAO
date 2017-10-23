package com.naotictactoe.nao.model;


public class User {
    private long id;
    private String name;
    private String mail;
    private int age;


    public long id() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append(name)
                .append(" ")
                .append(mail).toString();
    }

}
