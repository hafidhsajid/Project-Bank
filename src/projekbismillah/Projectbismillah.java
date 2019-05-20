package projekbismillah;


import java.util.*;

public class Projectbismillah {
    static boolean lama = false;
    static String[][] user = {
        {"Admin", "999999", "ADM", "ADMIN", "100000000"}
    };
    static String[][] usernew = {
    	{}
    };
    static String[][] a;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean out = false;
        
        do {
            Scanner input = new Scanner(System.in);
            System.out.println("============================================");
            System.out.println("Selamat Datang Di Bank Kami");
            System.out.println("============================================");
            System.out.println("Pilih!!: \n1. Login\n2. Daftar");
            System.out.println(user.length);
            int first=in.nextInt();
            if (first==1) {
	            System.out.println("Masukkan Username : ");
	            String username = input.nextLine();
	            System.out.println("Masukkan PIN      : ");
	            String pin = input.nextLine();
	            int login = login(username, pin);
                    if (lama == true) {
                    a = user;
                    }else{
                       a = usernew;
                    }
	            if (login > -1) {
	                do {
	                    System.out.println("No rekening anda: " + user[login][3]);
	                    System.out.println("1. Informasi Saldo\n2. Setor`");
	                    System.out.println("3. Penarikan Tunai");
	                    System.out.println("4. Transfer");
	                    System.out.println("5. Keluar");
	                    System.out.println("Pilihan Anda ?");
	                    int saldo = Integer.parseInt(user[login][4]);
	                    int menu = in.nextInt();
	                    switch (menu) {
	                        case 1:
	                            System.out.println("Saldo Anda");
	                            System.out.println("Rp" + user[login][4]);
	                            break;
	                        case 2:
	                        System.out.println("Saldo Anda");
	                            System.out.println("Rp" + user[login][4]);
	                            System.out.println("Berapa saldo yang ingin anda setor? ");
	                            int saldoIn = in.nextInt();
	                                saldo += saldoIn;                            
	                            user[login][4] = String.valueOf(saldo);
	                            System.out.println("Saldo Anda");
	                            System.out.println("Rp" + user[login][4]);
	                            break;
	                        case 3:
	                            System.out.println("Saldo Anda");
	                            System.out.println("Rp" + user[login][4]);
	                            System.out.println("Berapa saldo yang ingin anda ambil? ");
	                            int saldoOut = in.nextInt();
	                            if (saldoOut < saldo - 50000) {
	                                saldo -= saldoOut;
	                            } else {
	                                System.out.println("Saldo anda tidak mencukupi");
	                            }
	                            user[login][4] = String.valueOf(saldo);
	                            System.out.println("Saldo Anda");
	                            System.out.println("Rp" + user[login][4]);
	                            break;
	                        case 4:
	                            boolean back = false;
	                            do {
	                                String bank = user[login][2];
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
	                                        for (int i = 0; i < user.length; i++) {
	                                            if (rekening.equals(user[i][3])) {
	                                                available = i;
	                                                break;
	                                            }
	                                        }
	                                        if (available > -1) {
	                                            int saldoTarget = Integer.parseInt(user[available][4]);
	                                            String bankTarget = user[available][2];
	                                            if (!bankTarget.equals("IBN")) {
	                                                System.out.println("Bank tujuan bukan Bank IBN");
	                                                break;
	                                            }
	                                            System.out.println("Berapa yang ingin Anda transfer?");
	                                            int transfer = in.nextInt();
	                                            if (transfer < saldo - 50000) {
	                                                saldo -= transfer;
	                                                saldoTarget += transfer;
	                                                user[login][4] = String.valueOf(saldo);
	                                                user[available][4] = String.valueOf(saldoTarget);
	                                            }
	                                        } else {
	                                            System.out.println("no rekening tujuan tidak ditemukan");
	                                        }
	                                        break;
	                                    case 2:
	                                        System.out.println("Rekening Tujuan Anda?");
	                                        rekening = in.next();
	                                        available = -1;
	                                        for (int i = 0; i < user.length; i++) {
	                                            if (rekening.equals(user[i][3])) {
	                                                available = i;
	                                                break;
	                                            }
	                                        }
	                                        if (available > -1) {
	                                            int saldoTarget = Integer.parseInt(user[available][4]);
	                                            String bankTarget = user[available][2];
	                                            if (bankTarget.equals("IBN")) {
	                                                System.out.println("Bank tujuan adalah Bank IBN");
	                                                break;
	                                            }
	                                            System.out.println("Berapa yang ingin Anda transfer?");
	                                            int transfer = in.nextInt();
	                                            if (transfer < saldo - 50000 - 500) {
	                                                saldo -= transfer + 500;
	                                                saldoTarget += transfer;
	                                                user[login][4] = String.valueOf(saldo);
	                                                user[available][4] = String.valueOf(saldoTarget);
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
        } 
        while (!out);
    
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
        int dataLength = user.length;
        String[][] copy = new String[dataLength + 1][5];
        for (int i = 0; i < dataLength; i++) {
            copy[i] = user[i];
        }
        String[] newUser = {username, pin, bank, norek, saldo};
        copy[copy.length - 1] = newUser;
        user = copy;
    }

    public static int login(String username, String pin) {
        int login = -1;

        for (int i = 0; i < user.length; i++) {
            if (username.equals(user[i][0]) && pin.equals(user[i][1])) {
                login = i;
                break;
            }
//        }else{
//            	lama = false;
            }
        return login;
    }

}
