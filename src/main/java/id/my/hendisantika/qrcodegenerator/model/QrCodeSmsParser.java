package id.my.hendisantika.qrcodegenerator.model;

import org.apache.commons.lang3.StringUtils;

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
public class QrCodeSmsParser extends AbstractQrCodeParser {

    private final QrCodeSms qrCodeSms;

    public QrCodeSmsParser(QrCodeSms qrCodeSms) {
        this.qrCodeSms = qrCodeSms;
    }

    @Override
    public String parse() {
        StringBuilder buffer = new StringBuilder("sms:");
        buffer.append(this.qrCodeSms.getPhoneToBeEncoded());
        if (StringUtils.isNotEmpty(this.qrCodeSms.getMessageToBeEncoded())) {
            buffer.append("?sms_body=");
            buffer.append(StringUtils.replace(this.qrCodeSms.getMessageToBeEncoded(), " ", "%20"));
        }
        return buffer.toString();
    }
}
