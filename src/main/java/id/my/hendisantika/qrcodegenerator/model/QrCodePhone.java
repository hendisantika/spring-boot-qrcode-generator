package id.my.hendisantika.qrcodegenerator.model;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-qrcode-generator
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 1/16/24
 * Time: 07:54
 * To change this template use File | Settings | File Templates.
 */

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

/**
 * Form:
 * <p>
 * tel:+12125551212
 */
@Getter
@Setter
@Validated
public class QrCodePhone {

    @NotEmpty
    private String phoneToBeEncoded;

    public QrCodePhone() {
    }

    public QrCodePhone(String phoneToBeEncoded) {
        this.phoneToBeEncoded = phoneToBeEncoded;
    }
}
