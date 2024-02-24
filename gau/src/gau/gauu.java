package gau;

import java.util.Scanner;

public class gauu {
    public static void main(String[] args) {
        String islemSecenekleri = "Bakiye goruntuleme --- 1\n"
                + "Para cekmek --- 2\n"
                + "Farkli hesaba para yatirmak --- 3\n"
                + "Çikis yapmak icin 'q' tusuna basiniz.";

        Scanner scanner = new Scanner(System.in);

        double bilalBakiye = 2450;
        String bilalIBAN = "TR1265 0780 127 985 345 7572 1389";
        String bilalKullaniciString = "bilal12";
        String bilalSifreString = "123";

        double enesBakiye = 1200;
        String enesIBANString = "TR1234 000 567 985 345 6572 2345";
        String enesKullaniciString = "enes55";
        String enesSifreString = "456";

        System.out.println("ATM'ye HOsGELDINIZ");
        System.out.println("Lutfen bilgilerinizi giriniz");
        System.out.print("Kullanici Adi: ");
        String kullaniciAdiString = scanner.nextLine();
        System.out.print("Sifre: ");
        String sifreString = scanner.nextLine();

        boolean girisBasarili = false;

        if (kullaniciAdiString.equals(bilalKullaniciString) && sifreString.equals(bilalSifreString)) {
            System.out.println("Bilal Camur Hesabina Giris Yapildi");
            girisBasarili = true;
        } else if (kullaniciAdiString.equals(enesKullaniciString) && sifreString.equals(enesSifreString)) {
            System.out.println("Enes Bayram Hesabina Giris Yapildi");
            girisBasarili = true;
        } else {
            System.out.println("Kullanici adiniz veya sifreniz yanlis!");
        }

        if (girisBasarili) {
            System.out.println(islemSecenekleri);
            System.out.print("Lütfen bir secim yapiniz: ");
            String secim = scanner.nextLine();

            switch (secim) {
                case "1":
                    if (kullaniciAdiString.equals(bilalKullaniciString)) {
                        System.out.println("Bakiyeniz: " + bilalBakiye);
                    } else if (kullaniciAdiString.equals(enesKullaniciString)) {
                        System.out.println("Bakiyeniz: " + enesBakiye);
                    }
                    break;
                case "2":
                    System.out.print("Cekmek istediginiz tutari giriniz: ");
                    int cekilecekTutar = scanner.nextInt();
                    scanner.nextLine(); // sonraki satırı okumak için

                    if (kullaniciAdiString.equals(bilalKullaniciString)) {
                        if (bilalBakiye >= cekilecekTutar) {
                            bilalBakiye -= cekilecekTutar;
                            System.out.println("Kalan tutar: " + bilalBakiye);
                        } else {
                            System.out.println("Bakiyenizden fazla para cekemezsiniz");
                        }
                    } else if (kullaniciAdiString.equals(enesKullaniciString)) {
                        if (enesBakiye >= cekilecekTutar) {
                            enesBakiye -= cekilecekTutar;
                            System.out.println("Kalan tutar: " + enesBakiye);
                        } else {
                            System.out.println("Bakiyenizden fazla para cekemezsiniz");
                        }
                    }
                    break;
                case "3":
                    System.out.print("Ne kadar yatirmak istiyorsunuz? ");
                    int yatirilacakTutar = scanner.nextInt();
                    scanner.nextLine(); // sonraki satırı okumak için

                    if (kullaniciAdiString.equals(bilalKullaniciString)) {
                        if (yatirilacakTutar <= bilalBakiye) {
                            System.out.print("IBAN giriniz: ");
                            String yatirilacakIBAN = scanner.nextLine();
                            if (yatirilacakIBAN.equals(enesIBANString)) {
                                System.out.println("Para Enes Bayram Adli Kisiye Yatiriliyor");
                                bilalBakiye -= yatirilacakTutar;
                                enesBakiye += yatirilacakTutar;
                            } else {
                                System.out.println("Gecersiz IBAN!");
                            }
                        } else {
                            System.out.println("Yatirmak istediginiz tutar bakiyenizden fazla!");
                        }
                    } else if (kullaniciAdiString.equals(enesKullaniciString)) {
                        if (yatirilacakTutar <= enesBakiye) {
                            System.out.print("IBAN giriniz: ");
                            String yatirilacakIBAN = scanner.nextLine();
                            if (yatirilacakIBAN.equals(bilalIBAN)) {
                                System.out.println("Para Bilal Camur Adli Kisiye Yatiriliyor");
                                enesBakiye -= yatirilacakTutar;
                                bilalBakiye += yatirilacakTutar;
                            } else {
                                System.out.println("Gecersiz IBAN!");
                            }
                        } else {
                            System.out.println("Yatirmak istediginiz tutar bakiyenizden fazla!");
                        }
                    }
                    break;
                default:
                    System.out.println("Gecersiz bir secim yaptiniz!");
            }
        }
    }
}