package java_backend.check_scammer.Service.Impl;

import java_backend.check_scammer.Model.Scammer;
import java_backend.check_scammer.Repository.ScammerRepository;
import java_backend.check_scammer.Service.ScammerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java_backend.check_scammer.Model.ResponseObject;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ScammerServiceImpl implements ScammerService {

    @Autowired
    private ScammerRepository scammerRepository;

    @Override
    public ResponseObject saveScammer(Scammer scammer) {
        try {
            if (scammer.getCreatedAt() == null) {
                scammer.setCreatedAt(LocalDateTime.now());
            }
            scammer.setUpdatedAt(LocalDateTime.now());
            scammer.setStatus("pending");
            Scammer savedScammer = scammerRepository.save(scammer);
            return ResponseObject.success(savedScammer);
        } catch (Exception e) {
            return ResponseObject.error("Không thể lưu thông tin scammer: " + e.getMessage());
        }

    }

    @Override
    public ResponseObject getAllScammer() {
        try {
            return ResponseObject.success(scammerRepository.findAll());
        } catch (Exception e) {
            return ResponseObject.error("Lỗi khi lấy danh sách scammer: " + e.getMessage());
        }
    }

    @Override
    public ResponseObject getScammerById(String id) {
        try {
            Optional<Scammer> scammer = scammerRepository.findById(id);
            if (scammer.isPresent()) {
                return ResponseObject.success(scammer.get());
            } else {
                return ResponseObject.notFound("Không tìm thấy scammer id: " + id);
            }
        } catch (Exception e) {
            return ResponseObject.error("Lỗi khi tìm scammer: " + e.getMessage());
        }
    }

    @Override
    public ResponseObject updateScammer(Scammer scammer, String id) {
        try {
            if (id == null || id.trim().isEmpty()) {
                return ResponseObject.error("Id không được để trống");
            }
            Optional<Scammer> existedScammerOpt = scammerRepository.findById(id);
            if (!existedScammerOpt.isPresent()) {
                return ResponseObject.error("Không tìm thấy scammer với id: " + id);
            }
            Scammer existedScammer = existedScammerOpt.get();

            if (scammer.getNameScammer() != null && !scammer.getNameScammer().trim().isEmpty()) {
                existedScammer.setNameScammer(scammer.getNameScammer());
            }

            if (scammer.getPhoneScammer() != null && !scammer.getPhoneScammer().trim().isEmpty()) {
                existedScammer.setPhoneScammer(scammer.getPhoneScammer());
            }

            if (scammer.getBankNumber() != null) {
                existedScammer.setBankNumber(scammer.getBankNumber());
            }

            if (scammer.getBankName() != null) {
                existedScammer.setBankName(scammer.getBankName());
            }

            if (scammer.getContentReport() != null) {
                existedScammer.setContentReport(scammer.getContentReport());
            }

            if (scammer.getNameSender() != null) {
                existedScammer.setNameSender(scammer.getNameSender());
            }

            if (scammer.getPhoneSender() != null) {
                existedScammer.setPhoneSender(scammer.getPhoneSender());
            }

            if (scammer.getOption() != null) {
                existedScammer.setOption(scammer.getOption());
            }

            if (scammer.getImages() != null) {
                existedScammer.setImages(scammer.getImages());
            }

            Scammer updatedScammer = scammerRepository.save(existedScammer);
            return ResponseObject.success(updatedScammer);
        } catch (Exception e) {
            return ResponseObject.error("Lỗi khi cập nhật scammer: " + e.getMessage());
        }
    }

    @Override
    public ResponseObject deleteScammer(String id) {
        try {
            Optional<Scammer> scammer = scammerRepository.findById(id);
            if (!scammer.isPresent()) {
                return ResponseObject.notFound("Không tìm thấy scammer với id: " + id);
            }
            scammerRepository.deleteById(id);
            return ResponseObject.success("Xóa scammer thành công");
        } catch (Exception e) {
            return ResponseObject.error("Lỗi khi xóa scammer: " + e.getMessage());
        }
    }
}
