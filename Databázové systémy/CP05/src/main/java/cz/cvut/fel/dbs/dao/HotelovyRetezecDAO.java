package cz.cvut.fel.dbs.dao;

import cz.cvut.fel.dbs.entities.HotelovyRetezecEntity;
import jakarta.persistence.EntityManager;

public class HotelovyRetezecDAO extends BaseDAO<HotelovyRetezecEntity>{

    protected HotelovyRetezecDAO(Class<HotelovyRetezecEntity> type) {
        super(type);
    }

    protected HotelovyRetezecDAO(Class<HotelovyRetezecEntity> type, EntityManager entityManager) {
        super(type, entityManager);

    }

}
