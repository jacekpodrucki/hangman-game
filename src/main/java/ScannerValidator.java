import java.util.Scanner;
import java.util.regex.Pattern;

public interface ScannerValidator
{
    String validateInput(Scanner scanner, Pattern pattern, String errorMessage);
    String validateLetter(Scanner scanner);
    String validateWord(Scanner scanner);
}
