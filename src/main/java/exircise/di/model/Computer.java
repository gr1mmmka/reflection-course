package exircise.di.model;

public class Computer {
    private Monitor monitor;
    private Keyboard keyboard;
    private Mouse mouse;

    public Computer(Monitor monitor, Keyboard keyboard, Mouse mouse) {
        this.monitor = monitor;
        this.keyboard = keyboard;
        this.mouse = mouse;
    }

    public void launch() {
        monitor.connect();
        keyboard.connect();
        mouse.connect();

        System.out.println("Computer launched!");
    }
}
