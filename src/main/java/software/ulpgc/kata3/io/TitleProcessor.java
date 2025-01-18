package software.ulpgc.kata3.io;

import software.ulpgc.kata3.model.Title;

import java.util.List;
import java.util.Map;

public interface TitleProcessor {
    Map<String, Integer> processTitle(List<Title> titles);
}
