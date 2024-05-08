package cz.cvut.fel.dbs.dao;

import cz.cvut.fel.dbs.entities.EmailEntity;
import jakarta.persistence.EntityManager;

public class EmailDAO extends BaseDAO<EmailEntity> {

    protected EmailDAO(Class<EmailEntity> type) {
        super(type);
    }

    protected EmailDAO(Class<EmailEntity> type, EntityManager entityManager) {
        super(type, entityManager);
    }

}
