import java.util.*;

public class Post {
    String user, content;
    Set<String> tags = new HashSet<>();
    Set<String> likes = new HashSet<>();
    List<Map<String, String>> comments = new ArrayList<>();
    Set<String> shares = new HashSet<>();

    public Post(String content, String user) {
        this.content = content;
        this.user = user;
    }

    public void like(String name) {
        likes.add(name);
    }

    public void comment(String name, String comment) {
        Map<String, String> cmnt = new HashMap<>();
        cmnt.put(name, comment);
        comments.add(cmnt);
    }

    public void display(String name) {
        System.out.println("\n\t" + user + "\n\t" + content);
        System.out.println("\t1. Like " + likes.size() + "\t2. Comment " + comments.size() + "\t3. Share " + shares.size());

        for (Map<String, String> cmnt : comments) {
            for (Map.Entry<String, String> entry : cmnt.entrySet()) {
                System.out.println("\t" + entry.getKey() + "\t" + entry.getValue());
            }
        }
    }
}
