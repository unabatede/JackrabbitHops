import org.apache.jackrabbit.core.TransientRepository;
import org.apache.jackrabbit.value.BinaryImpl;

import javax.jcr.*;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

// Description: Outputs repository (Document View) to file
public class FourthHop {
    public static void main(String[] args) throws RepositoryException, IOException {
        Repository repository = new TransientRepository();
        Session session = repository.login(new SimpleCredentials("username", "password".toCharArray()));
        Node root = session.getRootNode();

        try {
//            Node root = session.getRootNode();
//
//            NodeIterator iter = root.getNodes();
//            while (iter.hasNext()) {
//                Node foo = iter.nextNode();
//                System.out.println("Node Name: " + foo.getName());
//            }


            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("/export/home/martin/Desktop/jackrabbit-docs.xml"));
            //session.exportSystemView(root.getPath(), bufferedOutputStream, false, false);
            session.exportDocumentView(root.getPath(), bufferedOutputStream, false, false);
            bufferedOutputStream.close();
        } finally {
            session.logout();
        }

    }
}