package cz.cvut.fel.dbs.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "email", schema = "public", catalog = "tranomin")

public class EmailEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_email", nullable = false)
    private int idEmail;

    @Basic
    @Column(name = "adresa_email", nullable = false, length = 255)
    private String adresaEmail;

    @ManyToOne
    @JoinColumn(name = "id_hotel", nullable = false)
    private HotelEntity idHotel;

    public int getIdEmail() {
        return idEmail;
    }

    public void setIdEmail(int idEmail) {
        this.idEmail = idEmail;
    }

    public String getAdresaEmail() {
        return adresaEmail;
    }

    public void setAdresaEmail(String adresaEmail) {
        this.adresaEmail = adresaEmail;
    }

    public HotelEntity getIdHotel() {
        return idHotel;
    }

    public void setIdHotel(HotelEntity idHotel) {
        this.idHotel = idHotel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmailEntity that = (EmailEntity) o;
        return idEmail == that.idEmail && Objects.equals(adresaEmail, that.adresaEmail) && Objects.equals(idHotel, that.idHotel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idEmail, adresaEmail, idHotel);
    }
}
