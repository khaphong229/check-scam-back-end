package java_backend.check_scammer.Repository;

import org.springframework.data.mongodb.repository.MongoRepository; //interface cung cap phthuc crud voi mongo
import java_backend.check_scammer.Model.Scammer;


public interface ScammerRepository extends MongoRepository<Scammer, String> {
}
