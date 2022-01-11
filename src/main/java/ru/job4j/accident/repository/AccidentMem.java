package ru.job4j.accident.repository;

import org.springframework.stereotype.Repository;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.model.AccidentType;
import ru.job4j.accident.model.Rule;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class AccidentMem {

    private final HashMap<Integer, Accident> accidents = new HashMap<>();
    private final HashMap<Integer, AccidentType> types = new HashMap<>();
    private final HashMap<Integer, Rule> rules = new HashMap<>();
    private AtomicInteger id = new AtomicInteger(4);

    public AccidentMem() {
        accidents.put(1, new Accident(1, "Accident 1", "Description Accident 1", "Moscow"));
        accidents.put(2, new Accident(2, "Accident 2", "Description Accident 2", "SPB"));
        accidents.put(3, new Accident(3, "Accident 3", "Description Accident 3", "Ekat"));
        accidents.put(4, new Accident(4, "Accident 4", "Description Accident 4", "Tomsk"));
        types.put(1, AccidentType.of(1, "Две машины"));
        types.put(2, AccidentType.of(2, "Машина и человек"));
        types.put(3, AccidentType.of(3, "Машина и велосипед"));
        rules.put(1, Rule.of(1, "Статья. 1"));
        rules.put(2, Rule.of(2, "Статья. 2"));
        rules.put(3, Rule.of(3, "Статья. 3"));
    }

    public Collection<Accident> getAccidents() {
        return accidents.values();
    }

    public Collection<AccidentType> getTypes() {
        return types.values();
    }

    public Collection<Rule> getRules() {
        return rules.values();
    }

    public void create(Accident accident) {
        if (accident.getId() == 0) {
          accident.setId(id.incrementAndGet());
        }
        accident.setType(types.get(accident.getType().getId()));
        accidents.put(accident.getId(), accident);
    }

    public Accident findById(int id) {
        return accidents.get(id);
    }
}
