package ua.nino.model.ads;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Objects;
import java.util.StringJoiner;

/**
 * Foto.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 4/18/2020
 */
@Entity
@Table(name = "foto")
public class Foto {
    /**
     * field a id.
     */
    private int id;
    /**
     * field a foto.
     */
    private String values;
    /**
     * field a ads.
     */
    @JsonIgnore
    private Ads ads;

    /**
     * Constructor.
     *
     * @param aFoto a foto
     */
    public Foto(final String aFoto) {
        this.values = aFoto;
    }

    /**
     * Constructor.
     */
    public Foto() {
    }

    /**
     * Method to get.
     *
     * @return a id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_foto")
    public int getId() {
        return this.id;
    }

    /**
     * Method to set.
     *
     * @param aId a id
     **/
    public void setId(final int aId) {
        this.id = aId;
    }

    /**
     * Method to get.
     *
     * @return foto
     */
    @Column(name = "values")
    public String getValues() {
        return this.values;
    }

    /**
     * Method to set.
     *
     * @param aFoto foto
     **/
    public void setValues(final String aFoto) {
        this.values = aFoto;
    }

    /**
     * Method to get.
     *
     * @return a ads
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ads_id", foreignKey = @ForeignKey(name = "ads_id_fk"))
    public Ads getAds() {
        return this.ads;
    }

    /**
     * Method to set.
     *
     * @param aAds a ads
     **/
    public void setAds(final Ads aAds) {
        this.ads = aAds;
    }

    @Override
    public final boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Foto)) {
            return false;
        }
        final Foto foto1 = (Foto) o;
        return getId() == foto1.getId()
                && Objects.equals(getValues(), foto1.getValues());
    }

    @Override
    public final int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public final String toString() {
        return new StringJoiner(", ",
                Foto.class.getSimpleName() + "[", "]")
                .add("id=" + this.id)
                .add("ads=" + this.ads)
                .toString();
    }
}
