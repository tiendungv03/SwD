package tiendung.codelab4.core;

import tiendung.codelab4.model.News;
import tiendung.codelab4.observer.Observer;

public class Subscriber implements Observer {
    private final String name;

    public Subscriber(String name) { this.name = name; }

    @Override
    public void update(News news) {
        System.out.println("📩 " + name + " received: " + news.getTitle());
    }
}
