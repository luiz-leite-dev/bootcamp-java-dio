package threads;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.SynchronousQueue;

public class ThreadsLesson {

    private final static List<Integer> numbers = new ArrayList<>();

    private final static Queue<Integer> numbers2 = new LinkedBlockingDeque<>(250_000);

    private static void inc2(Integer number) {
        numbers2.add(number);
    }

    private static void show2() {
        System.out.println(numbers2);
    }

    private synchronized static void inc(Integer number) {
        numbers.add(number);
    }

    private synchronized static void show() {
        System.out.println(numbers);
    }
    public static void main(String[] args) {

        Runnable inc = () -> {
            for (int i = 0; i < 100_000; i++) {
                inc2(i);
            }
        };

        Runnable dec = () -> {
            for (int i = 100_000; i > 0; i--) {
                inc2(i);
            }
        };

        Runnable show = () -> {
            for (int i = 0; i < 250_000; i++) {
                show2();
            }
        };

        new Thread(inc).start();
        new Thread(dec).start();
        new Thread(show).start();
        
    }
}
