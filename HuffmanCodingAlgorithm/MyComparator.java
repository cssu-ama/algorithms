import java.util.Comparator;

// Comparator class to use in sorting
public class MyComparator implements Comparator<HuffmanNode> {

  public int compare(HuffmanNode x, HuffmanNode y) {
    return x.data - y.data;
  }
}
