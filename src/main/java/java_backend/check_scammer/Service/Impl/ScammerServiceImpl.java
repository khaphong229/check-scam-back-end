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
        Scammer existedScammer = scammerRepository.findById(id).orElseThrow(
                RuntimeException::new
        );
//        existedScammer.setNameScammer(scammer.getNameScammer());
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
