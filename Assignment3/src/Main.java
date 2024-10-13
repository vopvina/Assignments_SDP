import java.util.Arrays;
import java.util.List;

import Chain.PaymentA;
import Chain.PaymentB;
import Chain.PaymentC;
import Chain.PaymentHandler;

import Command.NextChannelCommand;
import Command.PreviousChannelCommand;
import Command.RemoteControl;
import Command.Television;
import Command.TurnOffCommand;
import Command.TurnOnCommand;
import Command.VolumeDownCommand;
import Command.VolumeUpCommand;

import Iterator.ArrayMovieCollection;
import Iterator.ListMovieCollection;
import Iterator.Iterator;


import Mediator.HomeMediatorImpl;
import Mediator.Sensor;
import Mediator.TemperatureSensor;
import Mediator.HumiditySensor;
import Mediator.LightSensor;

import Memento.Caretaker;
import Memento.TextEditor;


public class Main {
    public static void main(String[] args) {
        // Chain
        System.out.println("\n Chain");
        PaymentA paymentA = new PaymentA();
        PaymentHandler paymentB = new PaymentB();
        PaymentHandler paymentC = new PaymentC();
        paymentA.setNextHandler(paymentB);
        paymentB.setNextHandler(paymentC);
        paymentA.handlePayment(150);

        // Command
        System.out.println("\n Command");
        Television tv = new Television();
        RemoteControl remote = new RemoteControl();
        remote.setCommand(0, new TurnOnCommand(tv));
        remote.setCommand(1, new TurnOffCommand(tv));
        remote.setCommand(2, new VolumeUpCommand(tv));
        remote.setCommand(3, new VolumeDownCommand(tv));
        remote.setCommand(4, new NextChannelCommand(tv));
        remote.setCommand(5, new PreviousChannelCommand(tv));

        remote.pressButton(0); // Включаем телевизор
        remote.pressButton(2); // Увеличиваем громкость
        remote.pressButton(5); // Переключаем на предыдущий канал
        remote.pressButton(3); // Уменьшаем громкость
        remote.pressButton(4); // Переключаем на следующий канал
        remote.pressButton(1); // Выключаем телевизор

        // iterator
        System.out.println("\n Iterator ");

        // list
        List<String> movieList = Arrays.asList("Оppenheimer", "Iron Man");
        ListMovieCollection listMovieCollection = new ListMovieCollection(movieList);
        Iterator<String> listIterator = listMovieCollection.createIterator();
        while (listIterator.hasNext()) {
            System.out.println("From list: " + listIterator.next());
        }

        // massive
        String[] movieArray = {"The Avengers", "Insidious"};
        ArrayMovieCollection arrayMovieCollection = new ArrayMovieCollection(movieArray);
        Iterator<String> arrayIterator = arrayMovieCollection.createIterator();
        while (arrayIterator.hasNext()) {
            System.out.println("From massive: " + arrayIterator.next());
        }

        // mediator
        System.out.println("\n Mediator");
        HomeMediatorImpl mediator = new HomeMediatorImpl();

        Sensor tempSensor = new TemperatureSensor(mediator);
        Sensor humiditySensor = new HumiditySensor(mediator);
        Sensor lightSensor = new LightSensor(mediator);

        // sending data sensor
        tempSensor.sendData();
        humiditySensor.sendData();
        lightSensor.sendData();

        // report
        mediator.printReport();

        // memento
        System.out.println("\n Memento ");
        TextEditor editor = new TextEditor();
        Caretaker caretaker = new Caretaker();
        editor.addText("Hello, ");
        caretaker.addMemento(editor.save());
        editor.addText("World!");
        System.out.println("Current text: " + editor.getText());
        editor.restore(caretaker.getMemento(0));
        System.out.println("After undo: " + editor.getText());
    }
}