package cz.cvut.fel.dbs.dao;

import cz.cvut.fel.dbs.entities.HotelEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;

import java.util.ArrayList;
import java.util.List;

public class HotelDAO extends BaseDAO<HotelEntity> {

    protected HotelDAO(Class<HotelEntity> type) {
        super(type);
    }

    protected HotelDAO(Class<HotelEntity> type, EntityManager entityManager) {
        super(type, entityManager);
    }

    public List<HotelEntity> findByNazev(String nazev) {

        try {
            return entityManager.createQuery("SELECT h FROM HotelEntity h WHERE h.nazev = :nazev", HotelEntity.class)
                    .setParameter("nazev", nazev)
                    .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public List<HotelEntity> findByHotelovyRetezecId(int hotelovyRetezecId) {

        try {
            return entityManager.createQuery("SELECT h FROM HotelEntity h WHERE h.idHotelovyRetezec = :hotelovyRetezecId", HotelEntity.class)
                    .setParameter("hotelovyRetezecId", hotelovyRetezecId)
                    .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public List<HotelEntity> findByRokZalozeni(short rokZalozeni) {
        try {
            return entityManager.createQuery("SELECT h FROM HotelEntity h WHERE h.rokZalozeni = :rokZalozeni", HotelEntity.class)
                    .setParameter("rokZalozeni", rokZalozeni)
                    .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<HotelEntity> findByOperaceId(int idOperace) {

        try {
            return entityManager.createQuery("SELECT h FROM HotelEntity h JOIN h.listOperaci o WHERE o.idOperace = :idOperace", HotelEntity.class)
                    .setParameter("idOperace", idOperace)
                    .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

}
