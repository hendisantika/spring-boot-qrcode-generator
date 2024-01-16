package id.my.hendisantika.qrcodegenerator.model;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-qrcode-generator
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 1/16/24
 * Time: 07:55
 * To change this template use File | Settings | File Templates.
 */
@Getter
@Setter
public class QrCodeProcessingResult {
    private String image;
    private String encodedText;
    private String successMessage;
    private String errorMessage;

    public boolean isSuccessfull() {
        return successMessage != null;
    }
}
