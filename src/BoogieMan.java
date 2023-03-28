import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class BoogieMan {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("D:/Words.txt"));
        Scanner keyboard = new Scanner(System.in);
        List<String> words = new ArrayList();
        while (scanner.hasNext()){
            words.add(scanner.nextLine());
        }
        Random random = new Random();
        String word = words.get(random.nextInt(words.size()));
        System.out.println(word);


        List<Character> playerGuesses = new ArrayList<>();

        while (true){
            printWordState(word, playerGuesses);
            getPlayerGuess(keyboard, word, playerGuesses);
            if(printWordState(word, playerGuesses)){
                System.out.println("You Win!");
                break;
            }
            System.out.println("Please enter your guess of the world");
            if(keyboard.nextLine().equals(word)){
                System.out.println("You Win!");
                break;
            }
            else{
                System.out.println("Incorrect");
            }
        }

        //__________________________________


        //__________________________________
    }
    public static void getPlayerGuess(Scanner keyboard, String word, List<Character> playerGuesses){
        System.out.println("Введите буквы");
        String letterguess = keyboard.nextLine();
        playerGuesses.add(letterguess.charAt(0));
    }
    public static boolean printWordState(String word, List<Character> playerGuesses){
        int correctCount = 0;
        for (int i = 0; i < word.length(); i++) {
            if(playerGuesses.contains(word.charAt(0))){
                System.out.print(word.charAt(i));
                correctCount++;
            }
            else{
                System.out.print("_");
            }

        }
        System.out.println(" ");
        return (word.length() == correctCount);
    }
    public static void printBoogieMan(Integer wrongCount){
        if (wrongCount >= 1){
            System.out.println("0");
        }
        if (wrongCount >= 2){
            System.out.println(" \\");
            if (wrongCount >= 3) {
                System.out.println(" /");
            } else {
                System.out.println("");
            }
        }
        if (wrongCount >= 4) {
            System.out.println(" |");
        }
        if(wrongCount >= 5) {
            System.out.println("/");
            if (wrongCount >= 6) {
                System.out.println(" \\");
            } else {
                System.out.println("");
            }

            }
    }
}
