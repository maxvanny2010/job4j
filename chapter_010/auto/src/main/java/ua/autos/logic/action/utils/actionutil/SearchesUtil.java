package ua.autos.logic.action.utils.actionutil;

import java.util.HashMap;
import java.util.Map;

/**
 * SearchesUtil.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 5/21/2020
 */
public final class SearchesUtil {
    /**
     * field a brands.
     */
    private static final Map<String, String> BRANDS = new HashMap<>() {{
        put("1", "bmw");
        put("2", "mercedes");
        put("3", "toyota");
        put("4", "lexus");
    }};
    /**
     * field a models.
     */
    private static final Map<String, String> BMW = new HashMap<>() {{
        put("1", "3");
        put("2", "5");
        put("3", "7");
    }};
    /**
     * field a models.
     */
    private static final Map<String, String> MERCEDES = new HashMap<>() {{
        put("4", "C");
        put("5", "S");
        put("6", "G");
    }};
    /**
     * field a models.
     */
    private static final Map<String, String> TOYOTA = new HashMap<>() {{
        put("7", "Prado");
        put("8", "Corolla");
        put("9", "Camry");
    }};
    /**
     * field a models.
     */
    private static final Map<String, String> LEXUS = new HashMap<>() {{
        put("10", "RX");
        put("11", "LX");
        put("12", "ES");
    }};
    /**
     * field a models.
     */
    private static final Map<String,
            Map<String, String>> MODELS = new HashMap<>() {{
        put("bmw", BMW);
        put("mercedes", MERCEDES);
        put("toyota", TOYOTA);
        put("lexus", LEXUS);
    }};
    /**
     * field a engine.
     */
    private static final Map<String, String> ENGINES = new HashMap<>() {{
        put("1", "бензин");
        put("2", "дизель");
        put("3", "электро");
        put("4", "газ");
    }};
    /**
     * field a years.
     */
    private static final Map<String, String> YEARS = new HashMap<>() {{
        put("1", "2020");
        put("2", "2019");
        put("3", "2018");
    }};
    /**
     * field a colors.
     */
    private static final Map<String, String> COLORS = new HashMap<>() {{
        put("1", "чёрный");
        put("2", "синий");
        put("3", "белый");
        put("4", "зелёный");
        put("5", "серый");
    }};

    /**
     * Constructor.
     */
    private SearchesUtil() {
    }

    /**
     * Method to get.
     *
     * @param aBrand a brand
     * @return brand or is not null
     */
    public static String getBrand(final String aBrand) {
        return BRANDS.getOrDefault(aBrand, "");
    }

    /**
     * Method to get.
     *
     * @param aBrand a brand
     * @param aModel a model
     * @return brand or is not null
     */
    public static String getModel(final String aBrand,
                                  final String aModel) {
        return MODELS.get(aBrand).getOrDefault(aModel, "");
    }

    /**
     * Method to get.
     *
     * @param aEngine a engine
     * @return brand or is not null
     */
    public static String getEngine(final String aEngine) {
        return ENGINES.getOrDefault(aEngine, "");
    }

    /**
     * Method to get.
     *
     * @param aYear a year
     * @return brand or is not null
     */
    public static String getYear(final String aYear) {
        return YEARS.getOrDefault(aYear, "");
    }

    /**
     * Method to get.
     *
     * @param aColor a color
     * @return brand or is not null
     */
    public static String getColor(final String aColor) {
        return COLORS.getOrDefault(aColor, "");
    }
}
