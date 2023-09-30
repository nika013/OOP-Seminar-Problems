import java.util.List;

public interface StudentsDAO  {
    void add(Student s);
    void remove(Student s);
    List<Student> getAll();
}
