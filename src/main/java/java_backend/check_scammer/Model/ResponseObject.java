package java_backend.check_scammer.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseObject {
    private int status;
    private String message;
    private boolean success;
    private Object data;

    public static ResponseObject success(Object data) {
        return new ResponseObject(200, "Success", true, data);
    }

    public static ResponseObject error(String message) {
        return new ResponseObject(400, message, false, null);
    }

    public static ResponseObject notFound(String message) {
        return new ResponseObject(400, message, false, null);
    }

}
