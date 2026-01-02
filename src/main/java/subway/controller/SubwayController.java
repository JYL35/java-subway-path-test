package subway.controller;

import subway.dto.PathResult;
import subway.service.PathService;
import subway.util.Validator;
import subway.view.InputView;
import subway.view.OutputView;

public class SubwayController {

    private final PathService pathService;
    private final InputView inputView;
    private final OutputView outputView;

    public SubwayController(PathService pathService, InputView inputView, OutputView outputView) {
        this.pathService = pathService;
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

            PathResult pathResult = pathService.findShortestDistance(func2, start, last);
            outputView.printPathResult(pathResult);
        } catch (RuntimeException e) {
            outputView.printError(e);
            startProgram();
        }
    }
}
