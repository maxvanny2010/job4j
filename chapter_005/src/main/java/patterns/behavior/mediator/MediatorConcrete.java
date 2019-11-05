package patterns.behavior.mediator;

import java.util.ArrayList;
import java.util.List;

/**
 * MediatorConcrete.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 10/29/2019
 */
public class MediatorConcrete implements Mediator {
    /**
     * field list.
     */
    private final List<ColleagueAbs> list = new ArrayList<>();

    /**
     * Constructor.
     *
     * @param colleague colleague
     */
    final void addColleague(final ColleagueAbs colleague) {
        this.list.add(colleague);
    }

    @Override
    public final void requestAll(final Colleague colleague,
                                 final String request) {
        colleague.setFalse();
        colleague.setLetterNull();
        for (final Colleague coll : this.list) {
            if (coll != colleague) {
                coll.setTrue();
                coll.setLetter(request);

            }
        }
    }

    /**
     * Method to get the list.
     *
     * @return the list
     */
    public final List<ColleagueAbs> getList() {
        return this.list;
    }
}
