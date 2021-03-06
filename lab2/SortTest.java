import sorts.AbstractSort;
import sorts.Date_;
import sorts.InsertionSort;
import sorts.SelectSort;
import sorts.IterativeMergeSort;
import sorts.MergeSort;
import sorts.ShellSort;

import java.util.stream.DoubleStream;
import java.util.stream.LongStream;

public class SortTest {
    public static void main(String[] args) {
        int[] maxes = {1250, 4500, 7000, 10000, 15000, 25000, 45000, 60000, 85000, 100000};
        AbstractSort[] sorts = {
                new InsertionSort("Вставками"),
                new SelectSort("Выбором"),
                new MergeSort("Слиянием"),
                new IterativeMergeSort("Итеративная слиянием"),
                new ShellSort("Шелла")
        };

        for (AbstractSort sort: sorts) {
            System.out.println("Сортировка " + sort.toString());
            for (int max: maxes) {
                System.out.print("Кол-во элементов: " + max);
                testSort(max, sort);
            }
        }

    }

    private static void testSort(int MAX, AbstractSort sort) {
        int testsAmount = 5;
        long[] times = new long[testsAmount];
        for (int i = 0; i < testsAmount; i++) {
            Date_[] a = new Date_[MAX];
            for(int j = 0; j < MAX; j++) {
                a[j] = new Date_();
            }
            long start = System.currentTimeMillis();
            sort.sort(a);
            long finish = System.currentTimeMillis();
            times[i] = finish - start;
        }
        long timeSum = LongStream.of(times).sum();
        long timeAverage = timeSum/times.length;

        System.out.printf(" time: %d ms\n", timeAverage);
    }
}
