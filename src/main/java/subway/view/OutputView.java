package subway.view;

import subway.dto.PathResult;

public class OutputView {
    private static final String PREFIX = "[INFO] ";

    public void printMainScreen() {
        printNewLine();
        System.out.println("## 메인 화면");
        System.out.println("1. 경로 조회");
        System.out.println("Q. 종료");
    }

    public void printByRoute() {
        printNewLine();
        System.out.println("## 경로 기준");
        System.out.println("1. 최단 거리");
        System.out.println("2. 최소 시간");
        System.out.println("B. 돌아가기");
    }

    public void printPathResult(PathResult pathResult) {
        printNewLine();
        System.out.println("## 조회 결과");
        System.out.println(PREFIX + "---");
        System.out.println(PREFIX + "총 거리: " + pathResult.totalDistance() + "km");
        System.out.println(PREFIX + "총 소요 시간: " + pathResult.totalTime() + "분");
        System.out.println(PREFIX + "---");
        for (String station : pathResult.stationNames()) {
            System.out.println(PREFIX + station);
        }
    }

    public void printError(RuntimeException e) {
        printNewLine();
        System.out.println(e.getMessage());
        printNewLine();
    }

    private static void printNewLine() {
        System.out.print(System.lineSeparator());
    }
}
