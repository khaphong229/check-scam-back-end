package java_backend.check_scammer.Service;

import java_backend.check_scammer.Model.ResponseObject;
import java_backend.check_scammer.Model.Admin;

public interface AdminService {
    ResponseObject loginAdmin(Admin admin);

    ResponseObject registerAdmin(Admin admin);
}
