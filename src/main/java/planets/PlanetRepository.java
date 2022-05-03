package planets;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlanetRepository extends CrudRepository<Planet, Long> {
    List<Planet> findByNameContaining(String value);

    /*
        @Query("SELECT p FROM Planet p WHERE p.name LIKE %:value%")
        List<Planet> findByNameLike(@Param("value") String value);
    */
}