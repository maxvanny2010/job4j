package ua.nino.model.ads;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;
import ua.nino.model.auto.Auto;
import ua.nino.model.user.User;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.StringJoiner;

/**
 * Ads.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 4/18/2020
 */
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "ads")
public class Ads {
    /**
     * field a id.
     */
    private int id;
    /**
     * field a status.
     */
    private String status;

    /**
     * field a time.
     */
    private LocalDate times;

    /**
     * field a user.
     */
    @JsonIgnore
    private User user;
    /**
     * field a user.
     */
    private Auto auto;
    /**
     * field foto.
     */
    private Set<Foto> foto = new HashSet<>();

    /**
     * Constructor.
     *
     * @param aUser   a user
     * @param aAuto   a auto
     * @param aFoto   a foto
     * @param aStatus a status
     * @param aDate   a date
     */
    public Ads(final User aUser, final Auto aAuto,
               final Set<Foto> aFoto, final String aStatus,
               final LocalDate aDate) {
        this.user = aUser;
        this.auto = aAuto;
        this.foto = aFoto;
        this.status = aStatus;
        this.times = aDate;
    }

    /**
     * Constructor.
     */
    public Ads() {
    }

    /**
     * Method to get.
     *
     * @return a local date and time
     */
    @NotNull
    @Column(name = "times")
    public LocalDate getTimes() {
        return this.times;
    }

    /**
     * Method to set.
     *
     * @param aDate a date
     **/
    public void setTimes(final LocalDate aDate) {
        this.times = aDate;
    }

    /**
     * Method to get.
     *
     * @return a id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ads")
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
     * @return a status
     */
    @Column(name = "status")
    public String getStatus() {
        return this.status;
    }

    /**
     * Method to set.
     *
     * @param aStatus a status
     **/
    public void setStatus(final String aStatus) {
        this.status = aStatus;
    }

    /**
     * Method to get.
     *
     * @return a user
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id",
            foreignKey = @ForeignKey(name = "user_id_fk"),
            nullable = false)
    public User getUser() {
        return this.user;
    }

    /**
     * Method to set.
     *
     * @param aUser a user
     **/
    public void setUser(final User aUser) {
        this.user = aUser;
    }

    /**
     * Method to get.
     *
     * @return a auto
     */
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "auto_id",
            foreignKey = @ForeignKey(name = "auto_id_fk"),
            nullable = false, unique = true)
    public Auto getAuto() {
        return this.auto;
    }

    /**
     * Method to set.
     *
     * @param aAuto a auto
     **/
    public void setAuto(final Auto aAuto) {
        this.auto = aAuto;
    }

    /**
     * Method to get.
     *
     * @return foto
     */
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL,
            mappedBy = "ads")
    public Set<Foto> getFoto() {
        return this.foto;
    }

    /**
     * Method to set.
     *
     * @param aFoto foto
     **/
    public void setFoto(final Set<Foto> aFoto) {
        this.foto = aFoto;
    }

    @Override
    public final boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Ads)) {
            return false;
        }
        final Ads ads = (Ads) o;
        return getId() == ads.getId()
                && getStatus().equals(ads.getStatus())
                && Objects.equals(getUser(), ads.getUser())
                && Objects.equals(getAuto(), ads.getAuto())
                && Objects.equals(getTimes(), ads.getTimes());
    }

    @Override
    public final int hashCode() {
        return Objects.hash(getId(), getStatus(), getFoto(), getTimes());
    }

    @Override
    public final String toString() {
        return new StringJoiner(", ",
                Ads.class.getSimpleName() + "[", "]")
                .add("id=" + this.id)
                .add("time=" + this.times)
                .add("status=" + this.status)
                .add("user='" + this.user + "'")
                .add("auto='" + this.auto + "'")
                .add("foto=" + this.foto)
                .toString();
    }
}
