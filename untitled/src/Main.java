public static void heap(int[] l, int pos, int end) {
    if (end == 1) {
        return;
    }
    int leftNodeIndex = 2 * pos;
    int rightNodeIndex = 2 * pos + 1;

    if (l[leftNodeIndex] > l[pos]) {

    }
    heap(l, pos, end - 1);
}

public class Main {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] l = new int[N + 1];

        for (int i = 1; i < N + 1; i++) {
            int n = sc.nextInt();
            l[i] = n;
        }
        heap(l, 1, N + 1);
        for (int e : l) {
            System.out.println(e);
        }
    }

    public static void heapBuild(int[] l) {
        int length = l.length;
        int pos = length / 2;
        int maxChild = 0;
        while (pos > 0) {
            if (2 * pos + 1 <= length) {
                if (l[2 * pos + 1] < l[2 * pos]) {
                    maxChild = 2 * pos;
                } else {
                    maxChild = 2 * pos + 1;
                }
            } else {
                maxChild = 2 * pos;
            }

            if (l[pos] < l[maxChild]) {
                int tmp = l[pos];
                l[pos] = l[maxChild];
                l[maxChild] = tmp;
            }
            int cur = pos;
            while (cur * 2 <= length) {
                if (2 * cur + 1 <= length) {
                    if (l[2 * cur + 1] < l[2 * cur]) {
                        maxChild = 2 * cur;
                    } else {
                        maxChild = 2 * cur + 1;
                    }
                } else {
                    maxChild = 2 * cur;
                }

                if (l[cur] < l[maxChild]) {
                    int tmp = l[cur];
                    l[cur] = l[maxChild];
                    l[maxChild] = tmp;
                    cur = maxChild;
                } else {
                    break;
                }
            }
            pos--;

        }
    }
}

