package Observer;

public class NewsSubscriberTablet implements Observer {
    @Override
    public void update(String category, String news) {
        System.out.println("На планшет: Новость - " + news);
    }
}
