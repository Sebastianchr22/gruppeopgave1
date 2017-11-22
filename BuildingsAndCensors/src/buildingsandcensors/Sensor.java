package buildingsandcensors;

import java.util.ArrayList;
import java.util.List;

public class Sensor implements acq.ISensor {

    private List<Double> measurements = new ArrayList();
    //Max 70 målinger:
    //Lav constructor, for at undgå probler ved første kald.
    Sensor(double d){
        measurements.add(d);
    }
    @Override
    public double getMeasurements() {
        return this.measurements.get(this.measurements.size() - 1);
    }

    @Override
    public void updateMeasurement(double d) {
        measurements.add(d);
    }

}
