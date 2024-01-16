package id.my.hendisantika.qrcodegenerator.model;

import org.apache.commons.lang3.StringUtils;

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
public class QrCodeEmailParser extends AbstractQrCodeParser {

    private final QrCodeEmail qrCodeEmail;

    public QrCodeEmailParser(QrCodeEmail qrCodeEmail) {
        this.qrCodeEmail = qrCodeEmail;
    }

    @Override
    public String parse() {
        StringBuilder buffer = new StringBuilder("mailto:");
        buffer.append(this.qrCodeEmail.getEmailToBeEncoded());
        if (StringUtils.isNotEmpty(this.qrCodeEmail.getSubjectToBeEncoded())) {
            buffer.append("?subject=");
            buffer.append(StringUtils.replace(this.qrCodeEmail.getSubjectToBeEncoded(), " ", "%20"));
        }
        return buffer.toString();
    }
}
