package tiendung.codelab4.adapter;

import java.util.HashMap;
import java.util.Map;

/** Giả lập nguồn JSON của bên thứ ba */
public class JSONNewsFeed {
    public Map<String,String> fetchJSONNews() {
        Map<String,String> m = new HashMap<>();
        m.put("type", "tech");
        m.put("title", "External feed: AI release");
        m.put("content", "Third-party JSON provider content.");
        return m;
    }
}
