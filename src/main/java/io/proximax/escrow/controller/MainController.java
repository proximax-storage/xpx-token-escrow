package io.proximax.escrow.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMethod;

import io.proximax.escrow.form.ExchangeForm;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import org.springframework.ui.Model;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import io.proximax.escrow.document.Escrow;
import org.apache.tomcat.util.codec.binary.Base64;
import io.proximax.escrow.repository.EscrowRepository;
import io.proximax.escrow.repository.EscrowRepositoryCustom;
import io.proximax.escrow.util.EscrowBuilder;

@Controller
public class MainController {

    @Autowired
    EscrowRepositoryCustom escrowRepositoryCustom;
    @Autowired
    EscrowRepository escrowRepository;
    @Autowired
    private EmailService emailService;
    private static String qrcodeImage;

    //@ResponseBody
    @RequestMapping("/")
    public String home() {
        return "exchange.html";
    }

    @RequestMapping("/exchangeForm")
    public String registerForm() {
        //return "register.html";
        return "exchange.html";
    }

    @RequestMapping(value = {"/submitExchange"}, method = RequestMethod.POST)
    public String submitRegister(@ModelAttribute ExchangeForm form, Model model) {
        String html = "";
        Escrow row = new EscrowBuilder()
                .addEmail(form.getEmail())
                .addFullName(form.getFullName())
                .addXPXAddress(form.getXpxAddress())
                .addXPXAmount(form.getXpxAmount())
                .addTokenName(form.getTokenName())                
                .addMaxId(escrowRepositoryCustom.findMaxId())
                .build();
        try {
            escrowRepository.insert(row);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        html = "\n\n Dear " + row.getFullName() + ",";
        html += "\n Please pay: " + String.format("%f",row.getTokenAmount()) + " " + row.getTokenName() + " to address: " + row.getTokenAddress()
                + " for trading " + String.format("%f", row.getXpxAmount()) + " xpx"
                + " with message content is trading code: " + row.getTradingCode();
        html += "\n Trading Code will be expired 30 minutes";
        System.out.println(html);
        try {
            String qrcodeImage = getQRCodeImage(html, 300, 300);
            System.out.println(qrcodeImage);
            model.addAttribute("qrcodeImage", qrcodeImage);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "submitExchange.html";

    }

    private String getQRCodeImage(String text, int width, int height) throws WriterException, IOException {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height);

        ByteArrayOutputStream pngOutputStream = new ByteArrayOutputStream();
        MatrixToImageWriter.writeToStream(bitMatrix, "PNG", pngOutputStream);
        byte[] pngData = pngOutputStream.toByteArray();
        String encodedfile = "data:image/png;base64," + Base64.encodeBase64String(pngData);
        return encodedfile;
    }
}
