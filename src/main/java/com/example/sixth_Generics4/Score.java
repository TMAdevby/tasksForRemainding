package com.example.sixth_Generics4;

public class Score implements Validatable, Comparable<Score> {

    private int value;

    public Score(int value) {
        this.value = value;
    }

    @Override
    public boolean isValid() {
        return value >= 0 ? true : false;
    }

    @Override
    public int compareTo(Score other) {
        return Integer.compare(this.value, other.value);
    }

    @Override
    public String toString() {
        return "Score{" +
                "value=" + value +
                '}';
    }
}
