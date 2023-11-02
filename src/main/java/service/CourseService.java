package service;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;
import models.Course;

public class CourseService {
    private final EntityManager entityManager;

    public CourseService(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Course> getAllCourses() {
        String jpql = "SELECT c FROM Course c";
        TypedQuery<Course> query = entityManager.createQuery(jpql, Course.class);
        return query.getResultList();
    }
    public Course getCourseById(int courseId) {
        return entityManager.find(Course.class, courseId);
    }
    public void createCourse(Course course) {
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            entityManager.persist(course);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
    }

    public void updateCourse(Course updatedCourse) {
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            entityManager.merge(updatedCourse);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
    }

    public void deleteCourse(int courseId) {
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            Course courseToDelete = entityManager.find(Course.class, courseId);
            if (courseToDelete != null) {
                entityManager.remove(courseToDelete);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
    }
}

