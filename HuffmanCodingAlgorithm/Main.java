import java.util.PriorityQueue;
import java.util.Scanner;

// Main class
public class Main {

  // Function for priting the generated huffman trees code
  public static void printCode(HuffmanNode root, String code) {
    if (root.left == null && root.right == null && Character.isLetter(root.c)) {
      System.out.println(root.c + ": " + code);

      return;
    }

    printCode(root.left, code + "0");
    printCode(root.right, code + "1");
  }

  // Main function
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    // Creating the word which is supposed to be coded
    int wordSize = 6;
    char[] charArray = { 'a', 'b', 'c', 'd', 'e', 'f' };
    int[] charfreq = { 5, 9, 12, 13, 16, 45 };

    // Creating priority queue
    PriorityQueue<HuffmanNode> queue = new PriorityQueue<HuffmanNode>(
      wordSize,
      new MyComparator()
    );

    // Create a node for each character of word
    // and add them in priority queue
    for (int i = 0; i < wordSize; i++) {
      HuffmanNode huffmanNewNode = new HuffmanNode();

      huffmanNewNode.c = charArray[i];
      huffmanNewNode.data = charfreq[i];

      huffmanNewNode.left = null;
      huffmanNewNode.right = null;

      queue.add(huffmanNewNode);
    }

    HuffmanNode root = null;

    // Generating the huffman tree
    while (queue.size() > 1) {
      HuffmanNode X = queue.peek();
      queue.poll();

      HuffmanNode Y = queue.peek();
      queue.poll();

      HuffmanNode Z = new HuffmanNode();

      Z.data = X.data + Y.data;
      Z.c = '-';

      Z.left = X;

      Z.right = Y;

      root = Z;

      queue.add(Z);
    }

    // Printing the result
    printCode(root, "");
  }
}
