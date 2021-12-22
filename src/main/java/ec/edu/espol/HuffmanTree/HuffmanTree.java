package ec.edu.espol.HuffmanTree;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.Stack;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Comparator;

/**
 *
 * @author davidperez
 */
public class HuffmanTree<T> {

    private HuffmanNode<T> root;

    public HuffmanTree() {
        this.root = new HuffmanNode<>();
    }

    public HuffmanTree(HuffmanNode<T> root) {
        this.root = root;
    }

    public HuffmanTree(T content) {
        this.root = new HuffmanNode<>(content);
    }

    public HuffmanNode<T> getRoot() {
        return root;
    }

    public void setRoot(HuffmanNode<T> root) {
        this.root = root;
    }

    public void setLeft(HuffmanTree<T> tree) {
        this.root.setLeft(tree);
    }

    public void setRight(HuffmanTree<T> tree) {
        this.root.setRight(tree);
    }

    public HuffmanTree<T> getLeft() {
        return this.root.getLeft();
    }

    public HuffmanTree<T> getRight() {
        return this.root.getRight();
    }

    public boolean isEmpty() {
        return this.root == null;
    }

    public boolean isLeaf() {
        return this.root.getLeft() == null && this.root.getRight() == null;
    }

    /**
     * * METODOS EXTRAS.
     */
    public void recorrerPreOrden() {
        if (!this.isEmpty()) {
            System.out.println(this.root.getContent());

            if (root.getLeft() != null) {
                root.getLeft().recorrerPreOrden();
            }

            if (root.getRight() != null) {
                root.getRight().recorrerPreOrden();
            }

        }
    }

    public void recorrerPostOrden() {
        if (!this.isEmpty()) {

            if (root.getLeft() != null) {
                root.getLeft().recorrerPreOrden();
            }

            if (root.getRight() != null) {
                root.getRight().recorrerPreOrden();
            }

            System.out.println(this.root.getContent());
        }
    }

    public void recorrerEnOrden() {
        if (!this.isEmpty()) {
            if (root.getLeft() != null) {
                root.getLeft().recorrerPreOrden();
            }

            System.out.println(this.root.getContent());

            if (root.getRight() != null) {
                root.getRight().recorrerPreOrden();
            }

        }
    }

    /**
     * * METODOS DE HUFFMAN.
     */
    //1
    public static HashMap<String, Integer> getFrequencies(String cadena) {
        String[] letters = cadena.split("");
        HashMap<String, Integer> dic = new HashMap<>();
        for (String letter : letters) {
            if (dic.containsKey(letter)) {
                dic.put(letter, dic.get(letter) + 1);
            } else {
                dic.put(letter, 1);
            }
        }
        return dic;
    }

    //2
    public static HuffmanTree<HuffmanInfo> buildHuffmanTree(HashMap<String, Integer> dic, Comparator<HuffmanTree<HuffmanInfo>> cmp) {
        PriorityQueue<HuffmanTree<HuffmanInfo>> queue = buildHuffmanQueue(dic, cmp);
        while (queue.size() != 1) {
            HuffmanTree<HuffmanInfo> left = queue.poll();
            HuffmanTree<HuffmanInfo> right = queue.poll();
            HuffmanTree<HuffmanInfo> root = setRootInfo(left, right);
            queue.offer(root);
        }
        return queue.poll();
    }

    private static PriorityQueue<HuffmanTree<HuffmanInfo>> buildHuffmanQueue(HashMap<String, Integer> dic, Comparator<HuffmanTree<HuffmanInfo>> cmp) {
        PriorityQueue<HuffmanTree<HuffmanInfo>> treeQueue = new PriorityQueue<>(cmp);
        Set<String> letters = dic.keySet();
        for (String letter : letters) {
            int freq = dic.get(letter);
            HuffmanInfo huffInfo = new HuffmanInfo(letter, freq);
            HuffmanTree<HuffmanInfo> leaf = new HuffmanTree(huffInfo);
            treeQueue.offer(leaf);
        }
        return treeQueue;
    }

    private static HuffmanTree<HuffmanInfo> setRootInfo(HuffmanTree<HuffmanInfo> left, HuffmanTree<HuffmanInfo> right) {
        String text = left.root.getContent().getText() + right.root.getContent().getText();
        int freq = left.root.getContent().getFrequency() + right.root.getContent().getFrequency();
        HuffmanInfo huffInfo = new HuffmanInfo(text, freq);
        huffInfo.setBit(1);
        HuffmanTree<HuffmanInfo> root = new HuffmanTree<>(huffInfo);
        root.setLeft(left);
        root.setRight(right);
        left.root.getContent().setBit(0);
        right.root.getContent().setBit(1);
        return root;
    }

    //3
    public static void getHuffmanCodes(Set<String> chars, HuffmanTree<HuffmanInfo> tree, Map charCode, Map codeChar) {
        for (String letter : chars) {
            String code = "";
            code = getCode(tree, letter, code);
            charCode.put(letter, code);
            codeChar.put(code, letter);
        }
    }

    private static String getCode(HuffmanTree<HuffmanInfo> tree, String letter, String code) {
        Stack<HuffmanTree<HuffmanInfo>> stack = new Stack();
        HuffmanNode<HuffmanInfo> originalRoot = tree.root;
        stack.push(tree);
        while (!stack.isEmpty()) {
            HuffmanTree<HuffmanInfo> subtree = stack.pop();
            if (subtree.root.getContent().getText().equals(letter)) {
                code += subtree.root.getContent().getBit();
                break;
            }
            if (subtree.root.getRight() != null) {
                stack.push(subtree.root.getRight());
            }
            if (subtree.root.getLeft() != null) {
                stack.push(subtree.root.getLeft());
            }
            if (isContained(subtree, originalRoot, letter)) {
                code += subtree.root.getContent().getBit();
            }
        }
        return code;
    }

    private static boolean isContained(HuffmanTree<HuffmanInfo> subtree, HuffmanNode<HuffmanInfo> originalRoot, String letter) {
        boolean isNotLeaf = !subtree.isLeaf();
        boolean hasContent = subtree.root.getContent().getText().contains(letter);
        boolean isNotRoot = !subtree.root.getContent().getText().equals(originalRoot.getContent().getText());
        return isNotLeaf && isNotRoot && hasContent;
    }

    //4
    public static String encode(String text, Map<String, Integer> dic) {
        String[] letters = text.split("");
        String encodeText = "";
        for (String letter : letters) {
            if (dic.containsKey(letter)) {
                encodeText += dic.get(letter);
            } else {
                return null;
            }
        }
        return encodeText;
    }

    public static String decode(String text, Map<Integer, String> dic) {
        String[] codes = text.split("");
        String decodeText = "";
        String bufferText = "";
        for (String num : codes) {
            bufferText += num;
            if (dic.containsKey(bufferText)) {
                decodeText += dic.get(bufferText);
                bufferText="";
            }
        }
        return decodeText;
    }
    /**
     * * METODOS DE LECTURA Y ESCRITURA DE HUFFMAN.
     */
    public static String getWordsToProcess(String nomfile) {
        String finalTxt = "";
        try (BufferedReader sc = new BufferedReader(new FileReader(new File(nomfile)))) {
            String str;
            while ((str = sc.readLine()) != null) {
                finalTxt += str;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return finalTxt;
    }

    public static void saveProcessedWords(String nomfile, String text) {
        try (PrintWriter pw = new PrintWriter(new FileOutputStream(new File(nomfile),false))) {
            pw.println(text);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
