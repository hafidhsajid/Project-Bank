/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekbismillah;
import java.util.*;
/**
 *
 * @author lenov
 */
public class atm {
    static String[][] user = {
        {"Abdul", "123456", "ABC", "00000000", "500000"},
        {"Akhdan", "234567", "ABC", "00000001", "2000000"},
        {"Ojan", "345678", "Diriman", "11111110", "1500000"},
        {"Royyan", "456789", "IBN", "22222202", "700000"},
        {"Bimo", "567890", "IRB", "33333033", "100000000"}
    };

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean out = false;
        do {
            Scanner input = new Scanner(System.in);
            System.out.println("Masukkan Username : ");

            String username = input.nextLine();
            System.out.println("Masukkan PIN      : ");
            String pin = input.nextLine();
            int login = login(username, pin);
            if (login > -1) {
                do {
                    System.out.println("No rekening anda: " + user[login][3]);
                    System.out.println("1. Informasi Saldo");
                    System.out.println("2. Penarikan Tunai");
                    System.out.println("3. Transfer");
                    System.out.println("4. Keluar");
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
                        case 3:
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
                                }
                            } while (!back);
                            break;

                        case 4:
                            login = -1;
                            break;
                        case 5:
                            daftar();
                    }
                } while (login > -1);
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
        }
        return login;
    }

}

    

