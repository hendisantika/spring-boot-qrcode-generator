package id.my.hendisantika.qrcodegenerator.model;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-qrcode-generator
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 1/16/24
 * Time: 07:52
 * To change this template use File | Settings | File Templates.
 */
@Getter
@Setter
@Validated
public class QrCodeEmail {

    @NotEmpty
    private String emailToBeEncoded = "";

    private String subjectToBeEncoded = "";

    public QrCodeEmail() {
    }

    public QrCodeEmail(@NotEmpty String emailToBeEncoded) {
        this.emailToBeEncoded = emailToBeEncoded;
    }

    public QrCodeEmail(String emailToBeEncoded, String subjectToBeEncoded) {
        this.emailToBeEncoded = emailToBeEncoded;
        this.subjectToBeEncoded = subjectToBeEncoded;
    }
}
