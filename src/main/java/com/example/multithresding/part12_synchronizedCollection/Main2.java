import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main2 {
    public static void main(String[] args) throws InterruptedException {

        List<Integer> list = Collections.synchronizedList(new ArrayList<>());

        Thread writer = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                list.add(i);
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        Thread reader = new Thread(() -> {
            // Читаем периодически
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(200);
                    synchronized (list) {
                        System.out.println("Размер: " + list.size());
                        for (Integer x : list) {
                            System.out.println(x);
                        }
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        writer.start();
        reader.start();

        writer.join();
        reader.join();

        System.out.println("Finish");
    }
}