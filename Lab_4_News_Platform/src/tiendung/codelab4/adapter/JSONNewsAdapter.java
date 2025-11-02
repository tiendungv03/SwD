package tiendung.codelab4.adapter;

import java.util.Map;

import tiendung.codelab4.core.NewsAgency;
import tiendung.codelab4.model.*;

public class JSONNewsAdapter extends NewsAgency {
    private final JSONNewsFeed feed;

    public JSONNewsAdapter(JSONNewsFeed feed) {
        this.feed = feed;
    }

    // Adapter xuất bản dựa vào dữ liệu JSON: dùng type của feed nếu có,
    // còn phương thức publishNews(type) vẫn cho phép gọi theo UML của bạn.
    @Override
    public void publishNews(String type) {
        // ưu tiên type tham số, nếu rỗng sẽ lấy từ feed
        Map<String,String> m = feed.fetchJSONNews();
        String finalType = (type == null || type.isBlank()) ? m.getOrDefault("type","tech") : type;
        // tạo news theo Factory Method của adapter
        this.lastNews = createNews(finalType);
        if (lastNews == null) throw new IllegalArgumentException("Unsupported type: " + finalType);
        lastNews.display();
        notifyObservers();
    }

    @Override
    protected News createNews(String type) {
        Map<String,String> m = feed.fetchJSONNews();
        String title   = m.getOrDefault("title",   "External News");
        String content = m.getOrDefault("content", "External content.");
        switch (type.toLowerCase()) {
            case "politics": return new PoliticsNews("[EXT] " + title, content);
            case "sports"  : return new SportsNews("[EXT] " + title, content);
            case "tech"    : return new TechNews("[EXT] " + title, content);
            default: return null;
        }
    }
}