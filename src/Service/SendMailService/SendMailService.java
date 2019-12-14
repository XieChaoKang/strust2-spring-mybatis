package Service.SendMailService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@RestController
@RequestMapping("mail")
public class SendMailService implements InterSendMail {


    private JavaMailSender javaMailSender = new JavaMailSenderImpl();

    public void setMailSender(JavaMailSenderImpl mailSender) {
        this.javaMailSender = mailSender;
    }

    @Override
    public void sendEmail(String recipient, String subject, String content) {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage,true,"UTF-8");
            messageHelper.setFrom("a16626583775@163.com");//发件人
            messageHelper.setTo(recipient);
            messageHelper.setSubject(subject);
            messageHelper.setText(content,true);//true代表支持html格式
            javaMailSender.send(mimeMessage);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void sendHtmlEmail(String recipient, String subject, String content) throws Exception {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage,true,"UTF-8");
            messageHelper.setFrom("a16626583775@qq.com");//发件人
            messageHelper.setTo(recipient);
            messageHelper.setSubject(subject);
            messageHelper.setText(content,true);
            mimeMessage.setRecipients(Message.RecipientType.CC,"a16626583775@qq.com");//抄送人
            javaMailSender.send(mimeMessage);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
