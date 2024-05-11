package cz.cvut.fel.dbs.entities;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "hotel", schema = "public", catalog = "tranomin")

public class HotelEntity {

//    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    private int rokZalozeni;

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
    @JoinColumn(name = "id_hotelovy_retezec", nullable = true)
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

    public int getRokZalozeni() {
        return rokZalozeni;
    }

    public void setRokZalozeni(int rokZalozeni) {
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
        return idHotel == that.idHotel && rokZalozeni == that.rokZalozeni && Objects.equals(ico, that.ico) && Objects.equals(nazev, that.nazev) && Objects.equals(ulice, that.ulice) && Objects.equals(mesto, that.mesto) && Objects.equals(cisloPopisne, that.cisloPopisne) && Objects.equals(telefonniCislo, that.telefonniCislo) && Objects.equals(emails, that.emails) && Objects.equals(url, that.url) && Objects.equals(idNadhotel, that.idNadhotel) && Objects.equals(idHotelovyRetezec, that.idHotelovyRetezec) && Objects.equals(zamereni_hotel, that.zamereni_hotel) && Objects.equals(listOperaci, that.listOperaci);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idHotel, ico, nazev, rokZalozeni, ulice, mesto, cisloPopisne, telefonniCislo, emails, url, idNadhotel, idHotelovyRetezec, zamereni_hotel, listOperaci);
    }
}
