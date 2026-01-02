package subway.dto;

import java.util.List;

public record PathResult(
        List<String> stationNames,
        int totalDistance,
        int totalTime
) {
}
