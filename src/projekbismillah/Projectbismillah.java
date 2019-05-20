package projekbismillah;

import java.util.*;

public class Projectbismillah {

    static int lama = 0;
//    1=array user
//    2 array stelah cek usr
//    3 array usernew
    static int login = 0;
//    lama user
    static String[][] user = {
//        {"Admin", "999999", "ADM", "ADMIN", "100000000"},
        {"admin", "123123", "ADM", "ADMIN", "100000000"}
    };
//    baru user
    static String[][] usernew = {
        {"Admin", "999999", "ADM", "ADMIN", "100000000"}
    };
    static String[][] a = {{}};

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean out = false;

        do {
            Scanner input = new Scanner(System.in);
            System.out.println("============================================");
            System.out.println("Selamat Datang Di Bank Kami");
            System.out.println("============================================");
            System.out.println("Pilih!!: \n1. Login\n2. Daftar");
            System.out.println(usernew.length);
            System.out.println(a.length);
            int first = in.nextInt();
            if (first == 1) {
                System.out.println("Masukkan Username : ");
                String username = input.nextLine();
                System.out.println("Masukkan PIN      : ");
                String pin = input.nextLine();
                login(username, pin);
                System.out.println(lama);
                if (lama == 1) {
//                    for (int i = 0; i < user.length; i++) {
//                        for (int j = 0; j < user.length; j++) {
//                            a[i][j] = user[i][j];
//                        }
//                    }
                    a = user;
                } 
                else  
                {
//                    for (int i = 0; i < usernew.length; i++) {
//                        for (int j = 0; j < usernew.length; j++) {
//                            a[i][j] = user[i][j];
//                        }
//                    }
                    a = usernew;
                }
                    if (login > -1) {
                        do {
                            System.out.println("No rekening anda: " + a[login+1][3]);
                            System.out.println("1. Informasi Saldo\n2. Setor`");
                            System.out.println("3. Penarikan Tunai");
                            System.out.println("4. Transfer");
                            System.out.println("5. Keluar");
                            System.out.println("Pilihan Anda ?");
                            int saldo = Integer.parseInt(a[login+1][4]);
                            int menu = in.nextInt();
                            switch (menu) {
                                case 1:
                                    System.out.println("Saldo Anda");
                                    System.out.println("Rp" + a[login+1][4]);
                                    break;
                                case 2:
                                    System.out.println("Saldo Anda");
                                    System.out.println("Rp" + a[login+1][4]);
                                    System.out.println("Berapa saldo yang ingin anda setor? ");
                                    int saldoIn = in.nextInt();
                                    saldo += saldoIn;
                                    a[login+1][4] = String.valueOf(saldo);
                                    System.out.println("Saldo Anda");
                                    System.out.println("Rp" + a[login+1][4]);
                                    break;
                                case 3:
                                    System.out.println("Saldo Anda");
                                    System.out.println("Rp" + a[login+1][4]);
                                    System.out.println("Berapa saldo yang ingin anda ambil? ");
                                    int saldoOut = in.nextInt();
                                    if (saldoOut < saldo - 50000) {
                                        saldo -= saldoOut;
                                    } else {
                                        System.out.println("Saldo anda tidak mencukupi");
                                    }
                                    a[login+1][4] = String.valueOf(saldo);
                                    System.out.println("Saldo Anda");
                                    System.out.println("Rp" + a[login+1][4]);
                                    break;
                                case 4:
                                    boolean back = false;
                                    do {
                                        String bank = a[login+1][2];
                                        System.out.println("1. Ke Bank IBN");
                                        System.out.println("2. Selain ke Bank IBN");
                                        System.out.println("3. Kembali");
                                        System.out.println("Pilihan anda? ");
                                        int fee = 0;
                                        int transMenu = in.nextInt();
                                        switch (transMenu) {
                                            case 1:
                                                System.out.println("Rekening Tujuan Anda?");
                                                in.nextLine();
                                                String rekening = in.nextLine();
                                                int available = -1;
                                                for (int i = 0; i < a.length; i++) {
                                                    if (rekening.equals(a[i][3])) {
                                                        available = i;
                                                        break;
                                                    }
                                                }
                                                if (available > -1) {
                                                    int saldoTarget = Integer.parseInt(a[available][4]);
                                                    String bankTarget = a[available][2];
                                                    if (!bankTarget.equals("IBN")) {
                                                        System.out.println("Bank tujuan bukan Bank IBN");
                                                        break;
                                                    }
                                                    System.out.println("Berapa yang ingin Anda transfer?");
                                                    int transfer = in.nextInt();
                                                    if (transfer < saldo - 50000) {
                                                        saldo -= transfer;
                                                        saldoTarget += transfer;
                                                        a[login+1][4] = String.valueOf(saldo);
                                                        a[available][4] = String.valueOf(saldoTarget);
                                                    }
                                                } else {
                                                    System.out.println("no rekening tujuan tidak ditemukan");
                                                }
                                                break;
                                            case 2:
                                                System.out.println("Rekening Tujuan Anda?");
                                                rekening = in.next();
                                                available = -1;
                                                for (int i = 0; i < a.length; i++) {
                                                    if (rekening.equals(a[i][3])) {
                                                        available = i;
                                                        break;
                                                    }
                                                }
                                                if (available > -1) {
                                                    int saldoTarget = Integer.parseInt(a[available][4]);
                                                    String bankTarget = a[available][2];
                                                    if (bankTarget.equals("IBN")) {
                                                        System.out.println("Bank tujuan adalah Bank IBN");
                                                        break;
                                                    }
                                                    System.out.println("Berapa yang ingin Anda transfer?");
                                                    int transfer = in.nextInt();
                                                    if (transfer < saldo - 50000 - 500) {
                                                        saldo -= transfer + 500;
                                                        saldoTarget += transfer;
                                                        a[login+1][4] = String.valueOf(saldo);
                                                        a[available][4] = String.valueOf(saldoTarget);
                                                    }
                                                } else {
                                                    System.out.println("no rekening tujuan tidak ditemukan");
                                                }
                                                break;
                                            case 3:
                                                back = true;
                                                break;
                                            // case 4:
                                            // 	daftar();
                                        }
                                    } while (!back);
                                    break;

                                // case 5:
                                // 	daftar();
                                case 5:
                                    login = -1;
                                    break;
                            }
                        } while (login > -1);
                    }
                }else {
                    daftar();
                }
        } while (!out);

    }

    public static void daftar() {
        Scanner in = new Scanner(System.in);
        System.out.println("username : ");
        String username = in.nextLine();
        System.out.println("PIN : ");
        String pin = in.nextLine();
        String bank = "IBN";
        String norek = "";
        for (int i = 0; i < 8; i++) {
            norek += String.valueOf(Math.round(Math.random() * 10));
        }
        int saldoInt = 50000;
        String saldo = String.valueOf(saldoInt);
        int dataLength = usernew.length;
        String[][] copy = new String[dataLength + 1][5];
        int a = copy.length;
        System.out.println(a);
        for (int i = 0; i < dataLength; i++) {
            copy[i] = usernew[i];
        }
////        print copy
//for (int i = 0; i < copy.length; i++) {
//            for (int j = 0; j < 5; j++) {
//                System.out.print(copy[i][j]+" ");
//        
//    }System.out.println("");
//            
//        }
        String[] newUser = {username, pin, bank, norek, saldo};
        copy[copy.length-1] = newUser;
        
////        print copy
for (int i = 0; i < copy.length; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(copy[i][j]+" ");
        
    }
System.out.println("");
        
        usernew = copy;
    }
    }
    public static int login(String username, String pin) {
        int login = -1;
        if (login == -1) {
            if (lama == 0) {
                for (int i = 0; i < user.length; i++) {
                    if (username.equals(user[i][0]) && pin.equals(user[i][1])) {
                        login = i;
                        lama = 1;
//                        login = 1;
                        break;
                    }
                    lama = 2;
//                    else {
//                        lama = 0;
//                        
//                    }
                }
//                lama = 2;
                if (lama == 2) {
                    for (int i = 0; i < usernew.length; i++) {
                        if (username.equals(usernew[i][0]) && pin.equals(usernew[i][1])) {
                            login = i;
                            lama = 3;
//                            login =1;
                            break;
                        }
                    }
                }
            }
        }return login;
    }

}
