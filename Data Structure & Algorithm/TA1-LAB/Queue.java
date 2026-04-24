// Kelas Queue berbasis Linked List
class Queue {
    Node front, rear; // front = depan antrean, rear = belakang antrean

    // Method untuk menambah pelanggan (enqueue)
    void enqueue(String nama) {
        Node newNode = new Node(nama);

        // Jika antrean kosong
        if (rear == null) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }

        System.out.println("Pelanggan " + nama + " ditambahkan ke antrean.");
    }

    // Method untuk melayani pelanggan (dequeue)
    void dequeue() {
        if (front == null) {
            System.out.println("Antrean kosong.");
            return;
        }

        System.out.println("Melayani pelanggan: " + front.nama);

        // Menghapus node depan
        front = front.next;

        // Jika antrean jadi kosong
        if (front == null) {
            rear = null;
        }
    }

    // Method untuk menampilkan antrean
    void display() {
        if (front == null) {
            System.out.println("Antrean kosong.");
            return;
        }

        Node temp = front;
        int i = 1;

        System.out.println("Pelanggan dalam antrean:");

        while (temp != null) {
            System.out.println(i + ". " + temp.nama);
            temp = temp.next;
            i++;
        }
    }
}
