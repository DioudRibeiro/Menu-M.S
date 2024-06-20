package menumiragem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuController {
    private Menu model;
    private MenuView view;
    private Scanner scanner;
    private List<User> users;
    private User loggedInUser;
    private Cart cart;

    public MenuController(Menu model, MenuView view) {
        this.model = model;
        this.view = view;
        this.scanner = new Scanner(System.in);
        this.users = new ArrayList<>();
        this.loggedInUser = null;
        this.cart = new Cart();
    }

    public void start() {
        while (true) {
            clearScreen();
            System.out.println("1. Cadastro");
            System.out.println("2. Login");
            System.out.println("3. Sair");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    registerUser();
                    break;
                case 2:
                    if (loginUser()) {
                        displayMenu();
                    }
                    break;
                case 3:
                    view.displayMessage("Saindo...");
                    return;
                default:
                    view.displayMessage("Escolha inválida.");
            }
        }
    }

    private void registerUser() {
        clearScreen();
        System.out.println("---- Cadastro ----");
        System.out.print("Digite o nome de usuário: ");
        String username = scanner.nextLine();
        System.out.print("Digite a senha: ");
        String password = scanner.nextLine();

        for (User user : users) {
            if (user.getUsername().equals(username)) {
                view.displayMessage("Usuário já existe.");
                return;
            }
        }

        users.add(new User(username, password));
        view.displayMessage("Cadastro realizado com sucesso!");
        pause();
    }

    private boolean loginUser() {
        clearScreen();
        System.out.println("---- Login ----");
        System.out.print("Digite o nome de usuário: ");
        String username = scanner.nextLine();
        System.out.print("Digite a senha: ");
        String password = scanner.nextLine();

        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                loggedInUser = user;
                view.displayMessage("Login realizado com sucesso!");
                pause();
                return true;
            }
        }

        view.displayMessage("Nome de usuário ou senha incorretos.");
        pause();
        return false;
    }

    private void displayMenu() {
        int choice;
        do {
            clearScreen();
            view.displayHeader("Menu Principal");
            System.out.println("1. Pastéis");
            System.out.println("2. Bebidas");
            System.out.println("3. Caipirinhas");
            System.out.println("4. Aperitivos");
            System.out.println("5. Cervejas");
            System.out.println("6. Ver Carrinho");
            System.out.println("7. Finalizar Compra");
            System.out.println("8. Contagem de guarda sol");
            System.out.println("9. Sair");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    handleSubMenu(model.getPastels(), "Pastéis");
                    break;
                case 2:
                    handleSubMenu(model.getBebidas(), "Bebidas");
                    break;
                case 3:
                    handleSubMenu(model.getCaipirinhas(), "Caipirinhas");
                    break;
                case 4:
                    handleSubMenu(model.getAperitivos(), "Aperitivos");
                    break;
                case 5:
                    handleSubMenu(model.getCervejas(), "Cervejas");
                    break;
                case 6:
                    viewCart();
                    break;
                case 7:
                    finalizePurchase();
                    break;
                case 8:
                    handleGuardaSol();
                    break;
                case 9:
                    view.displayMessage("Saindo...");
                    break;
                default:
                    view.displayMessage("Escolha inválida.");
            }
        } while (choice != 9);
    }

    private void handleSubMenu(List<Item> items, String header) {
        int choice;
        do {
            clearScreen();
            view.displayHeader(header);
            view.displayMenu(items);
            choice = scanner.nextInt();

            if (choice > 0 && choice <= items.size()) {
                Item selectedItem = items.get(choice - 1);
                cart.addItem(selectedItem);
                view.displayItem(selectedItem);
                view.displayMessage("Item adicionado ao carrinho.");
            } else if (choice == items.size() + 1) {
                break;
            } else {
                view.displayMessage("Escolha inválida.");
            }

        } while (choice != items.size() + 1);
    }

    private void viewCart() {
        clearScreen();
        view.displayHeader("Carrinho de Compras");
        List<Item> cartItems = cart.getItems();
        if (cartItems.isEmpty()) {
            view.displayMessage("Seu carrinho está vazio.");
        } else {
            view.displayMenu(cartItems);
            view.displayMessage("Total: R$" + cart.getTotal());
        }
        pause();
    }

    private void finalizePurchase() {
        clearScreen();
        view.displayHeader("Finalizar Compra");
        List<Item> cartItems = cart.getItems();
        if (cartItems.isEmpty()) {
            view.displayMessage("Seu carrinho está vazio.");
        } else {
            view.displayMenu(cartItems);
            System.out.println("Total: R$" + cart.getTotal());
            System.out.print("Você deseja finalizar a compra? (s/n): ");
            char confirm = scanner.next().charAt(0);
            if (confirm == 's' || confirm == 'S') {
                view.displayMessage("Compra finalizada com sucesso!");
                cart.clear();
            } else {
                view.displayMessage("Compra cancelada.");
            }
        }
        pause();
    }

    private void handleGuardaSol() {
        clearScreen();
        view.displayHeader("Contagem de Guarda Sol");
        System.out.println("Digite a quantidade de guarda sois azuis:");
        int guarda_sol_azul = scanner.nextInt();
        System.out.println("Digite a quantidade de guarda sois brancos:");
        int guarda_sol_branco = scanner.nextInt();
        int total = guarda_sol_azul + guarda_sol_branco;
        view.displayGuardaSolTotal(total);
        pause();
    }

    private void clearScreen() {
        for (int i = 0; i < 50; ++i) System.out.println();
    }

    private void pause() {
        System.out.println("Pressione Enter para continuar...");
        try {
            System.in.read();
        } catch (Exception e) {
        }
    }
}
