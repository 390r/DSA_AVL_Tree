
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException{

        Scanner sc = new Scanner(new File("input.txt"));
        PrintWriter wr = new PrintWriter("output.txt");

        int summ = 0;

        MyNode root = null;
        MyAVL tree = new MyAVL();

        String str = "";
        int i=0;
        int[] arr;


        str = sc.nextLine();


        String[] strArr = str.split(" ");

        arr = new int[strArr.length];

        for (i=0; i<strArr.length; i++){
            arr[i] = Integer.parseInt(strArr[i]);
        }


        // Insert input data to the Tree

        for (i=0; i<arr.length; i++)
            root = tree.insert(root, arr[i]);

        root = tree.removeAVL(10, root);

        // Find sum of smallerelements

        wr.print(tree.smallerelements(root));


        wr.close();

    }
}
