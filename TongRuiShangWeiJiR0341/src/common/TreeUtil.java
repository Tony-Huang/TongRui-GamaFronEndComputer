/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package common;

import com.tongrui.shangweiji.ui.usermanagement.UserObject;
import java.util.ArrayList;
import java.util.List;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import javax.swing.JTree;
import javax.swing.tree.TreePath;
//i
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreeModel;


/**
 *
 * @author Administrator
 */
public class TreeUtil {

    public static void copyTreePath2Tree(TreePath path,JTree tree){
     TreeModel model =   tree.getModel();
     copyTreePath2TreeModel( path, model);
    }
    
      public static void copyTreePath2TreeModel(TreePath path,TreeModel model){
         DefaultMutableTreeNode root = (DefaultMutableTreeNode)model.getRoot();
         copyTreePath2Root(path,root);
      }

    public static void copyTreePath2Root(TreePath path, DefaultMutableTreeNode root ){
      DefaultMutableTreeNode parent  = null;
      boolean find = false;
      if(root ==null){
        DefaultMutableTreeNode pathRoot = (DefaultMutableTreeNode) path.getPath()[0];
       root = new DefaultMutableTreeNode(pathRoot.getUserObject());
       //String name = (String)root.getUserObject();
      // root.setUserObject(new UserObject(name,-1));
      }
       parent = root;    
      //DefaultMutableTreeNode[]  paths = (DefaultMutableTreeNode[])path.getPath();
      Object[]  paths = path.getPath();
      for(int i=1; i<paths.length;i++){
        DefaultMutableTreeNode currentLeft = (DefaultMutableTreeNode)paths[i];
           //find the matched node in target hierarchy.
            for(int k =0; k < parent.getChildCount();k++){
               DefaultMutableTreeNode chd=(DefaultMutableTreeNode) parent.getChildAt(k);
              if(  chd.getUserObject().equals(currentLeft.getUserObject())){
               find = true; parent = chd;
               break;
              }
              else if(k==parent.getChildCount()-1){
                find =false; 
                break;
              }
            } 
         
            
       if(!find){
           if(i==paths.length-1 && !currentLeft.isLeaf())
           parent = addNodeKeepingOriginalOrder( currentLeft,  parent,true);
           else
               parent = addNodeKeepingOriginalOrder( currentLeft,  parent,false);
           System.out.println("after add, parent="+parent);
          }
       else {
        if(!currentLeft.isLeaf()&&currentLeft==path.getLastPathComponent()){
            for(int m = 0; m < currentLeft.getChildCount(); m++){
              addNodeKeepingOriginalOrder( (DefaultMutableTreeNode)currentLeft.getChildAt(m),  parent,true);
            }
           }
        }
            
      }    
        
    }
    
    public static DefaultMutableTreeNode addNodeKeepingOriginalOrder(DefaultMutableTreeNode current, DefaultMutableTreeNode parent,boolean deep){
          DefaultMutableTreeNode newnode = null;
          if(!deep){
           newnode = (DefaultMutableTreeNode)current.clone();
          }
          else {
           clonedRoot = null;
           cloneTreeNode(current,null);
           newnode = clonedRoot;
          }
            int originalIndex  = current.getParent().getIndex(current);
            String name = (String)current.getUserObject();
            System.out.println("parent ="+parent +",current="+current);
            System.out.println("original name="+name +",index="+originalIndex +" ---------------------");
        newnode.setUserObject(new UserObject(name,originalIndex));
           //parent.add(newnode);
        //=======================   ============================
        int chdcount =parent.getChildCount();
        if(chdcount ==0) {
         parent.add(newnode);
         }
       else {
           int position = 0;
         for(int i = 0; i < parent.getChildCount(); i++ ){
         DefaultMutableTreeNode chd = (DefaultMutableTreeNode)parent.getChildAt(i);
         UserObject  uo = (UserObject)chd.getUserObject();
         int oindex= uo.getOriginalIndex();
         if(originalIndex<oindex){
             position =i;
             break;  
         }
         else if(originalIndex == oindex){
             position=-100;
             break;
         }
         else {
                position = i+1;
             continue;
         
         }
                                      }
         if(position>-1)
        parent.insert(newnode, position);
          
        }
      
     // parent = newnode;
       return newnode;
    }
    
    public static DefaultMutableTreeNode clonedRoot =null;      
    public static DefaultMutableTreeNode cloneTreeNode(DefaultMutableTreeNode original,DefaultMutableTreeNode clonedParent){
    //clonedRoot = null;   
     DefaultMutableTreeNode cloned=  null;
      if( clonedParent ==null) {
        cloned = (DefaultMutableTreeNode)original.clone();
        clonedRoot = cloned;
      }
      else 
          cloned= clonedParent;
    
      int chdCount = original.getChildCount();
      for(int i =0;i<chdCount; i++){
        DefaultMutableTreeNode chd = (DefaultMutableTreeNode)original.getChildAt(i);
        DefaultMutableTreeNode clonedSubnode=  (DefaultMutableTreeNode)chd.clone();
        cloned.add(clonedSubnode);
        cloneTreeNode(chd,clonedSubnode);
      }
      return clonedRoot;
    }
    
    public static void deleteTreePathFromRoot(TreePath path){
       Object[] paths= path.getPath();
       for(int i = paths.length-1;i>-1;i--){
        DefaultMutableTreeNode node= (DefaultMutableTreeNode) paths[i];
        DefaultMutableTreeNode parent=  (DefaultMutableTreeNode)node.getParent();
        node.removeFromParent();
        if(parent!=null &&parent.getChildCount()>0){
          break;
        }
       }
      
    }
    
    public static void printNodeInfo(DefaultMutableTreeNode node){
        if(node.isRoot())
      System.out.println(node);
      for(int i = 0; i < node.getChildCount() ;i++){
          DefaultMutableTreeNode subnode = (DefaultMutableTreeNode) node.getChildAt(i);
          System.out.println(subnode);
          printNodeInfo(subnode);
      }
    }
    
}
