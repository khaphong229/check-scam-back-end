package java_backend.check_scammer.Controller;

import java_backend.check_scammer.Model.ResponseObject;
import java_backend.check_scammer.Model.Admin;
import java_backend.check_scammer.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
@CrossOrigin
public class AdminController {
    @Autowired
    private AdminService adminService;

    @PostMapping(value = "/login", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseObject> loginAdmin(@RequestBody Admin admin) {
        ResponseObject result = adminService.loginAdmin(admin);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @PostMapping(value = "/register", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseObject> registerAdmin(@RequestBody Admin admin) {
        ResponseObject result = adminService.registerAdmin(admin);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
