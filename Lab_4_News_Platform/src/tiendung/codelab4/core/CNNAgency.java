package tiendung.codelab4.core;

import tiendung.codelab4.model.*;

public class CNNAgency extends NewsAgency {
    @Override
    protected News createNews(String type) {
        switch (type.toLowerCase()) {
            case "politics": return new PoliticsNews("[CNN] Election update", "Breaking: key state results in.");
            case "sports"  : return new SportsNews("[CNN] Championship final", "Underdogs clinch title.");
            case "tech"    : return new TechNews("[CNN] New AI model", "Beats previous benchmark.");
            default: return null;
        }
    }
}

