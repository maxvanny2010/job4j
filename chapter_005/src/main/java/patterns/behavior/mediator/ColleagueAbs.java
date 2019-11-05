package patterns.behavior.mediator;

/**
 * ColleagueAbs.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 10/29/2019
 */
public abstract class ColleagueAbs implements Colleague {
    /**
     * field mediator.
     */
    private final Mediator mediator;
    /**
     * field name.
     */
    private final String name;
    /**
     * field status.
     */
    private boolean status;
    /**
     * field letter.
     */
    private String letter;

    /**
     * Constructor.
     *
     * @param aMediator mediator
     * @param aName     name
     */

    ColleagueAbs(final Mediator aMediator, final String aName) {
        this.mediator = aMediator;
        this.name = aName;
    }


    @Override
    public final String getName() {
        return this.name;
    }

    @Override
    public final boolean isStatus() {
        return this.status;
    }

    @Override
    public final void setFalse() {
        this.status = false;
    }

    @Override
    public final void setTrue() {
        this.status = true;
    }

    @Override
    public final String getLetter() {
        return this.letter;
    }

    @Override
    public final void setLetter(final String aLetter) {
        this.letter = aLetter;
    }

    @Override
    public final void setLetterNull() {
        this.letter = null;
    }

    @Override
    public final void sentRequest(final String request) {
        this.mediator.requestAll(this, request);
    }
}
