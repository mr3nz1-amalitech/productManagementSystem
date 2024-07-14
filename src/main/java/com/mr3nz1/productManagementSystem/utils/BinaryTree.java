package com.mr3nz1.productManagementSystem.utils;

import com.mr3nz1.productManagementSystem.models.Category;

import java.util.LinkedList;
import java.util.Queue;

class Node {
    Category value;
    Node leftChild;
    Node rightChild;

    public Node(Category value) {
        this.value = value;
        this.leftChild = null;
        this.rightChild = null;
    }


}

public class BinaryTree {
    Node root;

    public BinaryTree(Category value) {
        this.root = new Node(value);
    }

    public void insert(Category value) {
        root = insertVal(root, value);
    }

    private Node insertVal(Node root, Category value) {
        if (root == null) {
            root = new Node(value);
            return root;
        }

        if (value.getCategoryName().compareTo(root.value.getCategoryName()) < 0)
            root.leftChild = insertVal(root.leftChild, value);
        else if (value.getCategoryName().compareTo(root.value.getCategoryName()) > 0)
            root.rightChild = insertVal(root.rightChild, value);


        return root;
    }

    public Category breadthFirstSearch(String categoryName) {
        if (root == null) {
            return new Category();
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            if (current.leftChild != null) {
                if (categoryName.toLowerCase().equals(current.leftChild.value.getCategoryName().toLowerCase())) {
                    return current.leftChild.value;
                }
                queue.add(current.leftChild);
            }
            if (current.rightChild != null) {
                if (categoryName.toLowerCase().equals(current.rightChild.value.getCategoryName().toLowerCase())) {
                    return current.rightChild.value;
                }
                queue.add(current.rightChild);
            }
        }

        return new Category();
    }

}