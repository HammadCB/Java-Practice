package Projects;



import java.util.Scanner;

class Note {
    private String title;
    private String content;

    // Constructor
    public Note(String title, String content) {
        this.title = title;
        this.content = content;
    }

    // Simulated save
    public void save() {
        System.out.println("Saving note: " + title);
    }

    // Display details (optional)
    public void showNote() {
        System.out.println("Title: " + title);
        System.out.println("Content: " + content);
    }
}

public class NoteSaver {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Note[] notes = new Note[2];

        // Input notes
        for (int i = 0; i < notes.length; i++) {
            System.out.println("\nEnter details for Note " + (i + 1));
            System.out.print("Title: ");
            String title = sc.nextLine();
            System.out.print("Content: ");
            String content = sc.nextLine();

            notes[i] = new Note(title, content);
        }
        sc.close();

        // Save notes
        System.out.println("\n--- Saving Notes ---");
        for (Note n : notes) {
            n.save();
            n.showNote();
        }
    }
}
