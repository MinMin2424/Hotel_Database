package cz.cvut.fel.dbs.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "ubytovaci_cast", schema = "public", catalog = "tranomin")

public class UbytovaciCastEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_ubytovaci_cast", nullable = false)
    private int idUbytovaciCast;

    @ManyToOne
    @PrimaryKeyJoinColumn(name = "id_hotel", referencedColumnName = "id_hotel")
    private HotelEntity idHotel;

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
        if (!super.equals(o)) return false;
        UbytovaciCastEntity that = (UbytovaciCastEntity) o;
        return idUbytovaciCast == that.idUbytovaciCast && cisloPokoju == that.cisloPokoju && Objects.equals(idHotel, that.idHotel) && Objects.equals(dostupnost, that.dostupnost) && Objects.equals(typPokoju, that.typPokoju);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), idUbytovaciCast, idHotel, cisloPokoju, dostupnost, typPokoju);
    }
}
