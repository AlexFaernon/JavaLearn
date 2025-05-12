package Laba6;

public class t5 {
    static int globalMax = Integer.MIN_VALUE;

    public static void main(String[] args) throws InterruptedException {
        int[] array = {12, 55, 33, 78, 5, 99, 101, 23, 56, 88, 3, 67, 42, 90};
        int cores = Runtime.getRuntime().availableProcessors();

        Thread[] threads = new Thread[cores];
        int chunkSize = (int) Math.ceil((double) array.length / cores);

        Object lock = new Object();

        for (int i = 0; i < cores; i++) {
            int start = i * chunkSize;
            int end = Math.min(start + chunkSize, array.length);

            threads[i] = new Thread(() -> {
                int localMax = Integer.MIN_VALUE;
                for (int j = start; j < end; j++) {
                    if (array[j] > localMax) localMax = array[j];
                }
                synchronized (lock) {
                    if (localMax > globalMax) globalMax = localMax;
                }
            });
            threads[i].start();
        }

        for (Thread thread : threads) {
            if (thread != null) thread.join();
        }

        System.out.println(globalMax);
    }
}
