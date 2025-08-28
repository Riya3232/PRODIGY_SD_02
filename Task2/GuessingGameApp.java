import java.util.Random;
import java.util.Scanner;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GuessingGameApp {

    // Console Version
    public static void playConsoleVersion() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int numberToGuess = random.nextInt(100) + 1; // 1 to 100
        int attempts = 0;
        int guess = 0;

        System.out.println("🎮 Welcome to the Number Guessing Game (Console Version)!");
        System.out.println("I have selected a number between 1 and 100. Try to guess it!");

        while (guess != numberToGuess) {
            System.out.print("Enter your guess: ");
            guess = scanner.nextInt();
            attempts++;

            if (guess < numberToGuess) {
                System.out.println("Too low! Try again.");
            } else if (guess > numberToGuess) {
                System.out.println("Too high! Try again.");
            } else {
                System.out.println("🎉 Correct! You guessed the number in " + attempts + " attempts.");
            }
        }
    }

    // GUI Version
    public static void playGUIVersion() {
        Random random = new Random();
        int numberToGuess = random.nextInt(100) + 1;

        JFrame frame = new JFrame("Guessing Game 🎮");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel instructionLabel = new JLabel("Guess a number between 1 and 100:");
        JTextField guessField = new JTextField(10);
        JButton guessButton = new JButton("Submit");
        JLabel feedbackLabel = new JLabel(" ");
        JLabel attemptLabel = new JLabel("Attempts: 0");

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 1));
        panel.add(instructionLabel);
        panel.add(guessField);
        panel.add(guessButton);
        panel.add(feedbackLabel);
        panel.add(attemptLabel);

        frame.add(panel);
        frame.setVisible(true);

        final int[] attempts = {0};

        guessButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int guess = Integer.parseInt(guessField.getText());
                    attempts[0]++;

                    if (guess < numberToGuess) {
                        feedbackLabel.setText("Too low! Try again.");
                    } else if (guess > numberToGuess) {
                        feedbackLabel.setText("Too high! Try again.");
                    } else {
                        feedbackLabel.setText("🎉 Correct! You guessed it!");
                        JOptionPane.showMessageDialog(frame,
                                "You guessed the number in " + attempts[0] + " attempts!");
                    }
                    attemptLabel.setText("Attempts: " + attempts[0]);
                    guessField.setText("");
                } catch (NumberFormatException ex) {
                    feedbackLabel.setText("⚠️ Please enter a valid number.");
                }
            }
        });
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose Game Mode:");
        System.out.println("1. Console Version");
        System.out.println("2. GUI Version");
        System.out.print("Enter choice (1 or 2): ");
        int choice = sc.nextInt();

        if (choice == 1) {
            playConsoleVersion();
        } else if (choice == 2) {
            playGUIVersion();
        } else {
            System.out.println("Invalid choice! Exiting...");
        }
    }
}
