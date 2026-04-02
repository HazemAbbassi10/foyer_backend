package tn.esprit.spring.test.control;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.test.entities.Bloc;
import tn.esprit.spring.test.services.IBlocService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/bloc")
public class BlocRestController {
    IBlocService blocService;

    // http://localhost:8089/tpfoyer/chambre/retrieve-all-chambres
    @GetMapping("/retrieve-all-blocs")
    public List<Bloc> getBloc() {
        List<Bloc> listBlocs = blocService.retrieveAllBlocs();
        return listBlocs;
    }

    @GetMapping("/retrieve-bloc/{bloc-id}")
    public Bloc retrieveBloc(@PathVariable("bloc-id") Long blId) {
        Bloc chambre = blocService.retrieveBloc(blId);
        return chambre;
    }

    // http://localhost:8089/tpfoyer/bloc/add-chambre
    @PostMapping("/add-bloc")
    public Bloc addBloc(@RequestBody Bloc b) {
        Bloc bloc = blocService.addBloc(b);
        return bloc;
    }

    // http://localhost:8089/tpfoyer/bloc/remove-chambre/{bloc-id}
    @DeleteMapping("/remove-bloc/{bloc-id}")
    public void removeBloc(@PathVariable("bloc-id") Long blId) {
        blocService.removeBloc(blId);
    }

    // http://localhost:8089/tpfoyer/bloc/modify-bloc
    @PutMapping("/modify-bloc")
    public Bloc modifyBloc(@RequestBody Bloc bl) {
        Bloc bloc = blocService.modifyBloc(bl);
        return bloc;
    }

    @PutMapping("/affecter-chambres/{idBloc}")
    public Bloc affecterChambresABloc(
            @RequestBody List<Long> numChambre,
            @PathVariable long idBloc) {
        return blocService.affecterChambresABloc(numChambre, idBloc);
    }

}
