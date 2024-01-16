package id.my.hendisantika.qrcodegenerator.model;

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

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

/**
 * Format: http://google.de
 */
@Getter
@Setter
@Validated
public class QrCodeUrl {

    @NotEmpty
    private String urlToBeEncoded;

    public QrCodeUrl() {
    }

    public QrCodeUrl(String urlToBeEncoded) {
        this.urlToBeEncoded = urlToBeEncoded;
    }
}
