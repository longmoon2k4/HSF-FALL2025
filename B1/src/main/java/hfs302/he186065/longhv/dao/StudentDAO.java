package hfs302.he186065.longhv.dao;

import hfs302.he186065.longhv.pojo.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.List;

public class StudentDAO {
    private static EntityManager em;
    private static EntityManagerFactory emf;

    public StudentDAO(String persistanceName) {
        emf = Persistence.createEntityManagerFactory(persistanceName);
    }

    public void save(Student student) {
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            em.merge(student);
            em.getTransaction().commit();
        } catch (Exception ex) {
            em.getTransaction().rollback();
            System.out.println("Error " + ex.getMessage());
        } finally {
            // em.close();
        }
    }

    public List<Student> getStudents() {
        List<Student> students = null;
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            students = em.createQuery("from Student").getResultList();
        } catch (Exception ex) {
            System.out.println("Error " + ex.getMessage());
        } finally {
            // em.close();
        }
        return students;
    }

    public void delete(int studentID) {
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            Student s = em.find(Student.class, studentID);
            em.remove(s);
            em.getTransaction().commit();
        } catch (Exception ex) {
            System.out.println("Error " + ex.getMessage());
        } finally {
            // em.close();
        }
    }

    public Student findById(int studentID) {
        Student student = null;
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            student = em.find(Student.class, studentID);
        } catch (Exception ex) {
            System.out.println("Error " + ex.getMessage());
        } finally {
            // em.close();
        }
        return student;
    }

    public void update(Student student) {
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            Student s = em.find(Student.class, student.getId());
            if (s != null) {
                s.setFirstName(student.getFirstName());
                s.setLastName(student.getLastName());
                s.setMarks(student.getMarks());
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            System.out.println("Error " + ex.getMessage());
        } finally {
            // em.close();
        }
    }
}
