package co.anilozturk.notificationservice;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

@Service
public class NotificationDistributionService {

    private final JavaMailSender mailSender;

    public NotificationDistributionService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @RabbitListener(queues = "msQueue")
    public void listen(String in) {
        System.out.println("Message read from myQueue : " + in);

        final SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom("source@anilozturk.co");
        mailMessage.setTo("destination@anilozturk.co");
        mailMessage.setSubject("Rabbit Notification");
        mailMessage.setText(in);

        mailSender.send(mailMessage);
    }
}
