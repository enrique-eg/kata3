package software.ulpgc.kata3;

import software.ulpgc.kata3.io.TitleLoader;
import software.ulpgc.kata3.io.TitleProcessor;
import software.ulpgc.kata3.io.TsvTitleLoader;
import software.ulpgc.kata3.io.YearRangeTitleProcessor;
import software.ulpgc.kata3.model.Title;

import java.io.File;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String filepath = "C:\\Users\\enriq\\IdeaProjects\\kata2\\src\\pruebas.tsv";

        TitleLoader loader = new TsvTitleLoader(new File(filepath));
        List<Title> titles = loader.loadTitles();
        TitleProcessor processor = new YearRangeTitleProcessor();
        Map<String,Integer> histogram = processor.processTitle(titles);
        HistogramVisualizer visualizer = new HistogramVisualizer();
        visualizer.displayHistogram(histogram,
                "Distribuicion de Titulos por Rango de Años",
                "Rango de Años",
                "Frecuencia");

        System.out.println("Histograma de frecuencias por rango de años");
        for (Map.Entry<String,Integer> entry : histogram.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
