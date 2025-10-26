package code.tiendung.ui;

import code.tiendung.core.Observer;

import java.util.ArrayDeque;
import java.util.Deque;

public final class Dashboard implements Observer {
    private final Deque<String> logs = new ArrayDeque<>();

    @Override
    public void update(String status) {
        if (logs.size() >= 12) logs.removeFirst();
        logs.addLast(status);
        display();
    }

    public void display() {
        System.out.println("=== Dashboard ===");
        for (String s : logs) System.out.println("• " + s);
        System.out.println("=================\n");
    }
}
