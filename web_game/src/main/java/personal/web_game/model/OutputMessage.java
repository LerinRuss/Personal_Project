package personal.web_game.model;

import lombok.Getter;

public class OutputMessage {
    @Getter
    private String from;
    @Getter
    private String text;
    @Getter
    private String time;

    public OutputMessage(String from, String text, String time) {
        this.from = from;
        this.text = text;
        this.time = time;
    }
}
