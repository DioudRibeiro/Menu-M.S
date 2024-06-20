package menumiragem;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private List<Item> pastels;
    private List<Item> bebidas;
    private List<Item> caipirinhas;
    private List<Item> aperitivos;
    private List<Item> cervejas;

    public Menu() {
        pastels = new ArrayList<>();
        bebidas = new ArrayList<>();
        caipirinhas = new ArrayList<>();
        aperitivos = new ArrayList<>();
        cervejas = new ArrayList<>();
        initializeMenu();
    }

    private void initializeMenu() {
        // Inicializa pastéis
        pastels.add(new Item("Pastel de Frango", 15.00));
        pastels.add(new Item("Pastel de Carne", 16.00));
        pastels.add(new Item("Pastel de Queijo", 20.00));
        pastels.add(new Item("Pastel de Carne e queijo", 20.00));
        pastels.add(new Item("Pastel de Calabresa", 20.00));
        pastels.add(new Item("Pastel de Camarão", 18.00));
        pastels.add(new Item("Pastel de Pizza", 18.00));
        pastels.add(new Item("Pastel de Bacon", 20.00));
        pastels.add(new Item("Pastel de Frango / catupiry", 18.00));

        // Inicializa bebidas
        bebidas.add(new Item("Suco de maracuja", 7.00));
        bebidas.add(new Item("Suco de uva", 7.00));
        bebidas.add(new Item("Suco de abacaxi", 7.00));
        bebidas.add(new Item("Suco de Limão", 7.00));
        bebidas.add(new Item("Suco de Caju", 7.00));
        bebidas.add(new Item("Suco de Laranja", 7.00));
        bebidas.add(new Item("Suco de Maçã", 7.00));
        bebidas.add(new Item("Suco de Morango", 7.00));
        bebidas.add(new Item("Suco de Graviola", 7.00));

        // Inicializa caipirinhas
        caipirinhas.add(new Item("Caipirinha de Limão", 12.00));
        caipirinhas.add(new Item("Caipirinha de Morango", 12.00));
        caipirinhas.add(new Item("Caipirinha de Kiwi", 12.00));
        caipirinhas.add(new Item("Caipirinha de Abacaxi", 12.00));
        caipirinhas.add(new Item("Caipirinha de Uva", 12.00));
        caipirinhas.add(new Item("Caipirinha de Caju", 12.00));
        caipirinhas.add(new Item("Caipirinha de Laranja", 12.00));
        caipirinhas.add(new Item("Caipirinha de Maracuja", 12.00));
        caipirinhas.add(new Item("Caipirinha de Graviola", 12.00));

        // Inicializa aperitivos
        aperitivos.add(new Item("Porção de Lula", 60.00));
        aperitivos.add(new Item("Isca de Peixe (Melusa)", 120.00));
        aperitivos.add(new Item("Porção de Batata Frita", 80.00));
        aperitivos.add(new Item("Porção de Calabresa", 70.00));
        aperitivos.add(new Item("Porção de camarão", 120.00));
        aperitivos.add(new Item("Porção de cebola", 60.00));
        aperitivos.add(new Item("Porção de porquinho", 70.00));
        aperitivos.add(new Item("Porção de frango a passarinho", 120.00));
        aperitivos.add(new Item("Porção de fritas c/ Bacon, queijo, cheddar", 100.00));

        // Inicializa cervejas
        cervejas.add(new Item("Brahma", 7.00));
        cervejas.add(new Item("Duplo Malte", 7.00));
        cervejas.add(new Item("Skol", 8.00));
        cervejas.add(new Item("Heineken", 10.00));
        cervejas.add(new Item("Budweiser", 10.00));
    }

    public List<Item> getPastels() {
        return pastels;
    }

    public List<Item> getBebidas() {
        return bebidas;
    }

    public List<Item> getCaipirinhas() {
        return caipirinhas;
    }

    public List<Item> getAperitivos() {
        return aperitivos;
    }

    public List<Item> getCervejas() {
        return cervejas;
    }
}
