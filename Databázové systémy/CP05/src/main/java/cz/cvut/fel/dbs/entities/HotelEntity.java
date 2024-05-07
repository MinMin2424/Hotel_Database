package cz.cvut.fel.dbs.entities;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "hotel", schema = "public", catalog = "tranomin")
@Inheritance(strategy = InheritanceType.JOINED)

public abstract class HotelEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_hotel", nullable = false)
    private int idHotel;

    @Basic
    @Column(name = "ico", nullable = false, length = 8)
    private String ico;

    @Basic
    @Column(name = "nazev", nullable = false, length = 64)
    private String nazev;

    @Basic
    @Column(name = "rok_zalozeni", nullable = false)
    private short rokZalozeni;

    @Basic
    @Column(name = "ulice", nullable = false, length = 64)
    private String ulice;

    @Basic
    @Column(name = "mesto", nullable = false, length = 64)
    private String mesto;

    @Basic
    @Column(name = "cislo_popisne", nullable = false, length = 10)
    private String cisloPopisne;

    @Basic
    @Column(name = "telefonni_cislo", nullable = true, length = 18)
    private String telefonniCislo;

    @OneToMany(mappedBy = "idHotel")
    private Collection<EmailEntity> emails;

    @Basic
    @Column(name = "url", nullable = false, length = 255)
    private String url;

    @Basic
    @Column(name = "id_nadhotel", nullable = true)
    private Integer idNadhotel;

    @ManyToOne
    @Column(name = "id_hotelovy_retezec", nullable = true)
    private HotelovyRetezecEntity idHotelovyRetezec;

    @ManyToMany
    private Collection<ZamereniEntity> zamereni_hotel;

    @ManyToMany
    @JoinTable(name = "pozadat_zaridit",
                joinColumns = @JoinColumn(name = "id_hotel"),
                inverseJoinColumns = @JoinColumn(name = "id_operace"))
    private Collection<OperaceEntity> listOperaci;

    public int getIdHotel() {
        return idHotel;
    }

    public void setIdHotel(int idHotel) {
        this.idHotel = idHotel;
    }

    public String getIco() {
        return ico;
    }

    public void setIco(String ico) {
        this.ico = ico;
    }

    public String getNazev() {
        return nazev;
    }

    public void setNazev(String nazev) {
        this.nazev = nazev;
    }

    public short getRokZalozeni() {
        return rokZalozeni;
    }

    public void setRokZalozeni(short rokZalozeni) {
        this.rokZalozeni = rokZalozeni;
    }

    public String getUlice() {
        return ulice;
    }

    public void setUlice(String ulice) {
        this.ulice = ulice;
    }

    public String getMesto() {
        return mesto;
    }

    public void setMesto(String mesto) {
        this.mesto = mesto;
    }

    public String getCisloPopisne() {
        return cisloPopisne;
    }

    public void setCisloPopisne(String cisloPopisne) {
        this.cisloPopisne = cisloPopisne;
    }

    public String getTelefonniCislo() {
        return telefonniCislo;
    }

    public void setTelefonniCislo(String telefonniCislo) {
        this.telefonniCislo = telefonniCislo;
    }

    public Collection<EmailEntity> getEmails() {
        return emails;
    }

    public void setEmails(Collection<EmailEntity> emails) {
        this.emails = emails;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getIdNadhotel() {
        return idNadhotel;
    }

    public void setIdNadhotel(Integer idNadhotel) {
        this.idNadhotel = idNadhotel;
    }

    public HotelovyRetezecEntity getIdHotelovyRetezec() {
        return idHotelovyRetezec;
    }

    public void setIdHotelovyRetezec(HotelovyRetezecEntity idHotelovyRetezec) {
        this.idHotelovyRetezec = idHotelovyRetezec;
    }

    public Collection<ZamereniEntity> getZamereni() {
        return zamereni_hotel;
    }

    public void setZamereni(Collection<ZamereniEntity> zamereni_hotel) {
        this.zamereni_hotel = zamereni_hotel;
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

        HotelEntity that = (HotelEntity) o;

        if (idHotel != that.idHotel) return false;
        if (rokZalozeni != that.rokZalozeni) return false;
        if (ico != null ? !ico.equals(that.ico) : that.ico != null) return false;
        if (nazev != null ? !nazev.equals(that.nazev) : that.nazev != null) return false;
        if (ulice != null ? !ulice.equals(that.ulice) : that.ulice != null) return false;
        if (mesto != null ? !mesto.equals(that.mesto) : that.mesto != null) return false;
        if (cisloPopisne != null ? !cisloPopisne.equals(that.cisloPopisne) : that.cisloPopisne != null) return false;
        if (telefonniCislo != null ? !telefonniCislo.equals(that.telefonniCislo) : that.telefonniCislo != null)
            return false;
        if (url != null ? !url.equals(that.url) : that.url != null) return false;
        if (idNadhotel != null ? !idNadhotel.equals(that.idNadhotel) : that.idNadhotel != null) return false;
        if (idHotelovyRetezec != null ? !idHotelovyRetezec.equals(that.idHotelovyRetezec) : that.idHotelovyRetezec != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idHotel;
        result = 31 * result + (ico != null ? ico.hashCode() : 0);
        result = 31 * result + (nazev != null ? nazev.hashCode() : 0);
        result = 31 * result + (int) rokZalozeni;
        result = 31 * result + (ulice != null ? ulice.hashCode() : 0);
        result = 31 * result + (mesto != null ? mesto.hashCode() : 0);
        result = 31 * result + (cisloPopisne != null ? cisloPopisne.hashCode() : 0);
        result = 31 * result + (telefonniCislo != null ? telefonniCislo.hashCode() : 0);
        result = 31 * result + (url != null ? url.hashCode() : 0);
        result = 31 * result + (idNadhotel != null ? idNadhotel.hashCode() : 0);
        result = 31 * result + (idHotelovyRetezec != null ? idHotelovyRetezec.hashCode() : 0);
        return result;
    }
}
