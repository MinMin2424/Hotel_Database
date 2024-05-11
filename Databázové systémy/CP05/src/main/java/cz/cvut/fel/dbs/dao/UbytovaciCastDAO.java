package cz.cvut.fel.dbs.dao;

import cz.cvut.fel.dbs.entities.HotelEntity;
import cz.cvut.fel.dbs.entities.UbytovaciCastEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.List;

public class UbytovaciCastDAO extends BaseDAO<UbytovaciCastEntity> {

    public UbytovaciCastDAO(Class<UbytovaciCastEntity> type) {
        super(type);
    }

    public UbytovaciCastDAO(Class<UbytovaciCastEntity> type, EntityManager entityManager) {
        super(type, entityManager);
    }

    public List<UbytovaciCastEntity> getByIdHotel(HotelEntity hotel) {
        try {
            return entityManager.createQuery(
                    "SELECT e FROM UbytovaciCastEntity e " +
                            "WHERE e.idHotel = :hotel",
                            UbytovaciCastEntity.class)
                    .setParameter("hotel", hotel)
                    .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public UbytovaciCastEntity findByCisloPokoju(int cisloPokoju) {
        try {
            return entityManager.createQuery(
                    "SELECT uc FROM UbytovaciCastEntity uc WHERE uc.cisloPokoju = :cisloPokoju",
                    UbytovaciCastEntity.class)
                    .setParameter("cisloPokoju", cisloPokoju)
                    .getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
