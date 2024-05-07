package cz.cvut.fel.dbs.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "ubytovaci_cast", schema = "public", catalog = "tranomin")

public class UbytovaciCastEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_ubytovaci_cast", nullable = false)
    private int idUbytovaciCast;

    @Basic
    @Column(name = "id_hotel", nullable = true)
    private Integer idHotel;

    @Basic
    @Column(name = "cislo_pokoju", nullable = false)
    private int cisloPokoju;

    @Basic
    @Column(name = "dostupnost", nullable = true)
    private Boolean dostupnost;

    @Basic
    @Column(name = "typ_pokoju", nullable = true, length = 64)
    private String typPokoju;

    public int getIdUbytovaciCast() {
        return idUbytovaciCast;
    }

    public void setIdUbytovaciCast(int idUbytovaciCast) {
        this.idUbytovaciCast = idUbytovaciCast;
    }

    public Integer getIdHotel() {
        return idHotel;
    }

    public void setIdHotel(Integer idHotel) {
        this.idHotel = idHotel;
    }

    public int getCisloPokoju() {
        return cisloPokoju;
    }

    public void setCisloPokoju(int cisloPokoju) {
        this.cisloPokoju = cisloPokoju;
    }

    public Boolean getDostupnost() {
        return dostupnost;
    }

    public void setDostupnost(Boolean dostupnost) {
        this.dostupnost = dostupnost;
    }

    public String getTypPokoju() {
        return typPokoju;
    }

    public void setTypPokoju(String typPokoju) {
        this.typPokoju = typPokoju;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UbytovaciCastEntity that = (UbytovaciCastEntity) o;

        if (idUbytovaciCast != that.idUbytovaciCast) return false;
        if (cisloPokoju != that.cisloPokoju) return false;
        if (idHotel != null ? !idHotel.equals(that.idHotel) : that.idHotel != null) return false;
        if (dostupnost != null ? !dostupnost.equals(that.dostupnost) : that.dostupnost != null) return false;
        if (typPokoju != null ? !typPokoju.equals(that.typPokoju) : that.typPokoju != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idUbytovaciCast;
        result = 31 * result + (idHotel != null ? idHotel.hashCode() : 0);
        result = 31 * result + cisloPokoju;
        result = 31 * result + (dostupnost != null ? dostupnost.hashCode() : 0);
        result = 31 * result + (typPokoju != null ? typPokoju.hashCode() : 0);
        return result;
    }
}
