package com;
import java.util.HashMap;
import java.util.Map;

public class Collection {
    private Map<String, Integer> cardCounts;
    private Map<String, String> cardTypes;

    public Collection() {
        cardCounts = new HashMap<>();
        cardTypes = new HashMap<>();
    }

    public void addCard(String cardName, String cardType) {
        if (cardCounts.containsKey(cardName)) {
            int currentCount = cardCounts.get(cardName);
            cardCounts.put(cardName, currentCount + 1);
        } else {
            cardCounts.put(cardName, 1);
            cardTypes.put(cardName, cardType); // Agregar el tipo de carta al mapa de tipos
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
                cardTypes.remove(cardName); // También eliminar el tipo de carta
            } else {
                cardCounts.put(cardName, currentCount - 1);
            }
        }
    }

    public void removeAllCopies(String cardName) {
        cardCounts.remove(cardName);
        cardTypes.remove(cardName); // También eliminar el tipo de carta
    }

    public void clear() {
        cardCounts.clear();
        cardTypes.clear(); // Limpiar ambos mapas
    }
}
