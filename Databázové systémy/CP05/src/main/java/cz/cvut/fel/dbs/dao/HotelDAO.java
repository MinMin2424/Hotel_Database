package cz.cvut.fel.dbs.dao;

import cz.cvut.fel.dbs.entities.HotelEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class HotelDAO extends BaseDAO<HotelEntity> {

    protected HotelDAO(Class<HotelEntity> type) {
        super(type);
    }

    public HotelDAO(Class<HotelEntity> type, EntityManager entityManager) {
        super(type, entityManager);
    }

    public List<HotelEntity> findByNazev(String nazev) {
        try {
            return entityManager.createQuery(
                    "SELECT h FROM HotelEntity h " +
                            "WHERE h.nazev = :nazev",
                            HotelEntity.class)
                    .setParameter("nazev", nazev)
                    .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<HotelEntity> findByHotelovyRetezecId(int hotelovyRetezecId) {
        try {
            return entityManager.createQuery(
                    "SELECT h FROM HotelEntity h " +
                            "WHERE h.idHotelovyRetezec = :hotelovyRetezecId",
                            HotelEntity.class)
                    .setParameter("hotelovyRetezecId", hotelovyRetezecId)
                    .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<HotelEntity> findByRokZalozeni(short rokZalozeni) {
        try {
            return entityManager.createQuery(
                    "SELECT h FROM HotelEntity h " +
                            "WHERE h.rokZalozeni = :rokZalozeni",
                            HotelEntity.class)
                    .setParameter("rokZalozeni", rokZalozeni)
                    .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<HotelEntity> findByOperaceId(int idOperace) {
        try {
            return entityManager.createQuery(
                    "SELECT h FROM HotelEntity h " +
                            "JOIN h.listOperaci o " +
                            "WHERE o.idOperace = :idOperace",
                            HotelEntity.class)
                    .setParameter("idOperace", idOperace)
                    .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<HotelEntity> getHotelsByIdOperation (int idOperace) {
        try {
            return entityManager.createQuery(
                    "SELECT h FROM HotelEntity h " +
                            "JOIN h.listOperaci o " +
                            "WHERE o.idOperace = :idOperace",
                            HotelEntity.class)
                    .setParameter("idOperace", idOperace)
                    .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void addHotel(int idHotel, String ico, String nazev, int rokZalozeni, String ulice, String mesto, String cisloPopisne, String telefonniCislo, String url) {
        try {
            beginTransaction();

            HotelEntity hotel = new HotelEntity();

            hotel.setIdHotel(idHotel);
            hotel.setIco(ico);
            hotel.setNazev(nazev);
            hotel.setRokZalozeni(rokZalozeni);
            hotel.setUlice(ulice);
            hotel.setMesto(mesto);
            hotel.setCisloPopisne(cisloPopisne);
            hotel.setTelefonniCislo(telefonniCislo);
            hotel.setUrl(url);

            insert(hotel);
            commitTransaction();
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                rollbackTransaction();
            }
            e.printStackTrace();
        }
    }

    public void removeHotel(int idHotel) {
        try {
            beginTransaction();
            delete(idHotel);
            commitTransaction();
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                rollbackTransaction();
            }
            e.printStackTrace();
        }
    }

}
