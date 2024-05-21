package org.example;

public class author {
    private String name;
    private String email;
    private char gender;

    public author(String name, String email, char gender) {
        this.name = name;
        this.email = email;
        this.gender = gender;
    }

    public String getName()
    {
        return name;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public char getGender()
    {
        return gender;
    }

    @Override
    public String toString()
    {
        return "Автор: " + name + ", пол: " + gender + ", email: " + email;
    }
}