package subway.constant;

public enum ErrorMessage {
    NOT_FOUND_STATION("존재하지 않은 역입니다."),
    NOT_FOUND_LINE("존재하지 않은 노선입니다."),
    SAME_STATION("출발역과 도착역이 동일합니다."),
    NOT_FOUND_START("출발역이 존재하지 않은 역입니다."),
    NOT_FOUND_END("도착역이 존재하지 않은 역입니다."),
    NOT_CONNECTED("출발역에서 도착역까지 갈 수 있는 길이 없습니다."),
    IS_BLANK("빈 값입니다."),
    INVALID_FORMAT("잘못된 형식을 입력하였습니다."),
    NOT_FOUND_NICKNAME("등록되지 않은 닉네임입니다.");

    private static final String PREFIX = "[ERROR] ";
    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return PREFIX + message;
    }
}
