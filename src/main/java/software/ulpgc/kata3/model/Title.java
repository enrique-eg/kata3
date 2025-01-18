package software.ulpgc.kata3.model;

import java.util.List;

public record Title(String id, String type, String primaryTitle, String originalTitle, Boolean isAdult, int startYear, int endYear, int runtimeMinutes, List<String> genres) {
}
