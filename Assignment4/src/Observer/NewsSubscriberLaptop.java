package Observer;

public class NewsSubscriberLaptop implements Observer {
    @Override
    public void update(String category, String news) {
        if ("Наука".equalsIgnoreCase(category)) {
            System.out.println("На ноутбук: Новость в категории 'Наука' - " + news);
        }
    }
}
