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
 * Time: 07:56
 * To change this template use File | Settings | File Templates.
 */
@Getter
@Setter
@Validated
public class QrCodeSms {

    @NotEmpty
    private String phoneToBeEncoded = "";

    private String messageToBeEncoded = "";

    public QrCodeSms() {
    }

    public QrCodeSms(@NotEmpty String phoneToBeEncoded) {
        this.phoneToBeEncoded = phoneToBeEncoded;
    }

    public QrCodeSms(String phoneToBeEncoded, String messageToBeEncoded) {
        this.phoneToBeEncoded = phoneToBeEncoded;
        this.messageToBeEncoded = messageToBeEncoded;
    }
}
