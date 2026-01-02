package subway.init;

import java.util.List;
import subway.domain.Line;
import subway.domain.Section;
import subway.domain.Station;
import subway.repository.LineRepository;
import subway.repository.SectionRepository;
import subway.repository.StationRepository;

public class SubwayInitializer {

    public static void initialize() {
        initStation();
        initLine();
        initSection();
    }

    public static void deleteSetting() {
        LineRepository.deleteAll();
        SectionRepository.deleteAll();
        StationRepository.deleteAll();
    }

    private static void initStation() {
        List<String> stationNames = List.of(
                "교대역", "강남역", "역삼역",
                "남부터미널역", "양재역", "양재시민의숲역", "매봉역"
        );

        for (String name : stationNames) {
            StationRepository.addStation(new Station(name));
        }
    }

    private static void initLine() {
        List<String> lineNames = List.of("2호선", "3호선", "신분당선");

        for (String name : lineNames) {
            LineRepository.addLine(new Line(name));
        }
    }

    public static void initSection() {
        addSection("2호선", "교대역", "강남역", 2, 3);
        addSection("2호선", "강남역", "역삼역", 2, 3);

        addSection("3호선", "교대역", "남부터미널역", 3, 2);
        addSection("3호선", "남부터미널역", "양재역", 6, 5);
        addSection("3호선", "양재역", "매봉역", 1, 1);

        addSection("신분당선", "강남역", "양재역", 2, 8);
        addSection("신분당선", "양재역", "양재시민의숲역", 10, 3);
    }

    private static void addSection(String lineName, String upStationName, String downStationName,
                                   int distance, int duration) {
        Line line = LineRepository.findByName(lineName);
        Station up = StationRepository.findByName(upStationName);
        Station down = StationRepository.findByName(downStationName);

        Section section = new Section(up, down, distance, duration);
        SectionRepository.addSection(section);

        line.addSection(section);
    }
}
