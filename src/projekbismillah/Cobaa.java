package projekbismillah;

import java.util.Scanner;

public class Cobaa {
    static String[][] telpon = new String[100][5];
    static Scanner scan = new Scanner(System.in);
    static int count;
    
    static void menu() {
        System.out.println("1. Tambah Kontak");
        System.out.println("2. Lihat Kontak");
        System.out.println("3. Cari Kontak");
        System.out.println("4. Ubah Kontak");
        System.out.println("5. Hapus");
        System.out.println("6. Keluar");
    }

    static void tambah() {
            System.out.print("Masukkan Nama Pendek : ");
            telpon[count][0] = scan.next();
            System.out.print("Masukkan Alamat : ");
            telpon[count][1] = scan.next();
            System.out.print("Masukkan No.Telp : ");
            telpon[count][2] = scan.next();
            System.out.print("Masukkan Provider : ");
            telpon[count][3] = scan.next();
            System.out.print("Masukkan Grup : ");
            telpon[count][4] = scan.next();
            System.out.println("Berhasil Menambahkan Kontak !");
            System.out.println("----------------------------------");
            count++;
    }
    
    static void lihat() {
        System.out.println("Lihat\t: ");
        System.out.println("---------------------------------------------------------------------------");
        System.out.printf("| %-10s | %-20s | %-10s | %-10s | %-10s|", "Nama", "Alamat", "No.Hp", "Provider", "Grup");
        System.out.println("\n---------------------------------------------------------------------------");
        for (int i = 0; i < count; i++) {
                System.out.printf("| %-10s | %-20s | %-10s | %-10s | %-10s|\n", telpon[i][0], telpon[i][1], telpon[i][2], telpon[i][3], telpon[i][4]);
        }
        System.out.println(" ");
    }
    
    static void ubah() {
        System.out.println("Masukkan data yang akan diubah!");
        System.out.println("Masukkan indeks\t: ");
        int temp = scan.nextInt();
        
        //ubah semua
        /*System.out.print("Masukkan Nama Pendek : ");
        telpon[temp][0] = scan.next();
        System.out.print("Masukkan Alamat : ");
        telpon[temp][1] = scan.next();
        System.out.print("Masukkan No.Telp : ");
        telpon[temp][2] = scan.next();
        System.out.print("Masukkan Provider : ");
        telpon[temp][3] = scan.next();
        System.out.print("Masukkan Grup : ");
        telpon[temp][4] = scan.next();
        System.out.println("Berhasil Menambahkan Kontak !");
        System.out.println("----------------------------------");*/
        
        System.out.println("Apa yang ingin anda ganti?");
        System.out.println("1. Nama");
        System.out.println("2. Alamat");
        System.out.println("3. No.Telp");
        System.out.println("4. Provider");
        System.out.println("5. Grup");
        int pilih = scan.nextInt();
        
        if(pilih==1) {
            System.out.print("Masukkan Nama Pendek : ");
            telpon[temp][0] = scan.next();
        }
        else if(pilih==2) {
            System.out.print("Masukkan Alamat : ");
            telpon[temp][1] = scan.next();
        }
        else if(pilih==3) {
            System.out.print("Masukkan No.Telp : ");
            telpon[temp][2] = scan.next();
        }
        else if(pilih==4) {
            System.out.print("Masukkan Provider : ");
            telpon[temp][3] = scan.next();
        }
        else if(pilih==5) {
            System.out.print("Masukkan Grup : ");
            telpon[temp][4] = scan.next();
        }
        else {
            System.out.println("bacot!");
        }
    }
    
    static void hapus() {
        System.out.println("PILIH DATA YANG DIHAPUS ANJENG!");
        System.out.println("Masukkan indeks\t: ");
        int temp = scan.nextInt();
        
        for (int i = temp; i < count; i++) {
            telpon[i][0] = telpon[i+1][0];
            telpon[i][1] = telpon[i+1][1];
            telpon[i][2] = telpon[i+1][2];
            telpon[i][3] = telpon[i+1][3]; 
            telpon[i][4] = telpon[i+1][4];
        }
        count--;
    }
    
    static void cari() {
        System.out.print("INPUT INDEKS YANG DICARI BANGST! : ");
        int temp = scan.nextInt();
        
        System.out.println("---------------------------------------------------------------------------");
        System.out.printf("| %-10s | %-20s | %-10s | %-10s | %-10s|", "Nama", "Alamat", "No.Hp", "Provider", "Grup");
        System.out.println("\n---------------------------------------------------------------------------");
        System.out.printf("| %-10s | %-20s | %-10s | %-10s | %-10s|\n", telpon[temp][0], telpon[temp][1], telpon[temp][2], telpon[temp][3], telpon[temp][4]);
            
        
    }
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int pilihan;
        while (true) {
            menu();
            System.out.print("\n=> Pilih Menu : ");
            pilihan = scan.nextInt();
            switch (pilihan) {
                case 1: tambah(); break;
                case 2: lihat(); break;
                case 3: cari(); break;
                case 4: ubah(); break;
                case 5: hapus(); break;
                case 6: System.exit(0); break;
                default: break;
            }
        }
    }
}