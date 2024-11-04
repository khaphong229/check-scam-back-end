package java_backend.check_scammer.Service;

import java_backend.check_scammer.Model.Scammer;

import java.util.List;

public interface ScammerService {
    Scammer saveScammer(Scammer scammer);

    List<Scammer> getAllScammer();

    Scammer getScammerById(String id);

    Scammer updateScammer(Scammer scammer, String id);

    void deleteScammer(String id);
}
