package cz.cvut.fel.dbs.entities;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "pozadat_zaridit", schema = "public", catalog = "tranomin")

public class PozadatZariditEntity {

    @Basic
    @Column(name = "id_operace", nullable = false)
    private int idOperace;

    @Basic
    @Column(name = "id_hotel", nullable = false)
    private int idHotel;

    @Basic
    @Column(name = "id_hotelovy_retezec", nullable = false)
    private int idHotelovyRetezec;

    public int getIdOperace() {
        return idOperace;
    }

    public void setIdOperace(int idOperace) {
        this.idOperace = idOperace;
    }

    public int getIdHotel() {
        return idHotel;
    }

    public void setIdHotel(int idHotel) {
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

        PozadatZariditEntity that = (PozadatZariditEntity) o;

        if (idOperace != that.idOperace) return false;
        if (idHotel != that.idHotel) return false;
        if (idHotelovyRetezec != that.idHotelovyRetezec) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idOperace;
        result = 31 * result + idHotel;
        result = 31 * result + idHotelovyRetezec;
        return result;
    }
}
