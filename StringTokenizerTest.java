import java.util.StringTokenizer;

public class StringTokenizerTest {

    public static void main(String[] args) {
        String authors = "J. Park and J. N. James and Q. Li and Y. Xu and W. Huang";
        String[] s = authors.split(" and ");

        for (int i=0; i<s.length; i++) {
            System.out.println(s[i]);
        }

        System.out.println(s.length);

    }

}
