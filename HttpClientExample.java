import java.util.Scanner;

public class HttpClientExample {

    public static void main(String[] args) {
        UserService userService = new UserService();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n Escolha uma operação: ");
            System.out.println("1. Criar Usuário");
            System.out.println("2. Listar Usuário");
            System.out.println("3. Atualizar Usuário");
            System.out.println("4. Deletar Usuário");
            System.out.println("5. Sair");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                // Criar usuário
                System.out.print("ID: ");
                int createId = scanner.nextInt();
                System.out.print("Nome: ");
                String createName = scanner.next();
                userService.createUser(new User(createId, createName));
                break;

            case 2: 
                // Listar usuários
                userService.getAllUsers();
                break;
            
            case 3:
                // Atualizar usuário
                System.out.print("ID do usuário a ser atualizado: ");
                int updateId = scanner.nextInt();
                System.out.print("Novo Nome: ");
                String updateName = scanner.next();
                userService.updateUser(updateId, new User(updateId, updateName));
                break;

            case 4:
                // Deletar usuário
                System.out.print("ID do usuário a ser deletado: ");
                int deleteId = scanner.nextInt();
                userService.deleteUser(deleteId);
                break;

            case 5:
                // Sair
                System.out.println("Saindo...");
                scanner.close();
                return;

            default:
                System.out.println("Opção inválida.");

            }

        }
            
    }
}
