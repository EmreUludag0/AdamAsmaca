import java.util.Random;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        String[] words = {"java", "programlama","bilgisayar","kitap"};
        String wordToGuess = words[random.nextInt(words.length)];
        System.out.println(wordToGuess);

        boolean[] guessedLetters  = new boolean[wordToGuess.length()];


        int remainingGuess = 6;


        System.out.println("adam asmaca oyununa hoşgeldiniz!");
        System.out.println("kelimeyi tahmin etmek için harf girişi yapin");

        while (remainingGuess > 0){
            for(int i = 0; i< wordToGuess.length();i++){
                if(guessedLetters[i]){
                    System.out.println(wordToGuess.charAt(i)+" ");
                }else {
                    System.out.println("_ ");
                }
                System.out.println("");
                System.out.println("kalan tahmin hakkiniz: "+ remainingGuess);
                System.out.println("Harf Giriniz: ");
                char guess = scanner.next().charAt(0);

                boolean isFound = false;

                for(i = 0; i < wordToGuess.length(); i++){
                    if (wordToGuess.charAt(i) == guess){
                        guessedLetters[i] = true;
                        isFound = true;
                    }
                }

                if(isFound){
                    System.out.println("harf doğru tahmin edildi");
                }else{
                   remainingGuess--;
                   System.out.println("harf bulunamadi");
                }

                boolean isComplete = true;
                for(boolean letter: guessedLetters){
                    if (!letter){
                        isComplete = false;
                    }
                }
                if(isComplete){
                    System.out.println("tebrikler, bitti."+ wordToGuess);
                } break;

            }
        }
        if (remainingGuess == 0){
            System.out.println("Tahmin hakki bitti.");
            System.out.println(wordToGuess);
        }

    }
}