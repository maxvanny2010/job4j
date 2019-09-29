package parser.quartz;

import parser.config.Config;
import parser.vacancy.Vacancy;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * QuartzStore.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 9/16/2019
 */
public interface QuartzStore {
    /**
     * Method to create Vacancy.
     *
     * @param parser parser
     * @param index  index
     * @param date   date
     * @return vacancy
     */
    default Vacancy createVacancy(final ParserSql parser,
                                  final int index, final String date) {
        final var link = parser.getLink(index);
        return new Vacancy(
                date,
                parser.getName(index),
                parser.getDescription(link),
                link);
    }


    /**
     * Method check distinct name vacancy.
     *
     * @param parser parser
     * @param index  index vacancy in page
     * @return boolean result
     */
    default boolean getOnlyJava(final ParserSql parser, final int index) {
        final String query = Config.getQuery();
        final String excQuery = Config.getExcQuery();
        final String filter = new StringBuilder()
                .append("(?!")
                .append(query)
                .append(" \\W*")
                .append(excQuery)
                .append(")(")
                .append(query)
                .append(")")
                .toString();
        final Pattern pattern = Pattern.compile(filter,
                Pattern.CASE_INSENSITIVE);
        final Matcher matcher = pattern.matcher(parser.getName(index));
        return matcher.find();
    }
}
