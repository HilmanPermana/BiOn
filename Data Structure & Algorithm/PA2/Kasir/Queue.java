public class Queue {
    Node front, rear; //front = depan antrian, rear = belakang antrian

    public boolean minLima(){
        int count = 0;
        Node curr = front;
        while(curr != null){
            count++;
            curr = curr.next;
        }
        return count >= 5;
    }

    // Method untuk menambah pelanggan ke antrian (Enqueue)
    void enqueue(String noAntrian, String namaPelanggan, int totalBelanja){
        System.out.println();
        Node newNode = new Node(noAntrian, namaPelanggan, totalBelanja);

        //Jika antrian kosong
        if(rear == null){
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }

        System.out.println("Pelanggan " + newNode.namaPelanggan + " Telah Ditambahkan ke Antrian");
        System.out.println();
    }

    // Method untuk melayani pelanggan (Dequeue)
    void dequeue(Stack riwayatStack){
        System.out.println();
        if(front == null){
            System.out.println("Antrian Kosong.");
            return;
        }

        System.out.println("Melayani pelanggan " + front.noAntrian + " (" + front.namaPelanggan + ")");

        riwayatStack.push(front.noAntrian, front.namaPelanggan, front.totalBelanja);

        // Menghapus Node Depan
        front = front.next;

        // Apabila antrian jadi kosong
        if(front == null){
            rear = null;
        }
    }

    // Method untuk menampilkan antrian
    void display(){
        System.out.println();
        if(front == null){
            System.out.println("Antrian Kosong.");
            return;
        }

        Node temp = front;
        int i = 1;

        System.out.println("Pelanggan dalam antrian : ");

        while(temp != null){
            System.out.println(i + ". " + temp.namaPelanggan);
            temp = temp.next;
            i++;
        }
    }


}
