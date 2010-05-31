import org.apache.jackrabbit.core.TransientRepository;
import javax.jcr.*;

// Description: Delete node
public class SixthHop {
    public static void main(String[] args) throws RepositoryException {
        Repository repository = new TransientRepository();
        Session session = repository.login(new SimpleCredentials("username", "password".toCharArray()));

        try {
            Node root = session.getRootNode();

            // Remove content
            root.getNode("hello").remove();
            session.save();

        } finally {
            session.logout();
        }

    }
}

