package Observer;

public class NewsSubscriberSmartphone implements Observer {
    @Override
    public void update(String category, String news) {
        if ("Спорт".equalsIgnoreCase(category)) {
            System.out.println("На смартфон: Новость в категории 'Спорт' - " + news);
        }
    }
}
