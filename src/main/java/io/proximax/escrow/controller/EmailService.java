package io.proximax.escrow.controller;

import io.proximax.escrow.document.Escrow;
import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

/**
 *
 * @author vantran
 */
@Service("mailService")
public class EmailService {

    @Autowired
    private JavaMailSender sender;

    public void sendEmailRegister(Escrow row) throws Exception {
        MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);
        helper.setFrom("ProximaX Product Admin <licensekey@proximax.io>");
        helper.setTo(row.getEmail());
        String body = "\n\n Dear " + row.getFullName() + ",";
        body += "\n Register Code will be expired 24 hours";
        body += "\n\n PROXIMAX PRODUCT ADMINISTRATOR";
        helper.setText(body);
        helper.setSubject("[PROXIMAX] BTC/ETH Exchange");
        sender.send(message);
    }

    public void sendEmailLicense(Escrow row) throws Exception {
        MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);
        helper.setFrom("ProximaX Product Admin <licensekey@proximax.io>");
        helper.setTo(row.getEmail());
        String body = "";
        helper.setText(body);
        helper.setSubject("[PROXIMAX] BTC/ETH Exchange");
        sender.send(message);
    }
}
