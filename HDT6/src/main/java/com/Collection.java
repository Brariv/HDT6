import java.util.Map;

public class Collection {
    private Map<String, Integer> cardCounts;
    private Map<String, String> cardTypes;

    public Collection(Map<String, String> cards, Map<String, String> types) {
        cardCounts = new HashMap<>();
        cardTypes = types; 
        for (Map.Entry<String, String> entry : cards.entrySet()) {
            addCard(entry.getKey());
        }
    }

    public void addCard(String cardName) {
     
        if (cardCounts.containsKey(cardName)) {
           
            int currentCount = cardCounts.get(cardName);
            cardCounts.put(cardName, currentCount + 1);
        } else {
           
            cardCounts.put(cardName, 1);
        }
    }

    public int getCount(String cardName) {
    
        return cardCounts.getOrDefault(cardName, 0);
    }

    public void printCollection() {
    
        System.out.println("Colección de cartas:");
        for (Map.Entry<String, Integer> entry : cardCounts.entrySet()) {
            String cardName = entry.getKey();
            int count = entry.getValue();
            String cardType = getType(cardName); 
            System.out.println(cardName + " (" + cardType + "): " + count + " copias");
        }
    }

    private String getType(String cardName) {
    
        return cardTypes.getOrDefault(cardName, "Desconocido");
    }

    public void removeCard(String cardName) {
       
        if (cardCounts.containsKey(cardName)) {
            int currentCount = cardCounts.get(cardName);
            if (currentCount == 1) {
                cardCounts.remove(cardName);
            } else {
                cardCounts.put(cardName, currentCount - 1);
            }
        }
    }

    public void removeAllCopies(String cardName) {
        cardCounts.remove(cardName);
    }

    public void clear() {
        cardCounts.clear();
    }
}
