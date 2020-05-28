package ua.nino.model.ads;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import ua.nino.model.auto.Auto;
import ua.nino.model.user.User;

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
     */
    public Ads() {
    }

    /**
     * Constructor.
     *
     * @param aUser   a user
     * @param aAuto   a auto
     * @param aFoto   a foto
     * @param aStatus a status
     */
    public Ads(final User aUser, final Auto aAuto,
               final Set<Foto> aFoto, final String aStatus) {
        this.user = aUser;
        this.auto = aAuto;
        this.foto = aFoto;
        this.status = aStatus;
    }

    /**
     * Method to get.
     *
     * @return a id
     */
    public final int getId() {
        return this.id;
    }

    /**
     * Method to set.
     *
     * @param aId a id
     **/
    public final void setId(final int aId) {
        this.id = aId;
    }

    /**
     * Method to get.
     *
     * @return a status
     */
    public final String getStatus() {
        return this.status;
    }

    /**
     * Method to set.
     *
     * @param aStatus a status
     **/
    public final void setStatus(final String aStatus) {
        this.status = aStatus;
    }

    /**
     * Method to get.
     *
     * @return a user
     */
    public final User getUser() {
        return this.user;
    }

    /**
     * Method to set.
     *
     * @param aUser a user
     **/
    public final void setUser(final User aUser) {
        this.user = aUser;
    }

    /**
     * Method to get.
     *
     * @return a auto
     */
    public final Auto getAuto() {
        return this.auto;
    }

    /**
     * Method to set.
     *
     * @param aAuto a auto
     **/
    public final void setAuto(final Auto aAuto) {
        this.auto = aAuto;
    }

    /**
     * Method to get.
     *
     * @return foto
     */
    public final Set<Foto> getFoto() {
        return this.foto;
    }

    /**
     * Method to set.
     *
     * @param aFoto foto
     **/
    public final void setFoto(final Set<Foto> aFoto) {
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
                && Objects.equals(getAuto(), ads.getAuto());
    }

    @Override
    public final int hashCode() {
        return Objects.hash(getId(), getStatus(), getFoto());
    }

    @Override
    public final String toString() {
        return new StringJoiner(", ",
                Ads.class.getSimpleName() + "[", "]")
                .add("id=" + this.id)
                .add("status=" + this.status)
                .add("user='" + this.user + "'")
                .add("auto='" + this.auto + "'")
                .add("foto=" + this.foto)
                .toString();
    }
}
