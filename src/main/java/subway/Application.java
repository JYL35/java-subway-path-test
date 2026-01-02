package subway;

import subway.controller.SubwayController;
import subway.init.SubwayInitializer;
import subway.service.GraphFactory;
import subway.service.PathService;
import subway.view.InputView;
import subway.view.OutputView;

public class Application {
    public static void main(String[] args) {
        SubwayInitializer.initialize();
        SubwayController subwayController = new SubwayController(
                new PathService(new GraphFactory()),
                new InputView(), new OutputView()
        );
        subwayController.start();
    }
}
