package Homework8;

import java.util.Objects;

public class Cat {
    private int age;

    public Cat(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    @Override
    public int hashCode() {
        return Objects.hash(age);
    }
}
