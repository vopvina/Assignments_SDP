package Observer;

public interface NewsPublisher {
    void subscribe(Observer observer);
    void unsubscribe(Observer observer);
    void publishNews(String category, String news);
}
