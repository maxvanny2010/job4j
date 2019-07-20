package parser.vacancy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * VacancyList.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 9/25/2019
 */
public class VacancyList {
    /**
     * field list.
     */
    private final ArrayList<Vacancy> list = new ArrayList<>();

    /**
     * Method to reverse and to get the list.
     *
     * @return the reverse list
     */
    public final List<Vacancy> getList() {
        Collections.reverse(this.list);
        return this.list;
    }

    /**
     * Method to add vacancy at the list.
     *
     * @param vacancy vacancy
     * @return the list of vacancy
     */
    public final boolean add(final Vacancy vacancy) {
        return this.list.add(vacancy);
    }

    /**
     * Method to clear the list.
     */
    public final void clear() {
        this.list.clear();
    }

}
