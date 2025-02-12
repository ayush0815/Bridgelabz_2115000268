import java.util.*;
// Node representing a User in the Social Media system
class User {
    int userId;
    String name;
    int age;
    List<Integer> friendIds; // List of Friend IDs
    User next;

    public User(int userId, String name, int age) {
        this.userId = userId;
        this.name = name;
        this.age = age;
        this.friendIds = new ArrayList<>();
        this.next = null;
    }
}
// Singly Linked List for Managing Users
class SocialMedia {
    private User head = null;

    // Add a new user
    public void addUser(int userId, String name, int age) {
        User newUser = new User(userId, name, age);
        if (head == null) {
            head = newUser;
        } else {
            User temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newUser;
        }
    }
    // Find a user by User ID
    private User findUser(int userId) {
        User temp = head;
        while (temp != null) {
            if (temp.userId == userId) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }
    // Add a friend connection between two users
    public void addFriend(int userId1, int userId2) {
        User user1 = findUser(userId1);
        User user2 = findUser(userId2);

        if (user1 == null || user2 == null) {
            System.out.println("User not found!");
            return;
        }

        if (!user1.friendIds.contains(userId2)) {
            user1.friendIds.add(userId2);
            user2.friendIds.add(userId1);
            System.out.println("Friend connection added between " + user1.name + " and " + user2.name);
        } else {
            System.out.println("They are already friends.");
        }
    }
    // Remove a friend connection
    public void removeFriend(int userId1, int userId2) {
        User user1 = findUser(userId1);
        User user2 = findUser(userId2);

        if (user1 == null || user2 == null) {
            System.out.println("User not found!");
            return;
        }

        if (user1.friendIds.contains(userId2)) {
            user1.friendIds.remove(Integer.valueOf(userId2));
            user2.friendIds.remove(Integer.valueOf(userId1));
            System.out.println("Friend connection removed between " + user1.name + " and " + user2.name);
        } else {
            System.out.println("They are not friends.");
        }
    }
    // Display all friends of a user
    public void displayFriends(int userId) {
        User user = findUser(userId);
        if (user == null) {
            System.out.println("User not found!");
            return;
        }

        System.out.println(user.name + "'s Friends:");
        for (int friendId : user.friendIds) {
            User friend = findUser(friendId);
            if (friend != null) {
                System.out.println("  - " + friend.name);
            }
        }
    }
    // Find mutual friends between two users
    public void findMutualFriends(int userId1, int userId2) {
        User user1 = findUser(userId1);
        User user2 = findUser(userId2);

        if (user1 == null || user2 == null) {
            System.out.println("User not found!");
            return;
        }

        Set<Integer> mutualFriends = new HashSet<>(user1.friendIds);
        mutualFriends.retainAll(user2.friendIds);

        System.out.println("Mutual Friends between " + user1.name + " and " + user2.name + ":");
        if (mutualFriends.isEmpty()) {
            System.out.println("  - No mutual friends.");
        } else {
            for (int friendId : mutualFriends) {
                User friend = findUser(friendId);
                if (friend != null) {
                    System.out.println("  - " + friend.name);
                }
            }
        }
    }
    // Search for a user by Name or User ID
    public void searchUser(String nameOrId) {
        User temp = head;
        boolean found = false;

        while (temp != null) {
            if (temp.name.equalsIgnoreCase(nameOrId) || String.valueOf(temp.userId).equals(nameOrId)) {
                System.out.println("User Found: " + temp.name + " (ID: " + temp.userId + ", Age: " + temp.age + ")");
                found = true;
            }
            temp = temp.next;
        }

        if (!found) {
            System.out.println("User not found.");
        }
    }
    // Count the number of friends for each user
    public void countFriends() {
        User temp = head;
        System.out.println("\nFriend Counts:");
        while (temp != null) {
            System.out.println(temp.name + " has " + temp.friendIds.size() + " friend(s).");
            temp = temp.next;
        }
    }

    // Display all users
    public void displayUsers() {
        User temp = head;
        System.out.println("\nAll Users:");
        while (temp != null) {
            System.out.println("User ID: " + temp.userId + ", Name: " + temp.name + ", Age: " + temp.age);
            temp = temp.next;
        }
    }
}
public class SocialMediaApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SocialMedia sm = new SocialMedia();
        sm.addUser(1, "Ayush", 23);
        sm.addUser(2, "Vaibhav", 22);
        sm.addUser(3, "Aditya", 27);
        sm.addUser(4, "Aviral", 21);
        sm.addUser(5, "Vikram", 26);

        // Displaying users
        sm.displayUsers();

        // Adding friend connections
        sm.addFriend(1, 2);
        sm.addFriend(1, 3);
        sm.addFriend(2, 4);
        sm.addFriend(3, 5);
        sm.addFriend(4, 5);

        // Displaying friends of a specific user
        sm.displayFriends(1);
        sm.displayFriends(3);

        // Finding mutual friends
        sm.findMutualFriends(1, 3);
        sm.findMutualFriends(2, 4);

        // Searching for a user
        System.out.print("\nEnter a User ID or Name to search: ");
        String searchQuery = scanner.next();
        sm.searchUser(searchQuery);

        // Counting friends for each user
        sm.countFriends();

        // Removing a friend connection
        sm.removeFriend(1, 3);
        sm.displayFriends(1);

        scanner.close();
    }
}
