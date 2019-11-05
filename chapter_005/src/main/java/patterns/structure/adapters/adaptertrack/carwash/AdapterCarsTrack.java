package patterns.structure.adapters.adaptertrack.carwash;

import patterns.structure.adapters.adaptertrack.cars.Cars;
import patterns.structure.adapters.adaptertrack.tracks.Tracks;

/**
 * AdapterCarTrack.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 10/24/2019
 */
public class AdapterCarsTrack implements Cars {
    /**
     * field a track.
     */
    private final Tracks tracks;

    /**
     * Constructor.
     *
     * @param aTracks the track
     */
    AdapterCarsTrack(final Tracks aTracks) {
        this.tracks = aTracks;
    }

    @Override
    public final void wash() {
        this.tracks.clean();
    }
}
