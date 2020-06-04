package accident.service;

import accident.model.Accident;
import accident.repository.IAccidentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * AccidentService.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 6/4/2020
 */
@Service
public class AccidentService implements IAccidentService {
    /**
     * field a repository.
     */
    private final IAccidentRepository repo;

    /**
     * Constructor.
     *
     * @param aRepo a repository
     */
    public AccidentService(final IAccidentRepository aRepo) {
        this.repo = aRepo;
    }

    @SuppressWarnings("unused")
    @Override
    public final Accident saveAccident(final Accident accident) {
        return this.repo.save(accident);
    }

    @SuppressWarnings("unused")
    @Override
    public final Accident editAccident(final Accident accident) {
        return this.repo.edit(accident);
    }

    @SuppressWarnings("unused")
    @Override
    public final Accident deleteAccident(final Accident accident) {
        return this.repo.delete(accident);
    }

    @SuppressWarnings("unused")
    @Override
    public final Accident getAccident(final Accident accident) {
        return this.repo.get(accident);
    }

    @Override
    public final List<Accident> getAllAccident() {
        return this.repo.getAll();
    }
}
