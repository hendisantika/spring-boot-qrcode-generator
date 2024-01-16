package id.my.hendisantika.qrcodegenerator.model;

import java.time.format.DateTimeFormatter;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-qrcode-generator
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 1/16/24
 * Time: 07:53
 * To change this template use File | Settings | File Templates.
 */
public class QrCodeEventParser extends AbstractQrCodeParser {
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyyMMdd'T'HHmmss");

    private final QrCodeEvent qrCodeEvent;

    public QrCodeEventParser(QrCodeEvent qrCodeEvent) {
        this.qrCodeEvent = qrCodeEvent;
    }

    @Override
    public String parse() {
        String start = DATE_FORMATTER.format(qrCodeEvent.getEventStart());
        String end = DATE_FORMATTER.format(qrCodeEvent.getEventEnd());

        String eventText = "BEGIN:VCALENDAR\n"
                + "BEGIN:VEVENT\n"
                + "SUMMARY:" + qrCodeEvent.getSummary().replace('\n', ' ') + "\n"
                + "DTSTART;TZID=Europe/Berlin;VALUE=DATE-TIME:" + start + "\n"
                + "DTEND;TZID=Europe/Berlin;VALUE=DATE-TIME:" + end + "\n"
                + "LOCATION:" + qrCodeEvent.getLocation() + "\n"
                + "END:VEVENT\n"
                + "END:VCALENDAR";

        return eventText;
    }
}
