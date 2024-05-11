package cz.cvut.fel.dbs.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "stravovaci_cast", schema = "public", catalog = "tranomin")

public class StravovaciCastEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_stravovaci_cast", nullable = false)
    private int idStravovaciCast;

    @ManyToOne
    @PrimaryKeyJoinColumn(name = "id_hotel", referencedColumnName = "id_hotel")
    private HotelEntity idHotel;

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
        if (!super.equals(o)) return false;
        StravovaciCastEntity that = (StravovaciCastEntity) o;
        return idStravovaciCast == that.idStravovaciCast && Objects.equals(idHotel, that.idHotel) && Objects.equals(nazev, that.nazev) && Objects.equals(typServisu, that.typServisu) && Objects.equals(typRestauraci, that.typRestauraci) && Objects.equals(kapacita, that.kapacita) && Objects.equals(oteviraciDoba, that.oteviraciDoba);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), idStravovaciCast, idHotel, nazev, typServisu, typRestauraci, kapacita, oteviraciDoba);
    }
}
