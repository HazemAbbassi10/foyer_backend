package tn.esprit.spring.test.control;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.test.entities.Chambre;
import tn.esprit.spring.test.entities.TypeChambre;
import tn.esprit.spring.test.services.IChambreService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/chambre")
public class ChambreRestController {
    IChambreService chambreService;

    @GetMapping("/retrieve-all-chambres")
    public List<Chambre> getAllChambres() {
        return chambreService.retrieveAllChambres();
    }

    @GetMapping("/retrieve-chambre/{chambre-id}")
    public Chambre retrieveChambre(@PathVariable("chambre-id") Long chambreId) {
        return chambreService.retrieveChambre(chambreId);
    }

    @PostMapping("/add-chambre")
    public Chambre addChambre(@RequestBody Chambre c) {
        return chambreService.addChambre(c);
    }

    @DeleteMapping("/remove-chambre/{chambre-id}")
    public void removeChambre(@PathVariable("chambre-id") Long chambreId) {
        chambreService.removeChambre(chambreId);
    }

    @PutMapping("/modify-chambre")
    public Chambre modifyChambre(@RequestBody Chambre c) {
        return chambreService.modifyChambre(c);
    }

    @GetMapping("/chambres-par-universite/{nomUniversite}")
    public List<Chambre> getChambresParNomUniversite(@PathVariable("nomUniversite") String nomUniversite) {
        return chambreService.getChambresParNomUniversite(nomUniversite);
    }

    @GetMapping("/chambres-par-bloc-et-type/{idBloc}/{typeC}")
    public List<Chambre> getChambresParBlocEtType(@PathVariable("idBloc") long idBloc, @PathVariable("typeC") TypeChambre typeC) {
        return chambreService.getChambresParBlocEtType(idBloc, typeC);
    }

    @GetMapping("/non-reservees/{nomUniversite}/{type}")
    public List<Chambre> getChambresNonReserve(@PathVariable("nomUniversite") String nomUniversite, @PathVariable("type") TypeChambre type) {
        return chambreService.getChambresNonReserveParNomUniversiteEtTypeChambre(nomUniversite, type);
    }
}
