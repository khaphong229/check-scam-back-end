package java_backend.check_scammer.Service.Impl;

import java_backend.check_scammer.DTO.AdminDTO;
import java_backend.check_scammer.Model.Admin;
import java_backend.check_scammer.Model.ResponseObject;
import java_backend.check_scammer.Repository.AdminRepository;
import java_backend.check_scammer.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.time.LocalDateTime;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public ResponseObject loginAdmin(Admin adminLogin) {
        try {
            Admin admin = adminRepository.findByEmail(adminLogin.getEmail());
            if (admin == null) {
                return ResponseObject.error("Không tìm thấy email");
            }
            if (!passwordEncoder.matches(adminLogin.getPassword(), admin.getPassword())) {
                return ResponseObject.error("Mật khẩu không đúng!");
            }
            AdminDTO adminDTO = new AdminDTO(admin);
            return ResponseObject.success(adminDTO);
        } catch (Exception e) {
            return ResponseObject.error("Lỗi đăng nhập" + e.getMessage());
        }
    }

    @Override
    public ResponseObject registerAdmin(Admin adminRegister) {
        try {
            if (adminRepository.findByEmail(adminRegister.getEmail()) != null) {
                return ResponseObject.error("Email đã tồn tại!");
            }

            adminRegister.setCreatedAt(LocalDateTime.now());
            adminRegister.setUpdatedAt(LocalDateTime.now());
            adminRegister.setStatus("active");
            adminRegister.setPassword(passwordEncoder.encode(adminRegister.getPassword()));
            Admin savedAdmin = adminRepository.save(adminRegister);

            AdminDTO adminDTO = new AdminDTO(savedAdmin);

            return ResponseObject.success(adminDTO);
        } catch (Exception e) {
            return ResponseObject.error("Lỗi đăng ký" + e.getMessage());
        }
    }
}
