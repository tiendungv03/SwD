package tiendung.codelab4.core;

import tiendung.codelab4.model.*;

public class BBCAgency extends NewsAgency {
    @Override
    protected News createNews(String type) {
        switch (type.toLowerCase()) {
            case "politics": return new PoliticsNews("[BBC] Parliament debate", "New bill enters second reading.");
            case "sports"  : return new SportsNews("[BBC] Derby day", "Late goal seals the win.");
            case "tech"    : return new TechNews("[BBC] Quantum leap", "Start-up unveils new chip.");
            default: return null;
        }
    }
}

