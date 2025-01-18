package software.ulpgc.kata3.io;

import software.ulpgc.kata3.model.Title;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class YearRangeTitleProcessor implements TitleProcessor {
    @Override
    public Map<String, Integer> processTitle(List<Title> titles) {
        Map<String, Integer> histogram = new HashMap<>();

        for (Title title : titles) {
            int startYear = title.startYear();
            String range = getRange(startYear);
            histogram.put(range, histogram.getOrDefault(range, 0) + 1);
        }
        return histogram;
    }

    private String getRange(int year) {
        if (year < 1900) {
            return "Antes de 1900";
        } else if (year < 1950) {
            return "1900-1950";
        } else if (year < 2000) {
            return "1950-1999";
        } else {
            return "2000 en adelante";
        }
    }
}
