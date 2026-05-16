package com.example.fifth_Generics_2;

public class Box <T>{

    private T value;

    public Box(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Box[" + "type: " + this.getClass() + "value: " + value + ']';
    }
}
