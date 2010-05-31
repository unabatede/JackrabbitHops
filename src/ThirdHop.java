import org.apache.jackrabbit.core.TransientRepository;
import org.apache.jackrabbit.value.BinaryImpl;
import javax.jcr.*;
import java.io.FileInputStream;
import java.io.IOException;

// Description: Adds binary data to node
public class ThirdHop {
    public static void main(String[] args) throws RepositoryException, IOException {
        Repository repository = new TransientRepository();
        Session session = repository.login(new SimpleCredentials("username", "password".toCharArray()));

        try {
            Node root = session.getRootNode();

            FileInputStream fileinputstream = new FileInputStream("/export/home/martin/Desktop/settings.jar");
            Binary bin = new BinaryImpl(fileinputstream);

            fileinputstream.close();

            // Retrieve content
            Node node = root.getNode("hello/world");
            //node.addNode("jcr:content", "nt:resource");
            node.addNode("jcr:data");
            node.setProperty("jcr:data", bin);
            session.save();

        } finally {
            session.logout();
        }

    }
}