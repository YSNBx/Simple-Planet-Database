package planets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/planet")
public class PlanetController {

    @Autowired
    private PlanetService planetService;

    @GetMapping
    public List<Planet> getAllPlanets() {
        return planetService.getAllPlanets();
    }

    @GetMapping("/{id}")
    public Planet getPlanetById(@PathVariable("id") Long Id) {
        return planetService.getPlanetById(Id);
    }

    @GetMapping("/search")
    public List<Planet> getPlanetsByName(@RequestParam String name) {
        return planetService.getPlanetsByNameContaining(name);
    }

    @PostMapping
    public ResponseEntity<Planet> savePlanet(@RequestBody Planet planet) {
        Planet savedPlanet = planetService.savePlanet(planet);
        return new ResponseEntity<Planet>(savedPlanet, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updatePlanetById(@PathVariable("id") Long id,
                                              @RequestBody Planet planet) {

        Planet updatedPlanet = planetService.updatePlanetById(id, planet);
        return new ResponseEntity<Planet>(updatedPlanet, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePlanetById(@PathVariable("id") Long id) {
        planetService.deletePlanetById(id);
        return new ResponseEntity<>("Entry Deleted.", HttpStatus.OK);
    }

    @PostMapping("/list")
    public void saveList(@RequestBody ArrayList<Planet> planets) {
        planets.forEach(p -> planetService.savePlanet(p));
    }
}
