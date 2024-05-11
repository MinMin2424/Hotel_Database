package cz.cvut.fel.dbs;

import cz.cvut.fel.dbs.dao.HotelDAO;
import cz.cvut.fel.dbs.dao.OperaceDAO;
import cz.cvut.fel.dbs.dao.UbytovaciCastDAO;
import cz.cvut.fel.dbs.entities.HotelEntity;
import cz.cvut.fel.dbs.entities.OperaceEntity;
import cz.cvut.fel.dbs.entities.UbytovaciCastEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class Main {

    protected EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ApplicationPU");
    protected EntityManager entityManager = entityManagerFactory.createEntityManager();

    // Metoda pro provedení transakce aktualizace dostupnosti pokojů
    public void performTransaction() {

        UbytovaciCastDAO ubytovaciCastDAO = new UbytovaciCastDAO(UbytovaciCastEntity.class, entityManager);

        try {
            // Začátek transakce
            ubytovaciCastDAO.beginTransaction();

            UbytovaciCastEntity room100 = ubytovaciCastDAO.findByCisloPokoju(100);
            UbytovaciCastEntity room102 = ubytovaciCastDAO.findByCisloPokoju(102);

            System.out.println("BEFORE UPDATE: ");
            System.out.println("Číslo pokoje: " + room100.getCisloPokoju() + " Dostupnost: " + room100.getDostupnost());
            System.out.println("Číslo pokoje: " + room102.getCisloPokoju() + " Dostupnost: " + room102.getDostupnost());

            // UPDATE ubytovaci_cast SET dostupnost = TRUE WHERE cislo_pokoju = 100;
            room100.setDostupnost(false);
            ubytovaciCastDAO.update(room100);

            // UPDATE ubytovaci_cast SET dostupnost = TRUE WHERE cislo_pokoju = 102;
            room102.setDostupnost(false);
            ubytovaciCastDAO.update(room102);

            // Commit transakce
            ubytovaciCastDAO.commitTransaction();

            System.out.println("AFTER UPDATE: ");
            System.out.println("Číslo pokoje: " + room100.getCisloPokoju() + " Dostupnost: " + room100.getDostupnost());
            System.out.println("Číslo pokoje: " + room102.getCisloPokoju() + " Dostupnost: " + room102.getDostupnost());

        } catch (Exception e) {
            System.err.println("Došlo k chybě: " + e.getMessage());
        }

    }

    // Metoda pro přidání nový hotel do databáze
    public void addNewHotel() {

        HotelDAO hotelDAO = new HotelDAO(HotelEntity.class, entityManager);

        try {

            int idNewHotel = 221;
            hotelDAO.addHotel(
                    idNewHotel,
                    "00000221",
                    "Top Hotel Praha & Congress Centre",
                    2000,
                    "Blažímská 1781/4",
                    "Praha",
                    "149 00",
                    "267 284 111",
                    "https://www.tophotel.cz/cs/");

            isHotelAdded(idNewHotel);

        } catch (Exception e) {
            System.err.println("Došlo k chybě: " + e.getMessage());
        }

    }

    // Metoda pro zkontrolování, zda byl hotel úspěšně přidán do databáze
    private void isHotelAdded(int idNewHotel) {

        HotelDAO hotelDAO = new HotelDAO(HotelEntity.class, entityManager);

        try {
          HotelEntity hotel = hotelDAO.findById(idNewHotel);

          if (hotel != null) {
              System.out.println("Informace o hotelu s ID " + idNewHotel + ":");
              System.out.println("IČO: " + hotel.getIco());
              System.out.println("Název: " + hotel.getNazev());
              System.out.println("Rok založení: " + hotel.getRokZalozeni());
              System.out.println("Adresa: " + hotel.getUlice() + ", " + hotel.getMesto() + ", " + hotel.getCisloPopisne());
              System.out.println("Telefonní číslo: " + hotel.getTelefonniCislo());
              System.out.println("URL: " + hotel.getUrl());
          } else {
              System.out.println("Hotel s ID " + idNewHotel + " nebyl nalezen.");
          }

        } catch (Exception e) {
            System.err.println("Došlo k chybě: " + e.getMessage());
        }
    }

    // Metoda pro odstranění hotel z databáze.
    public void removeHotel() {

        HotelDAO hotelDAO = new HotelDAO(HotelEntity.class, entityManager);

        try {
            int idHotelToRemove = 221;
            hotelDAO.removeHotel(idHotelToRemove);
            isHotelRemoved(idHotelToRemove);

        } catch (Exception e) {
            System.err.println("Došlo k chybě: " + e.getMessage());
        }
    }

    // Metoda pro zkontrolování, zda byl hotel úspěšně odstraněn z databáze.
    private void isHotelRemoved(int idHotelToRemove) {

        HotelDAO hotelDAO = new HotelDAO(HotelEntity.class, entityManager);

        try {
            HotelEntity hotel = hotelDAO.findById(idHotelToRemove);

            if (hotel == null) {
                System.out.println("Hotel s ID " + idHotelToRemove + " byl úspěšně odstraněn.");
            } else {
                System.out.println("Hotel s ID " + idHotelToRemove + " nebyl odstraněn.");
            }

        } catch (Exception e) {
            System.err.println("Došlo k chybě: " + e.getMessage());
        }

    }

    // Metoda pro získání seznamu ubytovacích částí podle id hotelu.
    public void getUbytovaciCastByIdHotel() {

        UbytovaciCastDAO ubytovaciCastDAO = new UbytovaciCastDAO(UbytovaciCastEntity.class, entityManager);
        HotelDAO hotelDAO = new HotelDAO(HotelEntity.class, entityManager);

        try {
            HotelEntity hotel = hotelDAO.findById(6);
            List<UbytovaciCastEntity> listUbytovaciCast = ubytovaciCastDAO.getByIdHotel(hotel);

            for (UbytovaciCastEntity ubytovaciCast : listUbytovaciCast) {
                System.out.println("Číslo pokoje: " + ubytovaciCast.getCisloPokoju() + " Typ pokoje: " + ubytovaciCast.getTypPokoju());
            }
        } catch (Exception e) {
            System.err.println("Došlo k chybě: " + e.getMessage());
        }

    }

    // Metoda pro získání počtu hotelů, které požádaly o operaci s určitým id
    public void getHotelsByIdOperace() {

        HotelDAO hotelDAO = new HotelDAO(HotelEntity.class, entityManager);
        OperaceDAO operaceDAO = new OperaceDAO(OperaceEntity.class, entityManager);

        try {
            List<HotelEntity> listHotels = hotelDAO.getHotelsByIdOperation(2);

            System.out.println("Počet hotelů, které požádaly o operaci s id 2 (" + operaceDAO.findById(2).getTyp() + "): ");
            System.out.println(listHotels.size());

        } catch (Exception e) {
            System.err.println("Došlo k chybě: " + e.getMessage());
        }
    }



    public static void main(String[] args) {
        Main main = new Main();
        main.performTransaction();
        main.addNewHotel();
        main.removeHotel();
        main.getUbytovaciCastByIdHotel();
        main.getHotelsByIdOperace();
    }
}
