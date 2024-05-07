package cz.cvut.fel.dbs.entities;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "operace", schema = "public", catalog = "tranomin")

public class OperaceEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_operace", nullable = false)
    private int idOperace;

    @Basic
    @Column(name = "typ", nullable = true, length = 64)
    private String typ;

    @OneToMany(mappedBy = "idOperace")
    private Collection<PozadatZariditEntity> listOperaci;

    public int getIdOperace() {
        return idOperace;
    }

    public void setIdOperace(int idOperace) {
        this.idOperace = idOperace;
    }

    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }

    public Collection<PozadatZariditEntity> getListOperaci() {
        return listOperaci;
    }

    public void setListOperaci(Collection<PozadatZariditEntity> listOperaci) {
        this.listOperaci = listOperaci;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OperaceEntity that = (OperaceEntity) o;

        if (idOperace != that.idOperace) return false;
        if (typ != null ? !typ.equals(that.typ) : that.typ != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idOperace;
        result = 31 * result + (typ != null ? typ.hashCode() : 0);
        return result;
    }
}
