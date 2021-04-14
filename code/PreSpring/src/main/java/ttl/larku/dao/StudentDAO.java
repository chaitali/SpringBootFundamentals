package ttl.larku.dao;

import java.util.List;

import ttl.larku.domain.Student;

public interface StudentDAO {

	void update(Student updateObject);

	Student create(Student newObject);

	Student get(int id);

	List<Student> getAll();

	void delete(Student student);

}