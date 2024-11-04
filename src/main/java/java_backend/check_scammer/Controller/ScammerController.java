package java_backend.check_scammer.Controller;

import java_backend.check_scammer.Model.Scammer;
import java_backend.check_scammer.Service.ScammerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/scammers")
public class ScammerController {

    @Autowired
    private ScammerService scammerService;

    @PostMapping
    public ResponseEntity<Scammer> saveScammer(@RequestBody Scammer scammer) {
        return new ResponseEntity<Scammer>(scammerService.saveScammer(scammer), HttpStatus.CREATED);
    }

    @GetMapping
    public List<Scammer> getAllScammer() {
        return scammerService.getAllScammer();
    }

    @GetMapping("{id}")
    public ResponseEntity<Scammer> getScammerById(@PathVariable("id") String scammerId) {
        return new ResponseEntity<Scammer>(scammerService.getScammerById(scammerId), HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Scammer> updateScammer(@PathVariable("id") String scammerId, @RequestBody Scammer scammer) {
        return new ResponseEntity<Scammer>(scammerService.updateScammer(scammer, scammerId), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteScammer(@PathVariable("id") String scammerId) {
        scammerService.deleteScammer(scammerId);
        return new ResponseEntity<String>("Deleted scammer successfully", HttpStatus.OK);
    }
}
