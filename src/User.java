import java.util.*;

public class User {

    String username, password;
    Set<String> followers = new HashSet<>();
    Set<String> following = new HashSet<>();
    List<Post> posts = new ArrayList<>();
    List<Post> feed = new ArrayList<>();

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void createPost(String content) {
        Post newPost = new Post(content, username);
        posts.add(newPost);
        feed.add(newPost);
    }

    public void displayFeed() {
        System.out.println("=================================");
        for (Post p : feed) {
            p.display(username);
        }
        System.out.println("No More Posts");
        System.out.println("=================================");
    }

    public void follow(User other) {
        if (!this.username.equals(other.username)) {
            following.add(other.username);
            other.followers.add(this.username);
        } else {
            System.out.println("Invalid Choice");
        }
    }

    public void login() {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n1. View Following  2. View Followers  3. Follow User  4. Post  5. View Feed  6. Logout");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("Following: " + following);
                    break;
                case 2:
                    System.out.println("Followers: " + followers);
                    break;
                case 3:
                    System.out.println("Enter username to follow: ");
                    String toFollow = sc.nextLine();
                    for (User u : Main.users) {
                        if (u.username.equals(toFollow)) {
                            follow(u);
                            break;
                        }
                    }
                    break;
                case 4:
                    System.out.println("Write your post:");
                    String postContent = sc.nextLine();
                    createPost(postContent);
                    break;
                case 5:
                    displayFeed();
                    break;
            }
        } while (choice != 6);
    }
}
