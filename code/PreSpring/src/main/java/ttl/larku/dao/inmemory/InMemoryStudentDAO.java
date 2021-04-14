package ttl.larku.dao.inmemory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ttl.larku.dao.BaseDAO;
import ttl.larku.dao.StudentDAO;
import ttl.larku.domain.Student;

public class InMemoryStudentDAO implements StudentDAO {
	// static so it isn't constantly initialized - solves the reinit problem
    private Map<Integer, Student> students = new HashMap<Integer, Student>();
    private static int nextId = 0;

    @Override
	public void update(Student updateObject) {
        if (students.containsKey(updateObject.getId())) {
            students.put(updateObject.getId(), updateObject);
        }
    }

    public void delete(Student student) {
        students.remove(student.getId());
    }

    @Override
	public Student create(Student newObject) {
        //Create a new Id
        int newId = nextId++;
        newObject.setId(newId);
        students.put(newId, newObject);

        return newObject;
    }

    @Override
	public Student get(int id) {
        return students.get(id);
    }

    @Override
	public List<Student> getAll() {
        return new ArrayList<Student>(students.values());
    }

    public void deleteStore() {
        students = null;
    }

    public void createStore() {
        students = new HashMap<Integer, Student>();
    }

    public Map<Integer, Student> getStudents() {
        return students;
    }
}
