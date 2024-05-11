package cz.cvut.fel.dbs.dao;

import cz.cvut.fel.dbs.entities.StravovaciCastEntity;
import jakarta.persistence.EntityManager;

public class StravovaciCastDAO extends BaseDAO<StravovaciCastEntity> {

    protected StravovaciCastDAO(Class<StravovaciCastEntity> type) {
        super(type);
    }

    protected StravovaciCastDAO(Class<StravovaciCastEntity> type, EntityManager entityManager) {
        super(type, entityManager);
    }

}
