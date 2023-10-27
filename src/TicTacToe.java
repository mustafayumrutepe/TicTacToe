import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        String[][] tahta = new String[3][3];
        Scanner scanInt = new Scanner(System.in);
        Scanner scanStr = new Scanner(System.in);
        boolean sira = true;
        boolean devam = true;
        String oyuncu;

        for (int i = 0; i < tahta.length; i++) {
            for (int j = 0; j < tahta[i].length; j++) {
                tahta[i][j] = " ";
            }
        }

        matrisiYazdirVeDolduMu(tahta);

        do {
            do {
                System.out.print("X oyuncusu; [0-2] arası bir satir giriniz: ");
                int sat = scanInt.nextInt();
                System.out.print("X oyuncusu; [0-2] arası bir sutun giriniz: ");
                int sut = scanInt.nextInt();

                if (sat >= 0 && sat <= 2 && sut >= 0 && sut <= 2) {

                    if (tahta[sat][sut].equals(" ")) {
                        tahta[sat][sut] = "X";
                        sira = false;
                    } else {
                        sira = true;
                        System.out.println("\n Seçtiğiniz kutucuk doludur.");
                    }

                } else {
                    System.out.println("\nMatrisin sınırlarını aşan değerler girdiniz");
                    sira = true;
                }
            } while (sira);

            oyuncu = "X";
            kazanan(tahta, oyuncu);
            matrisiYazdirVeDolduMu(tahta);

            do {
                System.out.print("Y oyuncusu; [0-2] arası bir satir giriniz: ");
                int sat = scanInt.nextInt();
                System.out.print("Y oyuncusu; [0-2] arası bir sutun giriniz: ");
                int sut = scanInt.nextInt();

                if (sat >= 0 && sat <= 2 && sut >= 0 && sut <= 2) {

                    if (tahta[sat][sut].equals(" ")) {
                        tahta[sat][sut] = "O";
                        sira = false;
                    } else {
                        sira = true;
                        System.out.println("\n Seçtiğiniz kutucuk doludur.");
                    }

                } else {
                    System.out.println("\nMatrisin sınırlarını aşan değerler girdiniz");
                    sira = true;
                }
            } while (sira);

            oyuncu = "Y";
            kazanan(tahta, oyuncu);
            matrisiYazdirVeDolduMu(tahta);

        } while (devam);


        String[][] ary = new String[3][3];
    }


    public static void matrisiYazdirVeDolduMu(String[][] tahta) {
        boolean doluMu = true;
        for (String[] eleman : tahta) {
            for (String elm : eleman) {
                System.out.print("[" + elm + "]");
                if (elm.equals(" "))
                    doluMu = false;
            }
            System.out.println();
        }
        if (doluMu) {
            System.out.println("Bütün kutucuklar doldu.\n" + "\u001B[32m" + ">> OYUN BİTTİ <<");
            System.exit(0);
        }
    }


    public static void kazanan(String[][] tahta, String oyuncu) {
        for (int i = 0; i < tahta.length; i++) {
            for (int j = 0; j < tahta[i].length; j++) {

                if ((tahta[i][0].equals(tahta[i][1]) && tahta[i][0].equals(tahta[i][2]) && !tahta[i][0].equals(" "))
                        || (tahta[0][j].equals(tahta[1][j]) && tahta[0][j].equals(tahta[2][j]) && !tahta[0][j].equals(" "))) {
                    System.out.println(oyuncu.equals("X") ? "\u001B[32m" + "\nX oyuncusu; !!! TEBRİKLER KAZANDINIZ !!!" : "\u001B[32m" + "\nY oyuncusu; !!! TEBRİKLER KAZANDINIZ !!!");
                    System.exit(0);
                }
            }
        }
    }
}
