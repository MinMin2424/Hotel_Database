package cz.cvut.fel.dbs.dao;

import cz.cvut.fel.dbs.entities.ZamereniEntity;
import jakarta.persistence.EntityManager;

public class ZamereniDAO extends BaseDAO<ZamereniEntity> {

    protected ZamereniDAO(Class<ZamereniEntity> type) {
        super(type);
    }

    protected ZamereniDAO(Class<ZamereniEntity> type, EntityManager entityManager) {
        super(type, entityManager);
    }

}
