package parser;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * SetVacancies.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 9/12/2019
 */
public class SetVacancies {
        /**
         * field Set.
         */
        private static final Set<Vacancy> SET = new LinkedHashSet<>();
        /**
         * Getter a Set.
         *
         * @return the Set
         */
        public final Set<Vacancy> getSet() {
            return SET;
        }
}
