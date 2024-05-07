package cz.cvut.fel.dbs.entities;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "zamereni", schema = "public", catalog = "tranomin")

public class ZamereniEntity {
    @Basic
    @Column(name = "nazev", nullable = false, length = 64)
    private String nazev;

    @ManyToMany(mappedBy = "zamereni_hotel")
    @Column(name = "id_hotel", nullable = false)
    private Collection<HotelEntity> idHotel;

    @ManyToMany(mappedBy = "zamereni_hotelovyRetezec")
    @Column(name = "id_hotelovy_retezec", nullable = false)
    private Collection<HotelovyRetezecEntity> idHotelovyRetezec;


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

    public int getIdHotelovyRetezec() {
        return idHotelovyRetezec;
    }

    public void setIdHotelovyRetezec(int idHotelovyRetezec) {
        this.idHotelovyRetezec = idHotelovyRetezec;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ZamereniEntity that = (ZamereniEntity) o;

        if (idHotel != that.idHotel) return false;
        if (idHotelovyRetezec != that.idHotelovyRetezec) return false;
        if (nazev != null ? !nazev.equals(that.nazev) : that.nazev != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = nazev != null ? nazev.hashCode() : 0;
        result = 31 * result + idHotel;
        result = 31 * result + idHotelovyRetezec;
        return result;
    }
}
