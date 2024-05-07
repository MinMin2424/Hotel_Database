package cz.cvut.fel.dbs.entities;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "hotelovy_retezec", schema = "public", catalog = "tranomin")

public class HotelovyRetezecEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_hotelovy_retezec", nullable = false)
    private int idHotelovyRetezec;

    @Basic
    @Column(name = "nazev", nullable = false, length = 64)
    private String nazev;

    @Basic
    @Column(name = "rok_zalozeni", nullable = true)
    private Short rokZalozeni;

    @OneToMany(mappedBy = "idHotelovyRetezec")
    private Collection<HotelEntity> hotels;

    @ManyToMany
    private Collection<ZamereniEntity> zamereni_hotelovyRetezec;

    @ManyToMany
    @JoinTable(name = "pozadat_zaridit",
            joinColumns = @JoinColumn(name = "id_hotelovy_retezec"),
            inverseJoinColumns = @JoinColumn(name = "id_operace"))
    private Collection<OperaceEntity> listOperaci;

    public int getIdHotelovyRetezec() {
        return idHotelovyRetezec;
    }

    public void setIdHotelovyRetezec(int idHotelovyRetezec) {
        this.idHotelovyRetezec = idHotelovyRetezec;
    }

    public String getNazev() {
        return nazev;
    }

    public void setNazev(String nazev) {
        this.nazev = nazev;
    }

    public Short getRokZalozeni() {
        return rokZalozeni;
    }

    public void setRokZalozeni(Short rokZalozeni) {
        this.rokZalozeni = rokZalozeni;
    }

    public Collection<HotelEntity> getHotels() {
        return hotels;
    }

    public void setHotels(Collection<HotelEntity> hotels) {
        this.hotels = hotels;
    }

    public Collection<ZamereniEntity> getZamereni() {
        return zamereni_hotelovyRetezec;
    }

    public void setZamereni(Collection<ZamereniEntity> zamereni_hotelovyRetezec) {
        this.zamereni_hotelovyRetezec = zamereni_hotelovyRetezec;
    }

    public Collection<OperaceEntity> getListOperaci() {
        return listOperaci;
    }

    public void setListOperaci(Collection<OperaceEntity> listOperaci) {
        this.listOperaci = listOperaci;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HotelovyRetezecEntity that = (HotelovyRetezecEntity) o;

        if (idHotelovyRetezec != that.idHotelovyRetezec) return false;
        if (nazev != null ? !nazev.equals(that.nazev) : that.nazev != null) return false;
        if (rokZalozeni != null ? !rokZalozeni.equals(that.rokZalozeni) : that.rokZalozeni != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idHotelovyRetezec;
        result = 31 * result + (nazev != null ? nazev.hashCode() : 0);
        result = 31 * result + (rokZalozeni != null ? rokZalozeni.hashCode() : 0);
        return result;
    }
}
