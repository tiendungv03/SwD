package tiendung.codelab4.core;

import java.util.ArrayList;
import java.util.List;

import tiendung.codelab4.model.News;
import tiendung.codelab4.observer.Observer;
import tiendung.codelab4.observer.Subject;

public abstract class NewsAgency implements Subject {
    private final List<Observer> observers = new ArrayList<>();
    protected News lastNews;

    @Override
    public void attach(Observer o) { observers.add(o); }

    @Override
    public void detach(Observer o) { observers.remove(o); }

    @Override
    public void notifyObservers() {
        for (Observer o : observers) o.update(lastNews);
    }


    public void publishNews(String type) {
        lastNews = createNews(type);
        if (lastNews == null) throw new IllegalArgumentException("Unsupported type: " + type);
        lastNews.display();
        notifyObservers();
    }

    // Factory Method
    protected abstract News createNews(String type);
}
