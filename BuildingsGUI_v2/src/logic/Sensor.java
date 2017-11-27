package logic;

import java.util.ArrayList;
import java.util.List;

public class Sensor implements acq.ISensor {

    private List<Double> measurements = new ArrayList();

    //Max 70 målinger:
    //Lav constructor, for at undgå probler ved første kald.
    Sensor(double d) {
        measurements.add(d);
    }

    @Override
    public double getMeasurement() {
        return this.measurements.get(this.measurements.size() - 1);
    }
    public List getMeasurements(){
        return this.measurements;
    }
    @Override
    public void updateMeasurement() {
        double d = 1+Math.random()*25;
        measurements.add(d);
    }

    @Override
    public String toString() {
        return String.valueOf(this.getMeasurement());
    }
}
