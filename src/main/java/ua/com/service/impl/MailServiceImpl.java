package ua.com.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import ua.com.entity.Product;
import ua.com.entity.User;
import ua.com.service.MailService;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

@Service
public class MailServiceImpl implements MailService{

    @Autowired
    JavaMailSender javaMailSender;

    public void send(User user, Product product) {
        MimeMessage mimeMessage=javaMailSender.createMimeMessage();
        MimeMessageHelper helper=new MimeMessageHelper(mimeMessage);
        try {
            mimeMessage.setFrom(new InternetAddress("jktujktu9898@gmail.com"));
            helper.setTo(user.getEmail());
            helper.setText("Hello "+user.getFirstname()+" "+user.getLastname()+"!<br>"+
                    "You bought "+product.getProductname()+", price = "+product.getPrice()+" $",true);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        javaMailSender.send(mimeMessage);
    }
}
