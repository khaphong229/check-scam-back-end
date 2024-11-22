package java_backend.check_scammer.Service;

import org.springframework.web.multipart.MultipartFile;
import java_backend.check_scammer.Model.ResponseObject;

public interface CloudinaryService {
    ResponseObject uploadFile(MultipartFile file);
}
