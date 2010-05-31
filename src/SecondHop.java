import org.apache.jackrabbit.core.TransientRepository;

import javax.jcr.*;

// Description: Adds a node and prints out its content
public class SecondHop {
    public static void main(String[] args) throws RepositoryException {
        Repository repository = new TransientRepository();
        Session session = repository.login(new SimpleCredentials("username", "password".toCharArray()));

        try {
            Node root = session.getRootNode();

            // Store content
//            Node hello = root.addNode("hello");
//            Node world = hello.addNode("world");
//            world.setProperty("message", "Hello, World!");
//            session.save();

            // Retrieve content
            Node node = root.getNode("hello/world");
            System.out.println(node.getPath());
            System.out.println(node.getProperty("message").getString());

            // Remove content
//            root.getNode("hello").remove();
//            session.save();

        } finally {
            session.logout();
        }

    }
}
