package cz.cvut.fel.dbs.entities;

import jakarta.persistence.*;

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

        if (idEmail != that.idEmail) return false;
        if (adresaEmail != null ? !adresaEmail.equals(that.adresaEmail) : that.adresaEmail != null) return false;
        if (idHotel != null ? !idHotel.equals(that.idHotel) : that.idHotel != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idEmail;
        result = 31 * result + (adresaEmail != null ? adresaEmail.hashCode() : 0);
        result = 31 * result + (idHotel != null ? idHotel.hashCode() : 0);
        return result;
    }
}
