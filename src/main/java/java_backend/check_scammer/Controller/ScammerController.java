package java_backend.check_scammer.Controller;

import java_backend.check_scammer.Model.ResponseObject;
import java_backend.check_scammer.Model.Scammer;
import java_backend.check_scammer.Service.ScammerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/scammers")
public class ScammerController {

    @Autowired
    private ScammerService scammerService;

    @PostMapping
    public ResponseEntity<ResponseObject> saveScammer(@RequestBody Scammer scammer) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(scammerService.saveScammer(scammer));
    }

    @GetMapping
    public ResponseEntity<ResponseObject> getAllScammer() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(scammerService.getAllScammer());
    }

    @GetMapping("{id}")
    public ResponseEntity<ResponseObject> getScammerById(@PathVariable("id") String scammerId) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(scammerService.getScammerById(scammerId));
    }

    @PutMapping("{id}")
    public ResponseEntity<ResponseObject> updateScammer(@PathVariable("id") String scammerId,
                                                        @RequestBody Scammer scammer) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(scammerService.updateScammer(scammer, scammerId));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<ResponseObject> deleteScammer(@PathVariable("id") String scammerId) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(scammerService.deleteScammer(scammerId));
    }

    @GetMapping("search/{text}")
    public ResponseEntity<ResponseObject> searchScammer(@PathVariable("text") String searchText) {
        return ResponseEntity.status(HttpStatus.OK).body(scammerService.searchScammers(searchText));
    }
}