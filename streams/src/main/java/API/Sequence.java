package API;

import java.io.File;

public abstract class Sequence<T> implements Iterable {
    public <Q> Sequence<Q> map(Mapper<T, Q> mapper) {
        LinkedListSequence<Q> res = new LinkedListSequence<>();
        for (Object elem : this) {
            res.add(mapper.map((T) elem));
        }
        return res;
    }

    public Sequence<T> filter(Filter<T> filter) {
        LinkedListSequence<T> res = new LinkedListSequence<>();
        for (Object elem : this) {
            if (filter.filter((T) elem)) {
                res.add((T) elem);
            }
        }
        return res;
    }

    public T reduce(T init, Reducer<T> reducer) {
        T res = init;
        for (Object elem : this) {
            res = reducer.reduce((T) elem, res);
        }
        return res;
    }

    public static <T> Sequence<T> flatten(Sequence<Sequence<T>> sequenceSequence) {
        LinkedListSequence<T> res = new LinkedListSequence<>();
        sequenceSequence.map((seq) -> {
            seq.map(x -> {
                res.add(x);
                return (Void) new Object();
            });
            return (Void) new Object();
        });
        return res;
    }
}
