package subway.util;

import java.util.List;
import subway.constant.ErrorMessage;

public class Validator {

    public static void validateFunc1(String input) {
        validateEmpty(input);

        List<String> func1 = List.of("1", "Q");
        if (func1.contains(input)) {
            return;
        }
        throw new IllegalArgumentException(ErrorMessage.INVALID_FORMAT.getMessage());
    }

    public static void validateFunc2(String input) {
        validateEmpty(input);

        List<String> func1 = List.of("1", "2", "B");
        if (func1.contains(input)) {
            return;
        }
        throw new IllegalArgumentException(ErrorMessage.INVALID_FORMAT.getMessage());
    }

    private static void validateEmpty(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.IS_BLANK.getMessage());
        }
    }
}
