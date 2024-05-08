package cz.cvut.fel.dbs.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "stravovaci_cast", schema = "public", catalog = "tranomin")

public class StravovaciCastEntity extends HotelEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_stravovaci_cast", nullable = false)
    private int idStravovaciCast;

    @Basic
    @Column(name = "id_hotel", nullable = true)
    private Integer idHotel;

    @Basic
    @Column(name = "nazev", nullable = false, length = 64)
    private String nazev;

    @Basic
    @Column(name = "typ_servisu", nullable = true, length = 64)
    private String typServisu;

    @Basic
    @Column(name = "typ_restauraci", nullable = true, length = 64)
    private String typRestauraci;

    @Basic
    @Column(name = "kapacita", nullable = true, length = 18)
    private String kapacita;

    @Basic
    @Column(name = "oteviraci_doba", nullable = true, length = 64)
    private String oteviraciDoba;

    public int getIdStravovaciCast() {
        return idStravovaciCast;
    }

    public void setIdStravovaciCast(int idStravovaciCast) {
        this.idStravovaciCast = idStravovaciCast;
    }

    public int getIdHotel() {
        return idHotel;
    }

    public void setIdHotel(Integer idHotel) {
        this.idHotel = idHotel;
    }

    public String getNazev() {
        return nazev;
    }

    public void setNazev(String nazev) {
        this.nazev = nazev;
    }

    public String getTypServisu() {
        return typServisu;
    }

    public void setTypServisu(String typServisu) {
        this.typServisu = typServisu;
    }

    public String getTypRestauraci() {
        return typRestauraci;
    }

    public void setTypRestauraci(String typRestauraci) {
        this.typRestauraci = typRestauraci;
    }

    public String getKapacita() {
        return kapacita;
    }

    public void setKapacita(String kapacita) {
        this.kapacita = kapacita;
    }

    public String getOteviraciDoba() {
        return oteviraciDoba;
    }

    public void setOteviraciDoba(String oteviraciDoba) {
        this.oteviraciDoba = oteviraciDoba;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StravovaciCastEntity that = (StravovaciCastEntity) o;

        if (idStravovaciCast != that.idStravovaciCast) return false;
        if (idHotel != null ? !idHotel.equals(that.idHotel) : that.idHotel != null) return false;
        if (nazev != null ? !nazev.equals(that.nazev) : that.nazev != null) return false;
        if (typServisu != null ? !typServisu.equals(that.typServisu) : that.typServisu != null) return false;
        if (typRestauraci != null ? !typRestauraci.equals(that.typRestauraci) : that.typRestauraci != null)
            return false;
        if (kapacita != null ? !kapacita.equals(that.kapacita) : that.kapacita != null) return false;
        if (oteviraciDoba != null ? !oteviraciDoba.equals(that.oteviraciDoba) : that.oteviraciDoba != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idStravovaciCast;
        result = 31 * result + (idHotel != null ? idHotel.hashCode() : 0);
        result = 31 * result + (nazev != null ? nazev.hashCode() : 0);
        result = 31 * result + (typServisu != null ? typServisu.hashCode() : 0);
        result = 31 * result + (typRestauraci != null ? typRestauraci.hashCode() : 0);
        result = 31 * result + (kapacita != null ? kapacita.hashCode() : 0);
        result = 31 * result + (oteviraciDoba != null ? oteviraciDoba.hashCode() : 0);
        return result;
    }
}
