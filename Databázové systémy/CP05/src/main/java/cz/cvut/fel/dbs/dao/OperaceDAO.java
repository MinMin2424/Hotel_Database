package cz.cvut.fel.dbs.dao;

import cz.cvut.fel.dbs.entities.OperaceEntity;
import jakarta.persistence.EntityManager;

public class OperaceDAO extends BaseDAO<OperaceEntity> {

    protected OperaceDAO(Class<OperaceEntity> type) {
        super(type);
    }

    protected OperaceDAO(Class<OperaceEntity> type, EntityManager entityManager) {
        super(type, entityManager);
    }

}
