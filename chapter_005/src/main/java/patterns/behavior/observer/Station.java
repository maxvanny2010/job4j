package patterns.behavior.observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Station.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 10/28/2019
 */
public class Station implements Observable {
    /**
     * field station.
     */
    private final List<Observer> station = new ArrayList<>();
    /**
     * field temperature.
     */
    private int temperature;
    /**
     * field pressure.
     */
    private int pressure;

    /**
     * Method to get list.
     *
     * @return the list
     */
    final List<Observer> getStation() {
        return this.station;
    }

    /**
     * Method to set.
     *
     * @param aTemperature temp
     * @param aPressure    press
     */
    final void setMeasurements(final int aTemperature, final int aPressure) {
        this.temperature = aTemperature;
        this.pressure = aPressure;
        this.notifyObserves();
    }

    /**
     * Method to add.
     *
     * @param obs observer
     */
    public final void addObserver(final Observer obs) {
        Objects.requireNonNull(obs, "must not be null");
        this.station.add(obs);
    }

    /**
     * Method to remove.
     *
     * @param obs observer
     */
    public final void removeObserver(final Observer obs) {
        Objects.requireNonNull(obs, "must not be null");
        this.station.removeIf(o -> o.equals(obs));
    }

    /**
     * Method to notify.
     */
    private void notifyObserves() {
        for (final Observer obs : this.station) {
            obs.handleEvent(this.temperature, this.pressure);
        }
    }
}
