package com.example.BinarApp.CONTROLLER;

import com.example.BinarApp.SERVICE.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.text.ParseException;
import java.util.Scanner;

@Component
public class MainController {
    @Autowired
    private UserService userService;

    Scanner scanner = new Scanner(System.in);
    private String SEPARATOR = "=================================";
    @PostConstruct
    public void init() throws ParseException {
        ShowLoginAplication();
    }

    public void ShowLoginAplication() {
        System.out.println(SEPARATOR +
                "\nSELAMAT DATANG DI BINAR FOOD\n" +
                SEPARATOR +
                " " +
                "\nSILAHKAN LOGIN TERLEBIH DAHULU");
        System.out.println(" ");
        System.out.println("1. Login Untuk Masuk");
        System.out.println("2. Daftar Akun");
        System.out.print("=>");
        int pilihan = scanner.nextInt();
        if(pilihan == 1){
            LoginUser();
        } if(pilihan == 2) {
            registerAccount();
        }
        System.exit(0);
    }
    public void registerAccount() {
        System.out.print(SEPARATOR+
                "\nMasukan Email\t\t: ");
        String inputEmail = scanner.next();
        System.out.print("Masukan User Name \t: ");
        String inputUsername = scanner.next();
        System.out.print("Masukan Password \t: ");
        String inputpassword = scanner.next();
        String result= userService.register(inputEmail,inputUsername,inputpassword);
        System.out.println(result);
        System.out.println("Masukan angka 1 untuk kembali ke halaman Utama");
        System.out.print("=>");
        int pilihan = scanner.nextInt();

        if (pilihan == 1) {
            ShowLoginAplication();
        }

    }
    public void LoginUser(){
        System.out.print(SEPARATOR+
                "\nMasukan User Name \t: ");
        String inputUsername = scanner.next();
        System.out.print("Masukan Password \t: ");
        String inputpassword = scanner.next();
        System.out.println("Masukan Angka 1 untuk melanjutkan ");
        System.out.print("=>");
        int pilihan = scanner.nextInt();
        if(pilihan == 1){
//            this.showProductName();
        }

    }

    public void showMerchant(){

    }
//    public void showProductName() {
//        System.out.println(SEPARATOR +
//                "\nSilahkan Pilih Makanan :\n"+
//                SEPARATOR);
//        productService.getDisplaysAvailableProducts().forEach(product -> {
//            System.out.println("No. \t\t | \t\t Menu \t\t | \t\t Harga");
//            System.out.println(product.getProductName()+"\t | \t" + product.getPrice());
//        });
//
//
//        System.out.println("99. Pesan dan Bayar");
//        System.out.println("0. Keluar Aplikasi ");
//        System.out.print("=> ");
//        int pilihan = scanner.nextInt();
//    }

}
