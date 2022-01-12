package ru.job4j.accident.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.model.AccidentType;
import ru.job4j.accident.model.Rule;
import java.sql.PreparedStatement;
import java.util.Collection;
import java.util.List;

@Repository
public class AccidentJdbcTemplate {

    private final JdbcTemplate jdbc;

    public AccidentJdbcTemplate(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public Collection<Accident> getAccidents() {
        return jdbc.query("select id, name, text, address from accidents order by id",
                (rs, row) -> {
                    Accident accident = new Accident();
                    accident.setId(rs.getInt("id"));
                    accident.setName(rs.getString("name"));
                    accident.setText(rs.getString("text"));
                    accident.setAddress(rs.getString("address"));
                    return accident;
                });
    }

    public Collection<AccidentType> getTypes() {
        return jdbc.query("select id, name from types",
                (rs, row) -> {
                    AccidentType type = new AccidentType();
                    type.setId(rs.getInt("id"));
                    type.setName(rs.getString("name"));
                    return type;
                });
    }

    public Collection<Rule> getRules() {
        return jdbc.query("select id, name from rules",
                (rs, row) -> {
                    Rule rule = new Rule();
                    rule.setId(rs.getInt("id"));
                    rule.setName(rs.getString("name"));
                    return rule;
                });
    }

    public Accident save(Accident accident) {
        if (accident.getId() == 0) {
            KeyHolder keyHolder = new GeneratedKeyHolder();
            String textSQL = "insert into accidents (name, text, address, type_id) values (?, ?, ?, ?)";
            jdbc.update(connection -> {
                PreparedStatement ps = connection.prepareStatement(textSQL, new String[]{"id"});
                ps.setString(1, accident.getName());
                ps.setString(2, accident.getText());
                ps.setString(3, accident.getAddress());
                ps.setInt(4, accident.getType().getId());
                return ps;
            }, keyHolder);
            accident.setId((int) keyHolder.getKey());
            for (Rule rule : accident.getRules()) {
                jdbc.update("insert into accident_rule (type_id, accident_id) values (?, ?)",
                        rule.getId(), keyHolder.getKey());
            }
        } else {
            jdbc.update("update accidents set name = ?, text = ?, address = ? where id = ?",
                    accident.getName(), accident.getText(), accident.getAddress(), accident.getId());
        }
        return accident;
    }

    public Accident findById(int id) {
        return jdbc.queryForObject("select id, name, text, address from accidents where id = ?",
                (rs, row) -> {
                    Accident accident = new Accident();
                    accident.setId(rs.getInt("id"));
                    accident.setName(rs.getString("name"));
                    accident.setText(rs.getString("text"));
                    accident.setAddress(rs.getString("address"));
                    return accident;
                }, id);
    }

    public Rule findRuleById(int id) {
        return jdbc.queryForObject("select id, name from rules where id = ?",
                (rs, row) -> {
                    Rule rule = new Rule();
                    rule.setId(rs.getInt("id"));
                    rule.setName(rs.getString("name"));
                    return rule;
                }, id);
    }
}