// Импорт файлов из папок
import Observer.NewsPublisherImpl;
import Observer.NewsSubscriberSmartphone;
import Observer.NewsSubscriberLaptop;
import Observer.NewsSubscriberTablet;

import State.Player;

import Strategy.Order;
import Strategy.CardPaymentStrategy;
import Strategy.WalletPaymentStrategy;
import Strategy.CashOnDeliveryStrategy;

import TemplateMethod.QualityCheck;
import TemplateMethod.FoodQualityCheck;
import TemplateMethod.ElectronicsQualityCheck;

import Visitor.File;
import Visitor.TextFile;
import Visitor.ExecutableFile;
import Visitor.Visitor;
import Visitor.AntivirusVisitor;
import Visitor.ReportVisitor;

// Общий Main для всех задач
public class Main {
    public static void main(String[] args) {
        // 1 задача
        System.out.println("Паттерн Наблюдатель/Observer");
        NewsPublisherImpl newsPublisher = new NewsPublisherImpl();

        // Создание подписчиков
        NewsSubscriberSmartphone smartphoneSubscriber = new NewsSubscriberSmartphone();
        NewsSubscriberLaptop laptopSubscriber = new NewsSubscriberLaptop();
        NewsSubscriberTablet tabletSubscriber = new NewsSubscriberTablet();

        // Подписка наблюдателей на издателя новостей
        newsPublisher.subscribe(smartphoneSubscriber);
        newsPublisher.subscribe(laptopSubscriber);
        newsPublisher.subscribe(tabletSubscriber);

        // Публикация новостей в разных категориях
        newsPublisher.publishNews("Спорт", "Новая статья о спорте.");
        newsPublisher.publishNews("Наука", "Новая статья о науке.");
        newsPublisher.publishNews("Политика", "Новая статья о политике.");

        // 2 задача
        System.out.println("\nПаттерн Состояние/State");
        Player player = new Player();

        // Демонстрация переключения между состояниями плеера
        player.play(); // Воспроизведение
        player.pause(); // Пауза
        player.stop(); // Остановка
        player.play(); // Воспроизведение с начала

        // 3 задача
        System.out.println("\nПаттерн Стратегия/Strategy");
        Order order = new Order(1000);

        // Оплата картой (комиссия 2%)
        order.setPaymentStrategy(new CardPaymentStrategy());
        System.out.println("Оплата картой: " + order.calculateFinalCost() + " рублей");

        // Оплата электронным кошельком (без комиссии)
        order.setPaymentStrategy(new WalletPaymentStrategy());
        System.out.println("Оплата электронным кошельком: " + order.calculateFinalCost() + " рублей");

        // Оплата наличным платежом (доплата 300 рублей)
        order.setPaymentStrategy(new CashOnDeliveryStrategy());
        System.out.println("Оплата наличным платежом: " + order.calculateFinalCost() + " рублей");

        // 4 задача
        System.out.println("\nПаттерн Шаблонный метод/Template Method");
        QualityCheck foodQualityCheck = new FoodQualityCheck();
        QualityCheck electronicsQualityCheck = new ElectronicsQualityCheck();

        // Проверка качества продуктов
        foodQualityCheck.checkQuality();
        electronicsQualityCheck.checkQuality();

        // 5 задача
        System.out.println("\nПаттерн Посетитель/Visitor");
        File textFile = new TextFile("document.txt");
        File executableFile = new ExecutableFile("program.exe");

        // Создание посетителей: антивирусного сканера и генератора отчета
        Visitor antivirusVisitor = new AntivirusVisitor();
        Visitor reportVisitor = new ReportVisitor();

        // Проверка антивирусом текстового и исполняемого файлов
        textFile.accept(antivirusVisitor);
        executableFile.accept(antivirusVisitor);

        // Генерация отчета о проверке файлов
        textFile.accept(reportVisitor);
        executableFile.accept(reportVisitor);
    }
}
