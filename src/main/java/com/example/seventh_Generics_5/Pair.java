package com.example.seventh_Generics_5;

public class Pair<T, K> {

    private T one;
    private K two;

    public  Pair(T one, K two) {
        this.one = one;
        this.two = two;
    }

    public static  <T, K> Pair <T, K> pairCreate(T one, K two){
        return new Pair(one,two);
    }

    public Pair<K, T> swap() {
        return new Pair<>(this.two, this.one);
    }

    public T getOne() {
        return one;
    }

    public K getTwo() {
        return two;
    }

    @Override
    public String toString() {
        return "Boom{" +
                "one=" + one +
                ", two=" + two +
                '}';
    }
}
