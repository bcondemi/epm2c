/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brunocondemi.pdiemc.ui.bean;
import java.io.File;
import javax.faces.bean.ManagedBean;
import org.primefaces.model.TreeNode;
import org.primefaces.model.DefaultTreeNode;
/**
 *
 * @author bruno
 */
@ManagedBean
public class NavigatorBean {
    private TreeNode root;

	public NavigatorBean() {
		root = new DefaultTreeNode("Home", null);
		TreeNode node0 = new DefaultTreeNode("Sales", root);
		TreeNode node1 = new DefaultTreeNode("Distribution", root);
		TreeNode node2 = new DefaultTreeNode("Manufacturing", root);
		
		TreeNode node00 = new DefaultTreeNode("Order", node0);
		TreeNode node01 = new DefaultTreeNode("Invoice", node0);
		
		TreeNode node10 = new DefaultTreeNode("Purchase", node1);
		TreeNode node11 = new DefaultTreeNode("Print", node1);
		
		TreeNode node000 = new DefaultTreeNode("dddd", node00);
		TreeNode node001 = new DefaultTreeNode("Node 0.0.1", node00);
		TreeNode node010 = new DefaultTreeNode("Node 0.1.0", node01);
		
		TreeNode node100 = new DefaultTreeNode("Node 1.0.0", node10);
	}

	public TreeNode getRoot() {
		return root;
	}
        public void getList(){
            
                File f = new File("/");
                System.out.println(f.getAbsolutePath());

}
    
}
