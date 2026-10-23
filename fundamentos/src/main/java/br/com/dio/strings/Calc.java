package br.com.dio.strings;

@FunctionalInterface 
public interface Calc<T> {
    T calculate(T...values);
}
