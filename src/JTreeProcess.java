
import javax.swing.JTree;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;


public class JTreeProcess {

    public static void setSubjectNotes(JTree tree, ArrayList<String> array) {
        DefaultTreeModel model = (DefaultTreeModel) tree.getModel();

        DefaultMutableTreeNode root = (DefaultMutableTreeNode) model.getRoot();

        for (int i = 0; i < array.size(); i++) {

            root.add(new DefaultMutableTreeNode(array.get(i)));

        }

    }

    public static void deleteUpdateTreeNode(JTree tree) {
        DefaultTreeModel model = (DefaultTreeModel) tree.getModel();

        DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();

        if (selectedNode != null) {
            model.removeNodeFromParent(selectedNode);
        }
    }

    public static void addNodeTree(JTree tree, String monHoc) {
        DefaultTreeModel model = (DefaultTreeModel) tree.getModel();

        DefaultMutableTreeNode root = (DefaultMutableTreeNode) model.getRoot();

        root.add(new DefaultMutableTreeNode(monHoc));

        model.reload();
    }

    public static void setSubjectCombox(JComboBox<String> comboBox, ArrayList<String> array) {
        for (int i = 0; i < array.size(); i++) {

            comboBox.addItem(array.get(i));

        }
    }

}
