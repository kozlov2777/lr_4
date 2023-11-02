package service;

import models.Subject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class SubjectService {
    private final EntityManager entityManager;

    public SubjectService(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Subject> getAllSubjects() {
        String jpql = "SELECT s FROM Subject s";
        TypedQuery<Subject> query = entityManager.createQuery(jpql, Subject.class);
        return query.getResultList();
    }

    public Subject getSubjectById(int subjectId) {
        return entityManager.find(Subject.class, subjectId);
    }

    public void createSubject(Subject subject) {
        entityManager.getTransaction().begin();
        entityManager.persist(subject);
        entityManager.getTransaction().commit();
    }

    public void updateSubject(Subject updatedSubject) {
        entityManager.getTransaction().begin();
        entityManager.merge(updatedSubject);
        entityManager.getTransaction().commit();
    }

    public void deleteSubject(int subjectId) {
        entityManager.getTransaction().begin();
        Subject subjectToDelete = entityManager.find(Subject.class, subjectId);
        if (subjectToDelete != null) {
            entityManager.remove(subjectToDelete);
        }
        entityManager.getTransaction().commit();
    }
}

