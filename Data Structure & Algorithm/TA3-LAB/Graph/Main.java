import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private List<Vertex> nodes;
    private List<Edge> edges;

    public static void main(String[] args) {
        Main main = new Main();
        main.testExcute();
    }

    public void testExcute() {
        nodes = new ArrayList<Vertex>();
        edges = new ArrayList<Edge>();

        // 1. Inisialisasi Node (Titik A, B, C, D, E)
        String[] nodeNames = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"
            ,"K", "L", "M", "N", "O", "P", "Q", "R", "S", "T"
        };

        for (String name : nodeNames) {
            Vertex location = new Vertex(name, name);
            nodes.add(location);
        }

        // 2. Buat jalur (Edge) beserta jaraknya
        // Index: A=0, B=1, C=2, D=3, E=4 dst...
        addLane("Edge_1", 0, 1, 4); // A ke B jarak 4
        addLane("Edge_2", 1, 2, 3); // B ke C jarak 3
        addLane("Edge_3", 2, 4, 5); // C ke E jarak 5
        addLane("Edge_4", 0, 3, 10); // A ke D jarak 10
        addLane("Edge_5", 3, 4, 6);  // D ke E jarak 6
        addLane("Edge_6", 0, 5, 2);  // A ke F jarak 2
        addLane("Edge_7", 5, 4, 15); // F ke E jarak 15
        addLane("Edge_8", 1, 6, 1);  // B ke G jarak 1
        addLane("Edge_9", 6, 4, 20); // G ke E jarak 20
        addLane("Edge_10", 2, 7, 2); // C ke H jarak 2
        addLane("Edge_11", 7, 4, 8); // H ke E jarak 8
        addLane("Edge_12", 0, 8, 5); // A ke I jarak 5
        addLane("Edge_13", 8, 4, 10); // I ke E jarak 10
        addLane("Edge_14", 0, 9, 3); // A ke J jarak 3
        addLane("Edge_15", 9, 4, 25); // J ke E jarak 25
        addLane("Edge_16", 0, 10, 6); // A ke K jarak 6
        addLane("Edge_17", 10, 4, 12); // K ke E jarak 12
        addLane("Edge_18", 0, 11, 7); // A ke L jarak 7
        addLane("Edge_19", 11, 4, 9); // L ke E jarak 9
        addLane("Edge_20", 0, 12, 8); // A ke M jarak 8

    
        // 3. Proses Input User
        Scanner input = new Scanner(System.in);
        System.out.print("Masukkan titik awal: ");
        String startNodeStr = input.nextLine().toUpperCase().trim();
        System.out.print("Masukkan titik tujuan: ");
        String endNodeStr = input.nextLine().toUpperCase().trim();

        // Cari objek Vertex yang sesuai dengan input teks
        Vertex startNode = findVertexByName(startNodeStr);
        Vertex endNode = findVertexByName(endNodeStr);

        if (startNode == null || endNode == null) {
            System.out.println("Titik tidak ditemukan di dalam Graph.");
            return;
        }

        // 4. Eksekusi Algoritma Dijkstra
        Graph graph = new Graph(nodes, edges);
        DijkstraAlgorithm dijkstra = new DijkstraAlgorithm(graph);
        dijkstra.execute(startNode);
        LinkedList<Vertex> path = dijkstra.getPath(endNode);

        // 5. Cetak Output
        if (path == null) {
            System.out.println("Jalur tidak ditemukan.");
        } else {
            StringBuilder pathFormatted = new StringBuilder();
            for (int i = 0; i < path.size(); i++) {
                pathFormatted.append(path.get(i).getName());
                if (i < path.size() - 1) {
                    pathFormatted.append(" -> ");
                }
            }
            System.out.println("Jalur terpendek ditemukan: " + pathFormatted.toString());
            System.out.println("Jarak total: " + dijkstra.getShortestDistance(endNode) + " km");
        }
    }

    private void addLane(String laneId, int sourceLocNo, int destLocNo, int duration) {
        Edge lane = new Edge(laneId, nodes.get(sourceLocNo), nodes.get(destLocNo), duration);
        edges.add(lane);
    }
    
    // Helper method untuk mencari objek Vertex berdasarkan String namanya (misal "A")
    private Vertex findVertexByName(String name) {
        for (Vertex v : nodes) {
            if (v.getName().equals(name)) {
                return v;
            }
        }
        return null;
    }
}