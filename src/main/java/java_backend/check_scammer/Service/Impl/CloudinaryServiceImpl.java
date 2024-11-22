package java_backend.check_scammer.Service.Impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import java_backend.check_scammer.Model.ResponseObject;
import java_backend.check_scammer.Service.CloudinaryService;
import java_backend.check_scammer.Util.FileUploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@Service
public class CloudinaryServiceImpl implements CloudinaryService {
    @Autowired
    private Cloudinary cloudinary;

    @Override
    public ResponseObject uploadFile(MultipartFile file) {
        try {
            FileUploadUtil.assertAllows(file, FileUploadUtil.IMAGE_PATTERN);
            Map uploadResult = cloudinary.uploader().upload(file.getBytes(),
                    ObjectUtils.asMap(
                            "resource_type", "auto",
                            "folder", "scammer-images"
                    ));
            String imageUrl = (String) uploadResult.get("secure_url");
            return ResponseObject.success(imageUrl);
        } catch (IOException e) {
            return ResponseObject.error("Lỗi tải file: " + e.getMessage());
        } catch (Error e) {
            return ResponseObject.error(e.getMessage());
        }
    }
}
