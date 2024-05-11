package cz.cvut.fel.dbs.entities;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.Objects;

//@Entity
@Table(name = "hotel_hotelovyretezec", schema = "public", catalog = "tranomin")

public class HotelHotelovyretezecEntity {
    @Basic
    @Column(name = "id_hotel", nullable = true)
    private Integer idHotel;
    @Basic
    @Column(name = "nazev", nullable = true, length = 64)
    private String nazev;
    @Basic
    @Column(name = "hotelovy_retezec", nullable = true, length = 64)
    private String hotelovyRetezec;

    public Integer getIdHotel() {
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

    public String getHotelovyRetezec() {
        return hotelovyRetezec;
    }

    public void setHotelovyRetezec(String hotelovyRetezec) {
        this.hotelovyRetezec = hotelovyRetezec;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HotelHotelovyretezecEntity that = (HotelHotelovyretezecEntity) o;
        return Objects.equals(idHotel, that.idHotel) && Objects.equals(nazev, that.nazev) && Objects.equals(hotelovyRetezec, that.hotelovyRetezec);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idHotel, nazev, hotelovyRetezec);
    }
}
