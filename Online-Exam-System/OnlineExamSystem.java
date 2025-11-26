// 2️⃣ Online Exam System
// Create classes:
// •	Question (questionText, options, correctAnswer)
// •	MCQQuestion (inherits Question)
// •	TrueFalseQuestion (inherits Question)
// Exam class:
// •	addQuestion()
// •	startExam()
// •	calculateScore()
// Task: Use polymorphism so exam can store both types in a single list.


import java.util.*;

// Base class
abstract class Question {
    String questionText;
    String correctAnswer;

    Question(String questionText, String correctAnswer) {
        this.questionText = questionText;
        this.correctAnswer = correctAnswer;
    }

    abstract void askQuestion();  // Polymorphic method
}

// MCQ Question
class MCQQuestion extends Question {
    String[] options;

    MCQQuestion(String questionText, String[] options, String correctAnswer) {
        super(questionText, correctAnswer);
        this.options = options;
    }

    @Override
    void askQuestion() {
        System.out.println(questionText);
        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + ". " + options[i]);
        }
    }
}

// True/False Question
class TrueFalseQuestion extends Question {

    TrueFalseQuestion(String questionText, String correctAnswer) {
        super(questionText, correctAnswer);
    }

    @Override
    void askQuestion() {
        System.out.println(questionText + " (True/False)");
    }
}

// Exam Class
class Exam {

    private List<Question> questions = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);
    private int score = 0;

    void addQuestion(Question q) {
        questions.add(q);
    }
    void startExam() {
        for (Question q : questions) {
            q.askQuestion();  // Polymorphism used here
            System.out.print("Your Answer: ");
            String ans = sc.nextLine();

            if (ans.equalsIgnoreCase(q.correctAnswer)) {
                score++;
            }
            System.out.println();
        }
    }
    int calculateScore() {
        return score;
    }
}

// Driver
public class OnlineExamSystem {

    public static void main(String[] args) {

        Exam exam = new Exam();

        // Adding MCQ Question
        exam.addQuestion(
            new MCQQuestion(
                "Which language is used for Android Development?",
                new String[]{"Java", "Python", "C++", "Ruby"},
                "1"  // correct answer: Java
            )
        );

        // Adding True/False Question
        exam.addQuestion(
            new TrueFalseQuestion(
                "Java is platform dependent.",
                "False"
            )
        );

        exam.startExam();
        System.out.println("Your Score: " + exam.calculateScore());
    }
}
