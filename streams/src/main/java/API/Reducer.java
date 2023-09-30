package API;

public interface Reducer<T> {
    T reduce(T elem, T init);
}
