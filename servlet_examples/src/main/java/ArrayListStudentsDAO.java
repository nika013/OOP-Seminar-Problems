import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class ArrayListStudentsDAO implements StudentsDAO{
    private HashSet<Student> students = new HashSet<>();
    @Override
    public synchronized void add(Student s) {
        students.add(s);
    }

    @Override
    public synchronized void remove(Student s) {
        students.remove(s);
    }

    @Override
    public List<Student> getAll() {
        return new ArrayList<>(students);
    }
}
