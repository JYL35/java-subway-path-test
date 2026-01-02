package subway.controller;

import subway.util.Validator;
import subway.view.InputView;
import subway.view.OutputView;

public class SubwayController {

    private final InputView inputView;
    private final OutputView outputView;

    public SubwayController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start() {
        while (true) {
            outputView.printMainScreen();
            String func1 = inputView.readFunction();
            Validator.validateFunc1(func1);
            if (func1.equals("Q")) break;
            startProgram();
        }
    }

    private void startProgram() {
        try {
            outputView.printByRoute();
            String func2 = inputView.readFunction();
            Validator.validateFunc2(func2);
            if (func2.equals("B")) return;

            String start = inputView.readStartStation();
            String last = inputView.readLastStation();

            // 1번이냐, 2번이냐에 따라 다른 메소드 시행 -> 조회 결과 출력 후 메소드 종료

        } catch (RuntimeException e) {
            outputView.printError(e);
            startProgram();
        }
    }
}
