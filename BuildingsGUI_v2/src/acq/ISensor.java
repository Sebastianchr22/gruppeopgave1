package acq;

import java.util.List;

public interface ISensor {

    public double getMeasurement();

    public void updateMeasurement();

    public List getMeasurements();

    }
