package subway.service;

import java.util.List;
import org.jgrapht.Graph;
import org.jgrapht.GraphPath;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import subway.constant.ErrorMessage;
import subway.domain.Section;
import subway.domain.Station;
import subway.dto.PathResult;
import subway.repository.StationRepository;

public class PathService {

    private final GraphFactory graphFactory;

    public PathService(GraphFactory graphFactory) {
        this.graphFactory = graphFactory;
    }

    public PathResult findShortestDistance(String pathType, String startName, String endName) {
        validateSameStation(startName, endName);

        Station start = StationRepository.findByName(startName);
        Station end = StationRepository.findByName(endName);

        validateStation(start, end);

        Graph<Station, Section> graph = graphFactory.createGraph(pathType);

        return calculateResult(findShortestPath(graph, start, end));
    }

    private void validateSameStation(String startName, String endName) {
        if (startName.equals(endName)) {
            throw new IllegalArgumentException(ErrorMessage.SAME_STATION.getMessage());
        }
    }

    private void validateStation(Station start, Station end) {
        if (start == null) {
            throw new IllegalArgumentException(ErrorMessage.NOT_FOUND_START.getMessage());
        }
        if (end == null) {
            throw new IllegalArgumentException(ErrorMessage.NOT_FOUND_END.getMessage());
        }
    }

    private GraphPath<Station, Section> findShortestPath(Graph<Station, Section> graph,
                                                         Station start, Station end) {
        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(graph);
        GraphPath<Station, Section> path = dijkstraShortestPath.getPath(start, end);

        validateConnect(path);

        return path;
    }

    private void validateConnect(GraphPath<Station, Section> path) {
        if (path == null) {
            throw new IllegalArgumentException(ErrorMessage.NOT_CONNECTED.getMessage());
        }
    }

    private PathResult calculateResult(GraphPath<Station, Section> path) {
        List<String> stationNames = path.getVertexList().stream()
                .map(Station::getName)
                .toList();

        int totalDistance = path.getEdgeList().stream()
                .mapToInt(Section::getDistance)
                .sum();

        int totalTime = path.getEdgeList().stream()
                .mapToInt(Section::getTime)
                .sum();

        return new PathResult(stationNames, totalDistance, totalTime);
    }
}
