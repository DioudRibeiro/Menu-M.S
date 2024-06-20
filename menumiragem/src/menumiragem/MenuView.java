package menumiragem;

import java.util.List;

public class MenuView {
    public void displayMenu(List<Item> items) {
        for (int i = 0; i < items.size(); i++) {
            System.out.println((i + 1) + ". " + items.get(i).getName() + " ------------- R$" + items.get(i).getPrice());
        }
        System.out.println((items.size() + 1) + ". Proximo");
    }

    public void displayItem(Item item) {
        if (item != null) {
            System.out.println(item.getName() + " ------------- R$" + item.getPrice());
        } else {
            System.out.println("Item não encontrado.");
        }
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }
    
    public void displayHeader(String header) {
        System.out.println("---- " + header + " ----");
    }

    public void displayGuardaSolTotal(int total) {
        System.out.println("A quantidade total de guarda sol é " + total);
    }
}
