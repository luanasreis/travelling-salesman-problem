package lib.utils;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

public class TimeHandler {
    private long initialTime;
    private long finishTime;
    private long finalTime;
    private ArrayList<Long> times;

    public void startTime() {
        this.initialTime = System.currentTimeMillis() % 1000;
        times =  new ArrayList<>();
    }

    public void stopTime() {
        this.finishTime = System.currentTimeMillis() % 1000;
        this.finalTime = this.finishTime - this.initialTime;
        this.times.add(this.finalTime);
    }


    public String getLastTime() {
        return "" + this.finalTime;
    }

    public String getMediaOfTimes(String name) {
        long result = 0;
        StringBuilder string = new StringBuilder();
        for(long time : times) {
            result += time;
        }

        string.append("A média de tempo do algoritmo ").append(name);
        result = result/times.size();
        string.append(" ").append(result);

        return "Média de tempo:" + result;
    }
}
