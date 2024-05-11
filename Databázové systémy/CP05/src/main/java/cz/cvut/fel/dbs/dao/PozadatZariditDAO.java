package cz.cvut.fel.dbs.dao;

import cz.cvut.fel.dbs.entities.PozadatZariditEntity;
import jakarta.persistence.EntityManager;

public class PozadatZariditDAO extends BaseDAO<PozadatZariditEntity> {

    protected PozadatZariditDAO(Class<PozadatZariditEntity> type) {
        super(type);
    }

    protected PozadatZariditDAO(Class<PozadatZariditEntity> type, EntityManager entityManager) {
        super(type, entityManager);
    }

}
