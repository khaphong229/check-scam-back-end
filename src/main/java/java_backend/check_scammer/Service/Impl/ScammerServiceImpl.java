package java_backend.check_scammer.Service.Impl;

import java_backend.check_scammer.Model.Scammer;
import java_backend.check_scammer.Repository.ScammerRepository;
import java_backend.check_scammer.Service.ScammerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScammerServiceImpl implements ScammerService {

    @Autowired
    private ScammerRepository scammerRepository;

    @Override
    public Scammer saveScammer(Scammer scammer) {
        return scammerRepository.save(scammer);
    }

    @Override
    public List<Scammer> getAllScammer() {
        return scammerRepository.findAll();
    }

    @Override
    public Scammer getScammerById(String id) {
        Optional<Scammer> scammer = scammerRepository.findById(id);
        if (scammer.isPresent()) {
            return scammer.get();
        } else {
            throw new RuntimeException();
        }
    }

    @Override
    public Scammer updateScammer(Scammer scammer, String id) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("Id không được để trống");
        }
        Scammer existedScammer = scammerRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Không tìm thấy scammer với id: " + id)
        );
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

        scammerRepository.save(existedScammer);
        return existedScammer;
    }

    @Override
    public void deleteScammer(String id) {
        scammerRepository.findById(id).orElseThrow(
                RuntimeException::new
        );
        scammerRepository.deleteById(id);
    }
}
