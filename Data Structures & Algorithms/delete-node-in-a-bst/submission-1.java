/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
//inorder succ 
class Solution {
    public TreeNode func(TreeNode node){
        while(node.left!=null){
            node = node.left;
        }
        return node;
    }
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null) return root;

        if(root.val<key){
            root.right = deleteNode(root.right,key);
        }
        else if(root.val>key){
            root.left = deleteNode(root.left,key);
        }
        else{
            if(root.left==null){
                return root.right;
            }
            else if(root.right==null){
                return root.left;
            }
            else{
                TreeNode succ = func(root.right);
                root.val = succ.val;
                root.right = deleteNode(root.right,root.val);
            }
        }
        return root;
    }
} 

// //inorder pred 
// class Solution {
//     public TreeNode func(TreeNode node){
//         while(node.right!=null){
//             node = node.right;
//         }
//         return node;
//     }
//     public TreeNode deleteNode(TreeNode root, int key) {
//         if(root==null) return root;

//         if(root.val<key){
//             root.right = deleteNode(root.right,key);
//         }
//         else if(root.val>key){
//             root.left = deleteNode(root.left,key);
//         }
//         else{
//             if(root.left==null){
//                 return root.right;
//             }
//             else if(root.right==null){
//                 return root.left;
//             }
//             else{
//                 TreeNode pred = func(root.left);
//                 root.val = pred.val;
//                 root.left = deleteNode(root.left,root.val);
//             }
//         }
//         return root;
//     }
// }