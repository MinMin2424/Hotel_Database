package cz.cvut.fel.dbs.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "pozadat_zaridit", schema = "public", catalog = "tranomin")

public class PozadatZariditEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_vyresena_operace", nullable = false)
    private int idVyresenaOperace;

    @Basic
    @Column(name = "id_operace", nullable = false)
    private int idOperace;

    @Basic
    @Column(name = "id_hotel", nullable = false)
    private int idHotel;

    @Basic
    @Column(name = "id_hotelovy_retezec", nullable = false)
    private int idHotelovyRetezec;

    public int getIdVyresenaOperace() {
        return idVyresenaOperace;
    }

    public void setIdVyresenaOperace(int idVyresenaOperace) {
        this.idVyresenaOperace = idVyresenaOperace;
    }

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
        return idVyresenaOperace == that.idVyresenaOperace && idOperace == that.idOperace && idHotel == that.idHotel && idHotelovyRetezec == that.idHotelovyRetezec;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idVyresenaOperace, idOperace, idHotel, idHotelovyRetezec);
    }
}
