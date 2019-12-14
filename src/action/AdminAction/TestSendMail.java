package action.AdminAction;

import Service.SendMailService.SendMailService;
import org.springframework.stereotype.Controller;
import java.text.SimpleDateFormat;

import java.util.Date;

@Controller
public class TestSendMail {

    public TestSendMail() {
    }

    public SendMailService getSendMailService() {
        return sendMailService;
    }

    public void setSendMailService(SendMailService sendMailService) {
        this.sendMailService = sendMailService;
    }


     SendMailService sendMailService = new SendMailService();

    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    String date = simpleDateFormat.format(new Date());

    public void test(){
        String recipient = "a16626583775@163.com";  //收件人地址
        String subject = "这是一封新的邮件";   //邮件标题
        String content = "测试"+date;   //邮件内容

        sendMailService.sendEmail(recipient,subject,content);    //发送邮件

    }

}
