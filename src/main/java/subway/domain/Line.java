package subway.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private String name;
    private List<Section> sections;

    public Line(String name) {
        this.name = name;
        this.sections = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addSection(Section section) {
        sections.add(section);
    }
}
