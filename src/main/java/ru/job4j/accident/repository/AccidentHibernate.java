package ru.job4j.accident.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.model.AccidentType;
import ru.job4j.accident.model.Rule;
import java.util.Collection;
import java.util.List;

/*
@Repository
 */
public class AccidentHibernate {

    private final SessionFactory sf;

    public AccidentHibernate(SessionFactory sf) {
        this.sf = sf;
    }

    public List<Accident> getAccidents() {
        try (Session session = sf.openSession()) {
            return session
                    .createQuery("from Accident order by id", Accident.class)
                    .list();
        }
    }

    public Collection<AccidentType> getTypes() {
        try (Session session = sf.openSession()) {
            return session
                    .createQuery("from AccidentType", AccidentType.class)
                    .list();
        }
    }

    public Collection<Rule> getRules() {
        try (Session session = sf.openSession()) {
            return session
                    .createQuery("from Rule", Rule.class)
                    .list();
        }
    }

    public Accident save(Accident accident, String[] ids) {
        try (Session session = sf.openSession()) {
            session.beginTransaction();
            if (accident.getId() == 0) {
                for (String id : ids) {
                    accident.addRule(session.get(Rule.class, Integer.parseInt(id)));
                }
                session.save(accident);
            } else {
                Accident accidentDB = session.get(Accident.class, accident.getId());
                accidentDB.setName(accident.getName());
                accidentDB.setText(accident.getText());
                accidentDB.setAddress(accident.getAddress());
                session.saveOrUpdate(accidentDB);
            }
            session.getTransaction().commit();
        }
        return accident;
    }

    public Accident findById(int id) {
        try (Session session = sf.openSession()) {
            return session
                    .createQuery("from Accident where id = :id", Accident.class)
                    .setParameter("id", id).uniqueResult();
        }
    }

    public Rule findRuleById(int id) {
        try (Session session = sf.openSession()) {
            return session
                    .createQuery("from Rule where id = :id", Rule.class)
                    .setParameter("id", id).uniqueResult();
        }
    }
}