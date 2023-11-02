package service;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

import models.Course;
import models.Teacher;

public class TeacherService {
    private final EntityManager entityManager;

    public TeacherService(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Teacher> getAllTeachers() {
        String jpql = "SELECT t FROM Teacher t";
        TypedQuery<Teacher> query = entityManager.createQuery(jpql, Teacher.class);
        return query.getResultList();
    }
    public Teacher getTeacherById(int teacherId) {
        return entityManager.find(Teacher.class, teacherId);
    }
    public void createTeacher(Teacher teacher) {
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            entityManager.persist(teacher);
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

    public void updateTeacher(Teacher updatedTeacher) {
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            entityManager.merge(updatedTeacher);
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

    public void deleteTeacher(int teacherId) {
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            Teacher teacherToDelete = entityManager.find(Teacher.class, teacherId);
            if (teacherToDelete != null) {
                entityManager.remove(teacherToDelete);
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

