package ru.gb.lesson3;

public class Pair <T,K>{
    private T t;
    private K k;

    public Pair(T t, K k) {
        this.t = t;
        this.k = k;
    }

    public T getFirst() {
        return t;
    }

    public K getSecond() {
        return k;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Pair{");
        sb.append("t = ").append(t);
        sb.append(", k = ").append(k);
        sb.append('}');
        return sb.toString();
    }
}
