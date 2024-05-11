package cz.cvut.fel.dbs.entities;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "zamereni", schema = "public", catalog = "tranomin")

public class ZamereniEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_zamereni", nullable = false)
    private int idZamereni;

    @Basic
    @Column(name = "nazev", nullable = false, length = 64)
    private String nazev;

    @ManyToMany(mappedBy = "zamereni_hotel")
    @JoinColumn(name = "id_hotel", nullable = false)
    private Collection<HotelEntity> idHotel;

    @ManyToMany(mappedBy = "zamereni_hotelovyRetezec")
    @JoinColumn(name = "id_hotelovy_retezec", nullable = false)
    private Collection<HotelovyRetezecEntity> idHotelovyRetezec;

    public int getIdZamereni() {
        return idZamereni;
    }

    public void setIdZamereni(int idZamereni) {
        this.idZamereni = idZamereni;
    }

    public String getNazev() {
        return nazev;
    }

    public void setNazev(String nazev) {
        this.nazev = nazev;
    }

    public Collection<HotelEntity> getIdHotel() {
        return idHotel;
    }

    public void setIdHotel(Collection<HotelEntity> idHotel) {
        this.idHotel = idHotel;
    }


    public Collection<HotelovyRetezecEntity> getIdHotelovyRetezec() {
        return idHotelovyRetezec;
    }

    public void setIdHotelovyRetezec(Collection<HotelovyRetezecEntity> idHotelovyRetezec) {
        this.idHotelovyRetezec = idHotelovyRetezec;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ZamereniEntity that = (ZamereniEntity) o;
        return idZamereni == that.idZamereni && Objects.equals(nazev, that.nazev) && Objects.equals(idHotel, that.idHotel) && Objects.equals(idHotelovyRetezec, that.idHotelovyRetezec);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idZamereni, nazev, idHotel, idHotelovyRetezec);
    }

}
