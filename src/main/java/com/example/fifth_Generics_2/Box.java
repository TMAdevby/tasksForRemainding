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

    public <U> Box<U> transform(U newValue){
        return new Box<>(newValue);
    }

    @Override
    public String toString() {
        // Если значение не null, берём его полное имя класса, иначе пишем "null"
        String typeName = (value != null) ? value.getClass().getName() : "null";
        return "Box[type: " + typeName + ", value: " + value + "]";
    }
}
