import java.util.Scanner;

public class Main {
    public static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Hello and Welcome to SE Lab Messenger.");
        int userAnswer = 0;
        do {
            Message message = null;
            MessageService messageService = null;
            String source;
            String target;
            String content;

            System.out.println("In order to send SMS message enter 1");
            System.out.println("In order to send Email message enter 2");
            System.out.println("In order to send Telegram message enter 3");
            System.out.println("In order to Exit, Enter 0");

            userAnswer = scanner.nextInt();

            if (userAnswer == 0) {
                break;
            }

            switch (userAnswer) {
                case 1:
                    SmsMessage smsMessage = new SmsMessage();
                    System.out.print("Enter source phone: ");
                    source = scanner.next();
                    smsMessage.setSourcePhoneNumber(source);
                    System.out.print("Enter target phone: ");
                    target = scanner.next();
                    smsMessage.setTargetPhoneNumber(target);
                    System.out.println("Write Your Message: ");
                    content = scanner.next(".*$");
                    smsMessage.setContent(content);
                    message = smsMessage;
                    messageService = new SmsMessageService();
                    break;
                case 2:
                    EmailMessage emailMessage = new EmailMessage();
                    System.out.print("Enter source email: ");
                    source = scanner.next();
                    emailMessage.setSourceEmailAddress(source);
                    System.out.print("Enter target email: ");
                    target = scanner.next();
                    emailMessage.setTargetEmailAddress(target);
                    System.out.println("Write Your Message: ");
                    content = scanner.next();
                    emailMessage.setContent(content);
                    message = emailMessage;
                    messageService = new EmailMessageService();
                    break;
                case 3:
                    TelegramMessage telegramMessage = new TelegramMessage();
                    System.out.print("Enter source ID: ");
                    source = scanner.next();
                    telegramMessage.setSourceID(source);
                    System.out.print("Enter target ID: ");
                    target = scanner.next();
                    telegramMessage.setTargetID(target);
                    System.out.print("Write your Message: ");
                    content = scanner.next();
                    telegramMessage.setContent(content);
                    message = telegramMessage;
                    messageService = new TelegramMessageService();
                    break;
            }

            if (message != null && messageService != null) {
                messageService.sendMessage(message);
            }

        } while (true);
    }
}
