package strings;

@FunctionalInterface 
public interface Calc<T> {
    T calculate(T...values);
}
