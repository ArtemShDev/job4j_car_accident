package ru.job4j.accident.service;

import org.springframework.stereotype.Service;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.model.AccidentType;
import ru.job4j.accident.model.Rule;
import ru.job4j.accident.repository.AccidentJdbcTemplate;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class AccidentService {

private final AccidentJdbcTemplate accidents;

    public AccidentService(AccidentJdbcTemplate accidents) {
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

    public void create(Accident accident, String[] ids) {
        Set<Rule> rules = new HashSet<>();
        if (ids != null) {
            for (String id : ids) {
                rules.add(accidents.findRuleById(Integer.parseInt(id)));
            }
            accident.setRules(rules);
        }
        accidents.save(accident);
    }
}
