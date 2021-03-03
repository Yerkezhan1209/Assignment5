package kz.aitu.oop.practice.assignment5.entities;

public class User <T> {
    private T name;

    public User() { }

    public User(T name) { setName(name); }

    public T getName() { return name; }

    public void setName(T name) { this.name = name; }

    public String greet (T name) {
        return "Hello, " + name + "!";
    }
}
