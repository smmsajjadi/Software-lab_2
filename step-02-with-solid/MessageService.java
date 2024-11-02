public interface MessageService<T extends Message> {
    void sendMessage(T message);
}
