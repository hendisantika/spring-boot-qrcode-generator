package id.my.hendisantika.qrcodegenerator.model;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-qrcode-generator
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 1/16/24
 * Time: 07:57
 * To change this template use File | Settings | File Templates.
 */
public class QrCodeUrlParser extends AbstractQrCodeParser {

    private final QrCodeUrl qrCodeUrl;

    public QrCodeUrlParser(QrCodeUrl qrCodeUrl) {
        this.qrCodeUrl = qrCodeUrl;
    }

    @Override
    public String parse() {
        return StringUtils.replace(this.qrCodeUrl.getUrlToBeEncoded(), " ", "%20");
    }
}
