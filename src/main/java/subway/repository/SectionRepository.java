package subway.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import subway.domain.Section;
import subway.domain.Station;

public class SectionRepository {
    private static final List<Section> sections = new ArrayList<>();

    public static List<Section> sections() {
        return Collections.unmodifiableList(sections);
    }

    public static void addSection(Section section) {
        sections.add(section);
    }

    public static boolean deleteSection(Station upStation, Station downStation) {
        return sections.removeIf(section -> isSamePair(section, upStation, downStation));
    }

    public static void deleteAll() {
        sections.clear();
    }

    private static boolean isSamePair(Section section, Station a, Station b) {
        return (Objects.equals(section.getUpStation(), a)
                && Objects.equals(section.getDownStation(), b))
                || (Objects.equals(section.getUpStation(), b)
                && Objects.equals(section.getDownStation(), a));
    }
}
