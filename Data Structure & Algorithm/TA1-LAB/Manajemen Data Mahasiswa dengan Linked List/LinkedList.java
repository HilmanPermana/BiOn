class LinkedList {
    NodeMhs head, tail;

    // Method untuk menambah mahasiswa
    void tambahMhs(String nim, String nama, int nilai) {
        NodeMhs newNode = new NodeMhs(nim, nama, nilai);

        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }

        System.out.println("Data mahasiswa berhasil ditambahkan.");
    }

    // Method untuk menampilkan data mahasiswa
    void tampilMhs(){
        System.out.println("Daftar Mahasiswa:");
        NodeMhs current = head;
        int nomor = 1;
        while (current != null){
            System.out.println(nomor + ". NIM: " + current.getNim() + ", Nama: " + current.getNama() + ", Nilai: " + current.getNilai());
            current = current.next;
            nomor++;
        }
    }

    // Menghapus mahasiswa berdasarkan NIM
    void hapusMhs(String nim){
        NodeMhs current = head;
        
        while(current != null){
            if(current.getNim().equals(nim)){
                if(current == head){
                    head = current.next;
                    if(head != null){
                        head.prev = null;
                    }
                } else if(current == tail){
                    tail = current.prev;
                    if(tail != null){
                        tail.next = null;
                    }
                } else {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                }
            }
            current = current.next;
        }

        System.out.println("Data mahasiswa berhasil dihapus.");
    }

    // Memperbarui data mahasiswa berdasarkan NIM
    void updateNilaiMhs(String nim, String nama, int nilai){
        System.out.println("Daftar Mahsiswa Setelah update: ");
        NodeMhs current = head;
        while(current != null){
            if(current.getNim().equals(nim)){
                current.setNilai(nilai);
            }
            current = current.next;
        }
    }
}
