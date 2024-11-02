import java.util.regex.Pattern;

public class TelegramMessageService implements MessageService<TelegramMessage> {
    @Override
    public void sendMessage(TelegramMessage telegramMessage) {
        if (validateID(telegramMessage.getSourceID()) &&
            validateID(telegramMessage.getTargetID())) {
            System.out.println("Sending a telegram message from " + telegramMessage.getSourceID() +
                               " to " + telegramMessage.getTargetID() +
                               " with content: " + telegramMessage.getContent());
        } else {
            throw new IllegalArgumentException("Telegram ID is not correct!");
        }
    }

    private boolean validateID(String id) {
        String idRegex = "\\w{4,}$";
        Pattern pattern = Pattern.compile(idRegex);
        return pattern.matcher(id).matches();
    }
}
