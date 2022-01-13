package ru.job4j.accident.service;

import org.springframework.stereotype.Service;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.model.AccidentType;
import ru.job4j.accident.model.Rule;
import ru.job4j.accident.repository.AccidentRepository;
import ru.job4j.accident.repository.AccidentTypeRepository;
import ru.job4j.accident.repository.RuleRepository;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class AccidentService {
    private final AccidentRepository accidents;
    private final AccidentTypeRepository typesRep;
    private final RuleRepository rulesRep;

    public AccidentService(AccidentRepository accidents, AccidentTypeRepository types, RuleRepository rules) {
        this.accidents = accidents;
        this.typesRep = types;
        this.rulesRep = rules;
    }

    public Collection<Accident> getAccidents() {
        List<Accident> acc = new ArrayList<>();
        accidents.findAll().forEach(acc::add);
        return acc;
    }

    public Collection<AccidentType> getTypes() {
        List<AccidentType> types = new ArrayList<>();
        typesRep.findAll().forEach(t -> types.add(t));
        return types;
    }

    public Collection<Rule> getRules() {
        List<Rule> rules = new ArrayList<>();
        rulesRep.findAll().forEach(t -> rules.add(t));
        return rules;
    }

    public Accident findById(int id) {
        return accidents.findById(id).orElse(new Accident());
    }

    public void create(Accident accident, String[] ids) {
        if (accident.getId() == 0) {
            for (String id : ids) {
                accident.addRule(rulesRep.findById(Integer.parseInt(id)).get());
            }
            accident.setType(typesRep.findById(accident.getType().getId()).get());
            accidents.save(accident);
        } else {
            Accident accidentDB = findById(accident.getId());
            accidentDB.setName(accident.getName());
            accidentDB.setText(accident.getText());
            accidentDB.setAddress(accident.getAddress());
            accidents.save(accidentDB);
        }
    }
}
