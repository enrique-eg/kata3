package software.ulpgc.kata3.io;

import software.ulpgc.kata3.model.Title;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TsvTitleLoader implements TitleLoader {

    private final File file;

    public TsvTitleLoader(File file) {
        this.file = file;
    }

    @Override
    public List<Title> loadTitles() {
        List<Title> titles = new ArrayList<Title>();

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line = br.readLine();

            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\t");

                String id = parts[0];
                String type = parts[1];
                String primaryTitle = parts[2];
                String originalTitle = parts[3];
                Boolean isAdult = parts[4].equals("1");
                int startYear = parseIntOrDefault(parts[5], 0);
                int endYear = parseIntOrDefault(parts[6], 0);
                int runtimeMinutes = parseIntOrDefault(parts[7], 0);
                List<String> genres = parts[8].equals("\\N") ? List.of() : List.of(parts[8].split(","));

                titles.add(new Title(id,type,primaryTitle,originalTitle,isAdult,startYear,endYear,runtimeMinutes,genres));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return titles;
    }

    private int parseIntOrDefault(String part, int i) {
        try {
            return Integer.parseInt(part);
        } catch (NumberFormatException e) {
            return i;
        }
    }
}
