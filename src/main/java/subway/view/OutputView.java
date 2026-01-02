package subway.view;

public class OutputView {
    private static final String MAIN_SCREEN = "## 메인 화면";

    public void printMainScreen() {
        System.out.println(MAIN_SCREEN);
        System.out.println("1. 경로 조회");
        System.out.println("Q. 종료");
        printNewLine();
    }

    public void printByRoute() {
        System.out.println("## 경로 기준");
        System.out.println("1. 최단 거리");
        System.out.println("2. 최소 시간");
        System.out.println("B. 돌아가기");
        printNewLine();
    }

    public void printError(RuntimeException e) {
        System.out.println(e.getMessage());
        printNewLine();
    }

    private static void printNewLine() {
        System.out.print(System.lineSeparator());
    }
}
