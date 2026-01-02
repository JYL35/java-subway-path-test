package subway.service;

import org.jgrapht.Graph;
import org.jgrapht.graph.WeightedMultigraph;
import subway.domain.Section;
import subway.domain.Station;
import subway.repository.SectionRepository;
import subway.repository.StationRepository;

public class GraphFactory {
    private static final String DISTANCE_TYPE = "1";

    public Graph<Station, Section> createGraph(String pathType) {
        Graph<Station, Section> graph = new WeightedMultigraph<>(Section.class);

        addVertices(graph);
        addEdgesWithWeights(graph, pathType);

        return graph;
    }

    private void addVertices(Graph<Station, Section> graph) {
        for (Station station : StationRepository.stations()) {
            graph.addVertex(station);
        }
    }

    private void addEdgesWithWeights(Graph<Station, Section> graph, String pathType) {
        for (Section section : SectionRepository.sections()) {
            Station up = section.getUpStation();
            Station down = section.getDownStation();

            graph.addEdge(up, down, section);
            graph.setEdgeWeight(section, matchType(section, pathType));
        }
    }

    private int matchType(Section section, String pathType) {
        if (pathType.equals(DISTANCE_TYPE)) {
            return section.getDistance();
        }
        return section.getTime();
    }
}
