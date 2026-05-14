package com.example.fourh_Generics;

import java.util.List;
import java.util.Objects;
import java.util.TreeSet;

public class SafeContainer<T extends Comparable<T>> {
    private final T value;

    public SafeContainer(T value) {
        Objects.requireNonNull(value, "Value cannot be null");
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    // TODO 1: реализуй isGreater
    public boolean isGreater(SafeContainer<T> other) {
        return this.getValue().compareTo(other.getValue()) > 0 ;
    }

    // TODO 2: реализуй статический дженерик-метод findMax
    // Обратите внимание: у метода СВОЙ тип <E>, он НЕ обязан совпадать с T класса
    public static <E extends Comparable<E>> E findMax(List<SafeContainer<E>> containers) {
        SafeContainer<E> max = containers.get(0);
        for(SafeContainer<E> item : containers){
            if(item.isGreater(max)){
                max = item;
            }
        }
        return max.getValue();
    }
}