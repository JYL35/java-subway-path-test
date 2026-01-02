package subway.domain;

import java.util.Objects;

public class Station {
    private String name;

    public Station(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Station station)) {
            return false;
        }
        return Objects.equals(name, station.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}
