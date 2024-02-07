import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.regex.Pattern;

class HangmanValidator implements ScannerValidator
{
    private final Pattern letterPattern = Pattern.compile("^[a-zA-Z]{1}$");
    private final Pattern wordPattern = Pattern.compile("^[a-zA-Z]{2,64}$");

    @Override
    public String validateInput(Scanner scanner, Pattern pattern, String errorMessage)
    {
        while (true)
        {
            try
            {
                String input = scanner.nextLine();

                if (!pattern.matcher(input).matches())
                {
                    System.out.println(errorMessage);
                    continue;
                }

                return input;
            }
            catch (NoSuchElementException e)
            {
                System.out.println("End of input. Exiting...");
                System.exit(0);
            }
            catch (IllegalStateException e)
            {
                System.out.println("Error: Scanner is closed.");
            }
            catch (Exception e)
            {
                System.out.println("An unexpected error occurred.");
                e.printStackTrace();
            }
        }
    }

    @Override
    public String validateLetter(Scanner scanner)
    {
        return validateInput(scanner, letterPattern, "Error: Please enter only one letter.");
    }

    @Override
    public String validateWord(Scanner scanner)
    {
        return validateInput(scanner, wordPattern, "Error: The word must contain only alphabetical characters and be in a [2,64] range.");
    }
}