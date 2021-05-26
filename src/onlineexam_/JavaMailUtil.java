package onlineexam_;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class JavaMailUtil {
	public static void sendmail(String recepient,final String myEmail,final String password) throws MessagingException {
		System.out.println("Preparing to send message..");
		Properties p = new Properties();
		p.put("mail.smtp.auth", "true");
		p.put("mail.smtp.starttls.enable", "true");
		p.put("mail.smtp.host", "smtp.gmail.com");
		p.put("mail.smtp.port", "587");
		Session s = Session.getInstance(p, new Authenticator() {
			@Override
			protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(myEmail, password);
			}
		});

		Message m = prepareMessage(s, myEmail, recepient);
		Transport.send(m);
		System.out.println("Message Sent Successfully");
	}

	private static Message prepareMessage(Session s, String sender, String recepient) {
		try {
			Message message = new MimeMessage(s);
			message.setFrom(new InternetAddress(sender));
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
			message.setSubject("Tangu Join JT");
			String htmlCode = "<h1 style=\"color:red\">" + "Odisha Market rae kehi halai paribenhi</h1><br>"
					+ "<h2 style=\"color:green\">pehle istamaal kare phir biswas kare</h2>";
			message.setContent(htmlCode, "text/html");
			return message;
		} catch (Exception e) {
		}
		return null;

	}
}
