package java_backend.check_scammer.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id; // duy nhat, khoa chinh
import org.springframework.data.mongodb.core.mapping.Document; //lop nay la 1 document trong mongodb

@Data //chú thích giúp tự động tạo getter, setter, toString, hashCode, equals cho các lớp => giảm thiểu code
@AllArgsConstructor //tự động tạo ra constructor với tham số các field trong lớp
@NoArgsConstructor //tạo constructor ko tham số cho class
@Document(collection = "scammers")
public class Scammer {
    @Id //khoa chinh trong mongo
    private String id;
    private String nameScammer;
    private String phoneScammer;
    private String bankNumber;
    private String bankName;
    private String contentReport;
    private String nameSender;
    private String phoneSender;
    private String option;
    private String[] images;
}
