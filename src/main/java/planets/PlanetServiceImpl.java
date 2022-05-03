package planets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlanetServiceImpl implements PlanetService {

    @Autowired
    private PlanetRepository planetRepository;

    @Override
    public List<Planet> getAllPlanets() {
        return (List<Planet>) planetRepository.findAll();
    }

    @Override
    public Planet getPlanetById(Long id) {
        return planetRepository.findById(id).get();
    }

    @Override
    public Planet savePlanet(Planet planet) {
        return planetRepository.save(planet);
    }

    @Override
    public Planet updatePlanetById(Long id, Planet planetToUpdate) {
        Planet planetFromDB = planetRepository.findById(id).get();
        planetFromDB.setName(planetToUpdate.getName());
        planetFromDB.setNumberOfMoons(planetToUpdate.getNumberOfMoons());

        return planetRepository.save(planetFromDB);
    }

    @Override
    public void deletePlanetById(Long Id) {
        planetRepository.deleteById(Id);
    }

    @Override
    public List<Planet> getPlanetsByNameContaining(String searchString) {
        return planetRepository.findByNameContaining(searchString);
    }
}
