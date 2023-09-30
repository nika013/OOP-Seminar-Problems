package API;

public interface Mapper<T, Q> {
    Q map(T elem);
}
