package patterns.behavior.mediator;

/**
 * ColleagueConcrete.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 10/29/2019
 */
class ColleagueConcrete extends ColleagueAbs {

    /**
     * Constructor.
     *
     * @param aMediator mediator
     * @param aName     name
     */
    ColleagueConcrete(final Mediator aMediator, final String aName) {
        super(aMediator, aName);
    }

}
