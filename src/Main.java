import java.io.FileNotFoundException;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {
        try {
            LocalMax lm = new LocalMax();
            lm.readMatrix();
            lm.findMaxMin();
        }
        catch (FileNotFoundException e) {
            System.out.println("File is not found!");
        }
        catch (InputMismatchException e){
            System.out.println("Incorrect input in file!");
        }
    }
}
