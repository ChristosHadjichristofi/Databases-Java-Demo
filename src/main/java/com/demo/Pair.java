package com.demo;

/**
 * pair class in order to create objects of any type which will hold two values.
 * this class was used to hold where the user placed the letter
 * @param <T1> whatever type you want
 * @param <T2> whatever type you want
 */

public class Pair<T1, T2> {

    private final T1 x;
    private final T2 y;

    public Pair(T1 x, T2 y) {
        this.x = x;
        this.y = y;
    }

    public T1 first() { return x; }
    public T2 second() { return y; }
}