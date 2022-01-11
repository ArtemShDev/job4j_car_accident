package ru.job4j.accident.repository;

import org.springframework.stereotype.Repository;
import ru.job4j.accident.model.Accident;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class AccidentMem {

    private final HashMap<Integer, Accident> accidents = new HashMap<>();
    private AtomicInteger id = new AtomicInteger(4);

    public AccidentMem() {
        accidents.put(1, new Accident(1, "Accident 1", "Description Accident 1", "Moscow"));
        accidents.put(2, new Accident(2, "Accident 2", "Description Accident 2", "SPB"));
        accidents.put(3, new Accident(3, "Accident 3", "Description Accident 3", "Ekat"));
        accidents.put(4, new Accident(4, "Accident 4", "Description Accident 4", "Tomsk"));
    }

    public Collection<Accident> getAccidents() {
        return accidents.values();
    }

    public void create(Accident accident) {
        if (accident.getId() == 0) {
          accident.setId(id.incrementAndGet());
        }
        accidents.put(accident.getId(), accident);
    }

    public Accident findById(int id) {
        return accidents.get(id);
    }
}
