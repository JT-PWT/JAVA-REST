import java.util.ArrayList;
import java.util.List;

public class UserService {
    private List<User> users = new ArrayList<>();

    // Criar usuário
    public void createUser(User user) {
        // Verifico se já existe usuário com o mesmo ID
        for (User existinUser : users){
            if (existinUser.getId() == user.getId()){
                System.out.println("Erro: Usuário com ID" + user.getId() + " já existe.");
                return;
            }
        }

        users.add(user);
        System.out.println("Usuário criado:" + user.toJson());

    }

    public void getUsersByName(String name){
        List<User> foundUsers = new ArrayList<>();
        for ( User user : users){
            if(user.getName().equalsIgnoreCase(name)){
                foundUsers.add(user);
            }
        }
        if(foundUsers.isEmpty()){
            System.out.println("Nenhum usuário encontrado com o nome: " + name);
        } else {
            System.out.println("Usuários encontrados: ");
            for (User user : foundUsers){
                System.out.println(user.toJson());
            }
        }
    }
    // Ler todos os usuários
        public void getAllUsers() {
        System.out.println("Lista de usuários: ");
        for (User user : users) {
            System.out.println(user.toJson());
        }
    }

    // Atualizar todos os usuários
    public void updateUser(int id, User updateUser) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId() == id) {
                users.set(i, updateUser);
                System.out.println("Usuário atualizado: " + updateUser.toJson());
            }
        }
        System.out.println("Usuário com ID" + id + "não encontrado.");
    }

    // Deletar usuário
    public void deleteUser(int id) {
        users.removeIf(user -> user.getId() == id);
        System.out.println("Usuário com ID: " + id + " removido.");
    }
}