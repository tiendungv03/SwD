package tiendung.codelab4;

import tiendung.codelab4.core.*;
import tiendung.codelab4.adapter.*;

public class Demo {
    public static void main(String[] args) {
        // Agencies
        NewsAgency cnn = new CNNAgency();
        NewsAgency bbc = new BBCAgency();
        NewsAgency ext = new JSONNewsAdapter(new JSONNewsFeed()); // adapter nguồn ngoài

        // Subscribers
        var minh  = new Subscriber("Minh");
        var khang = new Subscriber("Khang");
        var lan   = new Subscriber("Lan");
        var dung  = new Subscriber("Dũng");
        var hoa   = new Subscriber("Hoa");

        // Đăng ký theo dõi (attach)
        // CNN: Minh, Khang, Lan
        cnn.attach(minh);
        cnn.attach(khang);
        cnn.attach(lan);

        // BBC: Khang, Dũng, Hoa
        bbc.attach(khang);
        bbc.attach(dung);
        bbc.attach(hoa);

        // EXT (Adapter): Lan, Dũng, Hoa
        ext.attach(lan);
        ext.attach(dung);
        ext.attach(hoa);

        // Xuất bản tin
        cnn.publishNews("politics"); // Minh, Khang, Lan nhận
        bbc.publishNews("sports");   // Khang, Dũng, Hoa nhận
        ext.publishNews("tech");     // Lan, Dũng, Hoa nhận
    }
}

