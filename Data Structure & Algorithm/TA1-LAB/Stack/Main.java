import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        TextEditor editor = new TextEditor();

        while (true) {
            System.out.println("\nMenu :");
            System.out.println("1. Tambah Teks");
            System.out.println("2. Undo");
            System.out.println("3. Redo");
            System.out.println("4. Tampilkan Teks");
            System.out.println("5. Keluar");
            System.out.print("Pilih: ");

            int pilihan = input.nextInt();
            input.nextLine();

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan teks: ");
                    String teks = input.nextLine();
                    editor.addText(teks);
                    System.out.println("Teks saat ini: \"" + editor.getText() + "\"");
                    break;

                case 2:
                    editor.undo();
                    System.out.println("Undo: \"" + editor.getText() + "\"");
                    break;

                case 3:
                    editor.redo();
                    System.out.println("Redo: \"" + editor.getText() + "\"");
                    break;

                case 4:
                    editor.showText();
                    break;

                case 5:
                    System.out.println("Keluar...");
                    return;

                default:
                    System.out.println("Pilihan tidak valid!");
            }
        }
    }
}
