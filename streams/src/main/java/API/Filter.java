package API;

public interface Filter<T> {
    boolean filter(T elem);
}
