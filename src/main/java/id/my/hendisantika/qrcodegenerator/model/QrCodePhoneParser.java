package id.my.hendisantika.qrcodegenerator.model;

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
public class QrCodePhoneParser extends AbstractQrCodeParser {

    private final QrCodePhone qrCodePhone;

    public QrCodePhoneParser(QrCodePhone qrCodePhone) {
        this.qrCodePhone = qrCodePhone;
    }

    @Override
    public String parse() {
        return "tel:" + this.qrCodePhone.getPhoneToBeEncoded();
    }
}
