package ru.job4j.accident.repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ru.job4j.accident.model.Accident;
import java.util.Optional;

public interface AccidentRepository extends CrudRepository<Accident, Integer> {

    @Override
    @Query("select distinct ac from Accident ac left join fetch ac.rules")
    Iterable<Accident> findAll();

    @Override
    @Query("select distinct ac from Accident ac left join fetch ac.rules where ac.id = ?1")
    Optional<Accident> findById(Integer var1);

}