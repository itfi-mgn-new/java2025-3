package lesson9;

import java.io.File;
import java.util.Enumeration;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.event.TreeModelListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

public class TreeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
							
		final DefaultTreeModel dtm = new DefaultTreeModel(
				loadModel(
						new File("C:\\Users\\Student\\eclipse")
				)
		);
		final JTree	tree = new JTree(dtm);
		
		tree.getSelectionPath();
		
		
		tree.addTreeWillExpandListener(null);
		
		JOptionPane.showMessageDialog(null, new JScrollPane(tree));
	}

	private static DefaultMutableTreeNode loadModel(final File root) {
		final DefaultMutableTreeNode result = new DefaultMutableTreeNode(root, true) {
//							@Override
//							public boolean isLeaf() {
//								return root.isFile();
//							}
						};
		if (root.isDirectory()) {
			final File[] content = root.listFiles();
			if (content != null) {
				for(File item : content) {
					result.add(loadModel(item));
				}
			}
		}
					
		return result;
	}
	
}
