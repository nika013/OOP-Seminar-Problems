import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Objects;

public class Pair<T1, T2> {
    private T1 first;
    private T2 second;

    public Pair(T1 first, T2 second) {
        this.first = first;
        this.second = second;
    }

    /**
     * This method returns clone of T1 in case if it is clonable, because
     * client should not be able to change private variables of this class with direct acces
     * @return T1 object
     */
    public T1 getFirst() {
        return first;
    }

    public T2 getSecond() {
        return second;
    }

    public void setFirst(T1 firstValue) {
        this.first = firstValue;
    }

    public void setSecond(T2 secondValue) {
        this.second = secondValue;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Pair)) {
            return false;
        }
        Pair<?, ?> compare = (Pair<?, ?>) obj;
        return compare.getFirst().equals(first) && compare.getSecond().equals(second);
    }
}
