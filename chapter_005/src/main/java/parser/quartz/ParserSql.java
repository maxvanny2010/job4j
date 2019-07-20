package parser.quartz;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import parser.config.Config;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Objects;
import java.util.Properties;

/**
 * ParserSql.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 7/1/2019
 */
public class ParserSql {
    /**
     * field logger.
     */
    private static final Logger LOG = LogManager
            .getLogger(ParserSql.class.getName());
    /**
     * fields the table.
     */
    private Elements table;
    /**
     * field parser's desc page.
     */
    private Document desc;

    /**
     * Method to get a base link to parse site.
     *
     * @return the link.
     */
    public final String getBaseLink() {
        final String file = Config.getParam();
        try (InputStream is = Thread.currentThread()
                .getContextClassLoader()
                .getResourceAsStream(file)) {
            Properties prop = new Properties();
            prop.load(Objects.requireNonNull(is));
            return prop.getProperty("link");
        } catch (IOException e) {
            throw new IllegalStateException("Invalid config file " + file, e);
        }
    }

    /**
     * Method to connect at a parser page.
     *
     * @param url a link to parser a page
     * @return the DOM a parser page
     */
    public final Connection.Response connPage(final String url) {
        Connection.Response response = null;
        final int out = 4000;
        final String agent = "Mozilla/5.0 (Windows NT 10.0; Win64; x64)"
                + " AppleWebKit/537.36 (KHTML, like Gecko)"
                + " Chrome/70.0.3538.77 Safari/537.36";
        try {
            response = Jsoup.connect(url)
                    .userAgent(agent)
                    .timeout(out)
                    .execute();
            final Document page = response.parse();
            this.table = page.select("table#logTable tbody tr");
        } catch (IOException e) {
            LOG.error(e.getMessage(), e);
        }
        return response;
    }

    /**
     * Method to connect to a description's link vacancy.
     *
     * @param url a url link description a vacancy
     * @return the DOM a description page
     */
    public final Connection.Response connDesc(final String url) {
        Connection.Response response = null;
        final int out = 4000;
        final String agent = "Mozilla/5.0 (Windows NT 10.0; Win64; x64)"
                + " AppleWebKit/537.36 (KHTML, like Gecko)"
                + " Chrome/70.0.3538.77 Safari/537.36";
        try {
            response = Jsoup.connect(url)
                    .userAgent(agent)
                    .timeout(out)
                    .execute();
            this.desc = response.parse();
        } catch (IOException e) {
            LOG.error(e.getMessage(), e);
        }
        return response;
    }

    /**
     * Method to get a description of vacancy.
     *
     * @param url the url of description vacancy page
     * @return the description of vacancy
     */
    public final String getDescription(final String url) {
        String result = null;
        final int sub = 20;
        final int code = 200;
        final int answer = this.connDesc(url).statusCode();
        if (answer != code) {
            result = "Connect failed, status " + answer;
        } else {
            final Elements tr = getElements();
            for (Element row : tr) {
                if (row.select("td").size() == 2) {
                    result = row.select("td")
                            .get(1)
                            .text()
                            .substring(0, sub);
                }
            }
        }
        return result;
    }

    /**
     * Method to get Elements table.
     *
     * @return elements
     */
    private Elements getElements() {
        return this.desc
                .body()
                .select("table")
                .get(1)
                .select("tbody tr");
    }

    /**
     * Method to get a link from page of vacancy.
     *
     * @param event number event vacancy in page
     * @return the link of page a vacancy
     */
    public final String getLink(final int event) {
        return this.table.get(event)
                .select("td")
                .get(0)
                .select("a")
                .attr("href");
    }

    /**
     * Method to get a name of vacancy from parser page.
     *
     * @param event number event vacancy in page
     * @return the name of vacancy
     */
    public final String getName(final int event) {
        return this.table.get(event)
                .select("td")
                .get(0)
                .select("a")
                .first()
                .text();
    }


    /**
     * Method to get a date when the vacancy to set.
     *
     * @param event number event vacancy in page
     * @return the date to set a vacancy
     */
    public final String getDate(final int event) {
        final int index = 4;
        String date = this.table.get(event)
                .select("td")
                .get(index).text();
        date = pomadeDate(date);
        if (date.contains("вчера")) {
            date = yesterday(date);
        } else if (date.contains("сегодня")) {
            date = today(date);
        }
        return date.replace("т.", "");
    }

    /**
     * Method to add "0" if line date less than 16 characters.
     *
     * @param date a date
     * @return the parse date
     */
    private String pomadeDate(final String date) {
        String checkDate = date;
        final var length = 16;
        if (date.toCharArray().length < length) {
            checkDate = "0" + date;
        }
        return checkDate;
    }

    /**
     * Method to collect the date.
     *
     * @param date a date
     * @return a parse's date
     */
    private String today(final String date) {
        final var time = date.substring(10, 15);
        final LocalDate today = LocalDate.now();
        final var ddMMMyy = today.format(DateTimeFormatter.ofPattern(
                "dd MMM yy", new Locale("ru", "RU")));
        return ddMMMyy + ", " + time;
    }

    /**
     * Method to collect the date.
     *
     * @param date a date
     * @return a parse's date
     */
    private String yesterday(final String date) {
        final var time = date.substring(8, 13);
        final LocalDate yesterday = LocalDate.now().minusDays(1);
        final var ddMMMyy = yesterday.format(DateTimeFormatter.ofPattern(
                "dd MMM yy", new Locale("ru", "RU")));
        return ddMMMyy + ", " + time;
    }
}

