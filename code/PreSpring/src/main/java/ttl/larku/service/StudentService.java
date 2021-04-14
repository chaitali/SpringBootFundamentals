package ttl.larku.service;

import ttl.larku.dao.DAOFactory;
import ttl.larku.dao.StudentDAO;
import ttl.larku.dao.jpa.JpaStudentDAO;
import ttl.larku.domain.Student;
import ttl.larku.domain.Student.Status;

import java.util.ArrayList;
import java.util.List;

public class StudentService {

    List<String> stuff = new ArrayList<>();

    //private InMemoryStudentDAO studentDAO;
//    private BaseDAO<Student> studentDAO;
    private StudentDAO studentDAO;

    public StudentService(StudentDAO studentDAO) {
    	// reference to DAO
    	// how arrows between components are setup
    	// dependency satsifes by class itself
    	
//        studentDAO = new JpaStudentDAO();
    	// depeendency injection form, needs a DAO, telling something else to set it up for me 
    	
//    	studentDAO = DAOFactory.getStudentDAO();
    	
    	this.studentDAO = studentDAO;
    }

    public Student createStudent(String name, String phoneNumber, Status status) {
        Student student = new Student(name, phoneNumber, status);
        student = studentDAO.create(student);

        return student;
    }

    public Student createStudent(Student student) {
        student = studentDAO.create(student);

        return student;
    }

    public void deleteStudent(int id) {
        Student student = studentDAO.get(id);
        if (student != null) {
            studentDAO.delete(student);
        }
    }

    public void updateStudent(Student student) {
        studentDAO.update(student);
    }

    public Student getStudent(int id) {
        return studentDAO.get(id);
    }

    public List<Student> getAllStudents() {
        return studentDAO.getAll();
    }

//    public BaseDAO<Student> getStudentDAO() {
//        return studentDAO;
//    }
//
//    public void setStudentDAO(BaseDAO<Student> studentDAO) {
//        this.studentDAO = studentDAO;
//    }
}
