package subway.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String CHOOSE_FUNC = "## 원하는 기능을 선택하세요.";
    private static final String START_STATION = "## 출발역을 입력하세요.";
    private static final String LAST_STATION = "## 도착역을 입력하세요.";

    public String readFunction() {
        return userInput(CHOOSE_FUNC);
    }

    public String readStartStation() {
        return userInput(START_STATION);
    }

    public String readLastStation() {
        return userInput(LAST_STATION);
    }

    private String userInput(String message) {
        printNewLine();
        System.out.println(message);
        return Console.readLine();
    }

    private static void printNewLine() {
        System.out.print(System.lineSeparator());
    }
}
