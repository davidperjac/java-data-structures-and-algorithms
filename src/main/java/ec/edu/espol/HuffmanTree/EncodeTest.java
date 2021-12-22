package ec.edu.espol.HuffmanTree;

import ec.edu.espol.HuffmanTree.HuffmanInfo;
import ec.edu.espol.HuffmanTree.HuffmanTree;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Set;

public class EncodeTest {

    public static void main(String[] args) {
        
        //COMPARATOR DE LOS NODOS QUE DEFINE EL ARBOL 
        Comparator<HuffmanTree<HuffmanInfo>> cmp = (s1, s2) -> {
            int restaFreq = s1.getRoot().getContent().getFrequency() - s2.getRoot().getContent().getFrequency();
            if (restaFreq == 0) {
                int restaLength = s1.getRoot().getContent().getText().length() - s2.getRoot().getContent().getText().length();
                if (restaLength == 0) {
                    return s1.getRoot().getContent().getText().compareTo(s2.getRoot().getContent().getText());
                }
                return restaLength;
            }
            return restaFreq;
        };
        /**
         * * PRUEBA DEL LITERAL 6.
         */
        //A) LEER TODO EL ARCHIVO
        //362 caracteres
        String textToCode = HuffmanTree.getWordsToProcess("textToCode.txt");
        //B GENERAR LA TABLA DE FRECUENCIAS
        HashMap<String, Integer> frequencies = HuffmanTree.getFrequencies(textToCode);
        //System.out.println(frequencies);
        //C CONSTRUIR EL ARBOL DE HUFFMAN
        HuffmanTree<HuffmanInfo> huffTree = HuffmanTree.buildHuffmanTree(frequencies,cmp);
        huffTree.recorrerPreOrden();
        //D) GENERAR CODIGOS
        LinkedHashMap<String, Integer> charCode = new LinkedHashMap<>();
        LinkedHashMap<Integer, String> codeChar = new LinkedHashMap<>();
        Set<String> charList = frequencies.keySet();
        HuffmanTree.getHuffmanCodes(charList, huffTree, charCode, codeChar);
        //System.out.println(charCode);
        //E y F) CODIFICAR CADENA
        String textEncoded = HuffmanTree.encode(textToCode, charCode);
        //System.out.println(textEncoded);
        HuffmanTree.saveProcessedWords("encodedText.txt", textEncoded);
        /**
         * * PRUEBA DEL LITERAL 7 ) DECODIFICAR CADENA.
         */
        String textToEncode = HuffmanTree.getWordsToProcess("encodedText.txt");
        String encodedTxt = HuffmanTree.decode(textToEncode, codeChar);
        HuffmanTree.saveProcessedWords("decodedText.txt", encodedTxt);
    }
}
