package lib.utils;

import java.time.LocalDateTime;
import java.util.Date;

public class timeHandler {
    private long initialTime;
    private long finishTime;

    public void startTime() {
        this.initialTime = System.currentTimeMillis() % 1000;
    }

    public void stopTime() {
        this.finishTime = System.currentTimeMillis() % 1000;
    }

    public String calculateTime() {
        long finalTime = this.finishTime - this.initialTime;
        return "" + finalTime;
    }
}
