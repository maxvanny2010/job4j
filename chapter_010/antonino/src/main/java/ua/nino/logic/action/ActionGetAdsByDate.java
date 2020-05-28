package ua.nino.logic.action;

import ua.nino.model.ads.Ads;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import static ua.nino.logic.action.utils.actionutil.ActionUtil.setOut;

/**
 * ActionFilterDate.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 5/30/2020
 */
public class ActionGetAdsByDate extends ActionAbs {

    @SuppressWarnings("unused")
    @Override
    public final void execute(final HashMap<String, String> json,
                              final HttpServletRequest req,
                              final HttpServletResponse resp)
            throws IOException {
        req.setCharacterEncoding("UTF-8");
        final String start = json.get("start");
        final String end = json.get("end");
        final Map<String, Object> answer = new HashMap<>();
        final boolean isStart = Objects.equals("", start);
        final boolean isEnd = Objects.equals("", end);
        if (isStart || isEnd) {
            answer.put("list", new ArrayList<Ads>());
        } else {
            final List<Ads> dateFilter = getUser().getDateFilter(start, end);
            final List<Ads> allAds = getAdmin().findAllAds();
            final LocalDate starts = LocalDate.parse(start).minusDays(1);
            final LocalDate ends = LocalDate.parse(end).plusDays(1);
            //unused
            final List<Ads> list = allAds.stream()
                    .filter(ads -> ads.getTimes().isAfter(starts)
                            && ads.getTimes().isBefore(ends))
                    .collect(Collectors.toList());
            answer.put("list", dateFilter);
        }
        setOut(resp, answer);
    }
}
