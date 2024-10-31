public class TelegramMessageService implements MessageService {
    @Override
    public void sendSmsMessage(SmsMessage smsMessage) {
        //Empty Body
    }

    @Override
    public void sendEmailMessage(EmailMessage emailMessage) {
        //Empty Body
    }

    @Override
    public void sendTelegramMessage(TelegramMessage telegramMessage) {
        if(validateID(telegramMessage.getSourceID()) && validateID(telegramMessage.getTargetID())){
            System.out.println("Sending a telegram message from" + telegramMessage.getSourceID() + " to " + telegramMessage.getTargetID() + " with content : " + telegramMessage.getContent());
        }else{
            throw new IllegalArgumentException("Telegram ID is not correct!");
        }
    }

    public boolean validateID(String id) {
        // Regular expression pattern for validating ID
        String idRegex = "\w{4,}$";

        // Compile the pattern into a regex Pattern object
        Pattern pattern = Pattern.compile(idRegex);

        // Check if the email string matches the regex pattern
        return pattern.matcher(id).matches();
    }
}
