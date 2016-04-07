/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilLib.datastructures.trees;

import java.io.PrintStream;

/**
 *
 * @author UP732011 <UP732011@myport.ac.uk>
 */
public class BST<V> {
    Node<Integer, V> _root;
    public static final int PREORDER = 0;
    public static final int INORDER = 1;
    public static final int POSTORDER = 2;
    public BST()
    {
        _root = null;
    }
    
    public void insert(Node<Integer, V> node)
    {
       Node<Integer, V> result = searchTree(_root, node.getKey());
       if(result == null)
           _root = node;
       else if (node.getKey() < result.getKey())
           result.setLeft(node);
       else
           result.setRight(node);
           
    }
    public void traverseTree(int traversalType,Node<Integer, V> node,
            PrintStream output)
    {
        if(node == null)
            output.println("Leaf");
        //preorder
        switch(traversalType)
        {
            case PREORDER:
                traverseTree(PREORDER, node.getLeft(), output);
                traverseTree(PREORDER, node.getRight(), output);
                output.println(node.getValue());
                break;
            case INORDER:
                traverseTree(PREORDER, node.getLeft(), output);
                output.println(node.getValue());
                traverseTree(PREORDER, node.getRight(), output);
                break;
            case POSTORDER:
                output.println(node.getValue());
                traverseTree(PREORDER, node.getLeft(), output);
                traverseTree(PREORDER, node.getRight(), output);
                break;
        }
    }
    public Node<Integer,V> searchTree(Node<Integer, V> node, Integer key)
    {
        if(node == null)
        {
            return node;
        }
        if(node.getKey().equals(key))
            return node;
        else
        {
            Node<Integer, V> result = null;
            if(key < node.getKey())
                result = searchTree(node.getLeft(), key);
            else
                result = searchTree(node.getRight(), key);
                
            if(result == null)
                return node;
            else
                return result;
        }
    }
}