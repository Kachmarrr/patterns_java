public class Main {
    public static void main(String[] args){
        UserRegistry userRegistry = UserRegistry.getInstance();

        User user1 = new User("Alex", 1);
        User user2 = new User("Tony", 2);

        userRegistry.addUser(user1);
        userRegistry.addUser(user2);

        userRegistry.displayUsera();

        userRegistry.removeUser(1);

        System.out.println("After the removing with ID: 1");
        userRegistry.displayUsera();

    }
}

public class User {
    private String name;
    private int userId;

    public User(String name, int userId) {
        this.name = name;
        this.userId = userId;
    }
    public String getName() {
        return name;
    }

    public int getUserId() {
        return userId;
    }
}

import java.util.HashMap;
import java.util.Map;

public class UserRegistry {
    private static UserRegistry instance;
    private Map<Integer, User> userMap;

    private UserRegistry() {
        userMap = new HashMap<>();
    }
    public static UserRegistry getInstance() {
        if(instance == null){
            instance = new UserRegistry();
        }
        return instance;
    }

    public void addUser(User user) {
        userMap.put(user.getUserId(), user);
    }

    public void removeUser(int userId) {
        userMap.remove(userId);
    }

    public void displayUsera() {
        System.out.println("List of Users: ");
        for (User user : userMap.values()) {
            System.out.println("Name: " + user.getName() + ", ID: " + user.getUserId());
        }
    }
}
