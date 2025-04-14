import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rc = new Random();

        String[] wordlist = {"Atharv","Ayush","Srushti","Shlok","Atul","Arya","Kailash","Fluffy","Dudu","Chapru"};

        int playerScore = 0;
        Boolean stillPlaying = true;
        System.out.println("Welcome to my Word Scrambler Wizard!");
        System.out.println("You have to unscrable the words to score the point");

        while (stillPlaying){
            String word = wordlist[rc.nextInt(wordlist.length)];
            String scrambledWord = scrambleWord(word,rc);
            System.out.println("Guess the correct word: "+ scrambledWord);
            boolean wordGuessed = false;
            int attempts = 3;


            while (attempts > 0 && !wordGuessed){
                System.out.println("Your Guess: ");
                String playerGuess = sc.nextLine();

                if (playerGuess.equalsIgnoreCase(word)){
                    wordGuessed = true;
                    System.out.println("You Guessed Right");
                    playerScore++;
                    System.out.println("Your Score: "+playerScore);
                }else {
                    System.out.println("Incorrect Guess");
                    attempts--;
                    System.out.println("Attempts Remaining: "+attempts);
                }
            }
            if (!wordGuessed){
                System.out.println("The correct word was "+ word);
            }
            System.out.println("Your score is: "+playerScore);
            System.out.println("Do you want to play again? (YES/NO)");
            String response = sc.nextLine();
            stillPlaying = response.equalsIgnoreCase("yes");
        }
        System.out.println("Your final score is "+ playerScore);

    }

    public static String scrambleWord(String word , Random rc){
        char[] letters = word.toCharArray();
        for(int i = 0 ; i < letters.length ; i++){
            int j = rc.nextInt(letters.length);
            char temp = letters[i];
            letters[i] = letters[j];
            letters[j] = temp;
        }
        return new String(letters);
    }
}
