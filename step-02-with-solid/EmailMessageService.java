public class SmsMessageService implements MessageService<SmsMessage> {
    @Override
    public void sendMessage(SmsMessage smsMessage) {
        if (validatePhoneNumber(smsMessage.getSourcePhoneNumber()) &&
            validatePhoneNumber(smsMessage.getTargetPhoneNumber())) {
            System.out.println("Sending a SMS from " + smsMessage.getSourcePhoneNumber() +
                               " to " + smsMessage.getTargetPhoneNumber() +
                               " with content: " + smsMessage.getContent());
        } else {
            throw new IllegalArgumentException("Phone Number is not correct!");
        }
    }

    private boolean validatePhoneNumber(String phoneNumber) {
        if (phoneNumber.length() != 11) {
            return false;
        }
        for (char digit : phoneNumber.toCharArray()) {
            if (!Character.isDigit(digit)) {
                return false;
            }
        }
        return true;
    }
}
