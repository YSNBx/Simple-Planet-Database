package planets;

import org.springframework.stereotype.Service;

import java.util.List;

public interface PlanetService {
    List<Planet> getAllPlanets();

    Planet getPlanetById(Long id);

    Planet savePlanet(Planet planet);

    Planet updatePlanetById(Long id, Planet planetToUpdate);

    void deletePlanetById(Long id);

    List<Planet> getPlanetsByNameContaining(String searchString);
}
