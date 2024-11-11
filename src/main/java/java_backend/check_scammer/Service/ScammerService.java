package java_backend.check_scammer.Service;

import java_backend.check_scammer.Model.ResponseObject;
import java_backend.check_scammer.Model.Scammer;

import java.util.List;

public interface ScammerService {
    ResponseObject saveScammer(Scammer scammer);

    ResponseObject getAllScammer();

    ResponseObject getScammerById(String id);

    ResponseObject updateScammer(Scammer scammer, String id);

    ResponseObject deleteScammer(String id);
}
