import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Streams<T> {
    public List<T> removeConsecutiveDuplicates(Stream<T> items, Comparator<T> cmp) {
        List<T> elems = items.toList();
        Stream<T> res = IntStream.range(0, elems.size())
                .filter((i) -> {
                  if (i == 0) return true;
                  return cmp.compare(elems.get(i), elems.get(i-1)) != 0;
                })
                .mapToObj(elems::get);
        return res.toList();
    }

    public List<T> removeEveryNth(Stream<T> items, int n) {
        List<T> all = items.toList();
        Stream<T> removed = IntStream.range(0, all.size())
                .filter(i -> (i + 1) % n != 0)
                .mapToObj(all::get);
        return removed.toList();
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        Streams streams = new Streams();
        Stream<Integer> items = Arrays.stream(arr).mapToObj(Integer::valueOf);
        printList(streams.removeEveryNth(items, 2));

        int[] arr2 = {1, 2, 2, 1, 2, 2, 2};
        Stream<Integer> items2 = Arrays.stream(arr2).mapToObj(Integer::valueOf);
        printList(streams.removeConsecutiveDuplicates(items2, Comparator.naturalOrder()));
    }

    private static <T> void printList(List<T> ls) {
        for (Object i : ls) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
