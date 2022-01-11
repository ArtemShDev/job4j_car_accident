package ru.job4j.accident.service;

import org.springframework.stereotype.Service;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.model.AccidentType;
import ru.job4j.accident.model.Rule;
import ru.job4j.accident.repository.AccidentMem;

import java.util.Collection;

@Service
public class AccidentService {

    private final AccidentMem accidents;

    public AccidentService(AccidentMem accidents) {
        this.accidents = accidents;
    }

    public Collection<Accident> getAccidents() {
        return accidents.getAccidents();
    }

    public Collection<AccidentType> getTypes() {
        return accidents.getTypes();
    }

    public Collection<Rule> getRules() {
        return accidents.getRules();
    }

    public Accident findById(int id) {
        return accidents.findById(id);
    }

    public void create(Accident accident) {
        accidents.create(accident);
    }
}
