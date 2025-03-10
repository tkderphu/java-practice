package BST;// file Lesson52.java

import BST.BinarySearchTree;

import java.util.HashMap;
import java.util.Map;

public class Lesson52 {
    public static void main(String[] args) {
        String s = "NGUYEN QUANG PHU DEP TRAI VCL DEP TRAI VCL";
        BinarySearchTree<String> tree = new BinarySearchTree<>();
        String words[] = s.split("\\s+");
        Map<String, Integer> map = new HashMap<>();
        for(String w : words) {
            tree.add(w);
            if (map.containsKey(w)) map.put(w, map.get(w) + 1);
            else map.put(w, 1);
        }
        show(tree, map);
    }

    private static void show(BinarySearchTree<String> tree,
                             Map<String, Integer> map) {
        showInOrder(tree.getRoot(), map);
    }

    private static void showInOrder(BinarySearchTree.Node<String> root,
                                    Map<String, Integer> map) {
        if(root != null) {
            showInOrder(root.getLeft(), map);
            if(map.get(root.getData()) > 0) {
                System.out.println(root.getData() + " " + map.get(root.getData()));
                map.put(root.getData(), 0);
            }
            showInOrder(root.getRight(), map);
        }
    }
}