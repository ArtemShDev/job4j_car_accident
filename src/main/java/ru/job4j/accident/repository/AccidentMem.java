package ru.job4j.accident.repository;

import org.springframework.stereotype.Repository;
import ru.job4j.accident.model.Accident;
import java.util.Collection;
import java.util.HashMap;

@Repository
public class AccidentMem {

    private final HashMap<Integer, Accident> accidents = new HashMap<>();

    public AccidentMem() {
        accidents.put(1, new Accident(1, "Accident 1", "Description Accident 1", "Moscow"));
        accidents.put(2, new Accident(2, "Accident 2", "Description Accident 2", "SPB"));
        accidents.put(3, new Accident(3, "Accident 3", "Description Accident 3", "Ekat"));
        accidents.put(4, new Accident(4, "Accident 4", "Description Accident 4", "Tomsk"));
    }

    public Collection<Accident> getAccidents() {
        return accidents.values();
    }

    public static void main(String[] args) {
    }

    public void create(Accident accident) {
    }
}
