package org.example;

import API.*;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        Sequence<Integer> seq = new LinkedListSequence<Integer>()
                .add(1)
                .add(2)
                .add(3)
                .add(4);
        Sequence<Integer> doubles = seq.map(new Mapper<Integer, Integer>() {
            @Override
            public Integer map(Integer elem) {
                return elem * 2;
            }
        });
        Sequence<Integer> sameDoubles = seq.map(x -> x * 2);
        printSeq(doubles);
        printSeq(sameDoubles);
        Sequence<Integer> moreFive = doubles.filter(new Filter<Integer>() {
            @Override
            public boolean filter(Integer elem) {
                return elem > 5;
            }
        });
        Sequence<Integer> moreThree = doubles.filter(x -> x > 3);
        printSeq(moreFive);
        printSeq(moreThree);

        int sum = doubles.reduce(0, Integer::sum);
        int doubleSum = doubles.reduce(0, new Reducer<Integer>() {
            @Override
            public Integer reduce(Integer elem, Integer init) {
                return 2 * (elem + init);
            }
        });
        System.out.println(sum);
        System.out.println(doubleSum);
    }

    private static <T> void printSeq(Sequence<T> seq) {
        System.out.println("######");
        Iterator<T> iterator = seq.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
    }
}