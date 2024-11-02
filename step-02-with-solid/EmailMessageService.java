import java.util.regex.Pattern;

public class EmailMessageService implements MessageService<EmailMessage> {
    @Override
    public void sendMessage(EmailMessage emailMessage) {
        if (validateEmailAddress(emailMessage.getSourceEmailAddress()) &&
            validateEmailAddress(emailMessage.getTargetEmailAddress())) {
            System.out.println("Sending an email from " + emailMessage.getSourceEmailAddress() + 
                               " to " + emailMessage.getTargetEmailAddress() +
                               " with content: " + emailMessage.getContent());
        } else {
            throw new IllegalArgumentException("Email Address is not correct!");
        }
    }

    private boolean validateEmailAddress(String email) {
        String emailRegex = "^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$";
        Pattern pattern = Pattern.compile(emailRegex);
        return pattern.matcher(email).matches();
    }
}
