import org.apache.jackrabbit.core.TransientRepository;
import javax.jcr.*;

// Description: Display all Node names
public class FifthHop {
    public static void main(String[] args) throws RepositoryException {
        Repository repository = new TransientRepository();
        Session session = repository.login(new SimpleCredentials("username", "password".toCharArray()));
        Node root = session.getRootNode();

        // get NodeIterator
        NodeIterator iter = root.getNodes();

        while(iter.hasNext()) {
            Node node = iter.nextNode();
            System.out.println(node.getName());

            if (node.hasNodes()) {
                traverseNodeStructure(node, 1);
            }
        }
    }

    private static void traverseNodeStructure(Node node, int level) throws RepositoryException {
        displayNode(node, level);

            // check if this Node has Child Nodes
            if (node.hasNodes()) {
                level++;
                
                NodeIterator childIterator = node.getNodes();
                while(childIterator.hasNext()) {
                    Node childNode = childIterator.nextNode();
                    traverseNodeStructure(childNode, level);
                }
            }
    }

    private static void displayNode(Node node, int level) throws RepositoryException {
        System.out.print("+");

        if (level > 1) {
            for (int i = 1; i < level; i++) {
                System.out.print("-");
            }
        }
        System.out.print(node.getName());
        System.out.print("\n");
    }
}
