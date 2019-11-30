package com.example.bimbelv1;

import java.util.ArrayList;

public class BimbeData {
    private static String[] bimbelNames = {
            "English First",
            "Ganesha Operation",
            "Neutron",
            "Sony Sugema College",
            "Nurul Fikri",
            "Cahaya Ilmu",
            "Brawijaya Study Club",
            "Insan Madani Institute",
            "IPIEMS",
            "Mitra Walet"
    };

    private static String[] bimbelAlamat = {
            "Jl. Raya Langsep No.2A, Pisang Candi, Kec. Sukun, Kota Malang, Jawa Timur 65146",
            "Jalan Terusan Dieng No. 62-64 Klojen, Pisang Candi, Kec. Sukun, Kota Malang, Jawa Timur 65146",
            "Jl. Bondowoso 2-Malang No.2, Gading Kasri, Kec. Klojen, Kota Malang, Jawa Timur 65115",
            "Jalan Terusan Dieng No. 62-64 Klojen, Pisang Candi, Kec. Sukun, Kota Malang, Jawa Timur 65146",
            "Jl. Bondowoso 2-Malang No.2, Gading Kasri, Kec. Klojen, Kota Malang, Jawa Timur 65115",
            "Jalan Terusan Dieng No. 62-64 Klojen, Pisang Candi, Kec. Sukun, Kota Malang, Jawa Timur 65146",
            "Jl. Bondowoso 2-Malang No.2, Gading Kasri, Kec. Klojen, Kota Malang, Jawa Timur 65115",
            "Jalan Terusan Dieng No. 62-64 Klojen, Pisang Candi, Kec. Sukun, Kota Malang, Jawa Timur 65146",
            "Jalan Terusan Dieng No. 62-64 Klojen, Pisang Candi, Kec. Sukun, Kota Malang, Jawa Timur 65146",
            "Jl. Bondowoso 2-Malang No.2, Gading Kasri, Kec. Klojen, Kota Malang, Jawa Timur 65115",
    };

    private static int[] bimbelImages = {
            R.drawable.logo_ef,
            R.drawable.logo_go,
            R.drawable.logo_n,
            R.drawable.sony,
            R.drawable.nurul,
            R.drawable.cahaya,
            R.drawable.brawijaya,
            R.drawable.insan,
            R.drawable.ipiems,
            R.drawable.walet
    };

    static ArrayList<Bimbel> getListData() {
        ArrayList<Bimbel> list = new ArrayList<>();
        for (int i= 0; i < bimbelNames.length; i++){
            Bimbel bimbel = new Bimbel();
            bimbel.setName(bimbelNames[i]);
            bimbel.setAlamat(bimbelAlamat[i]);
            bimbel.setPhoto(bimbelImages[i]);
            list.add(bimbel);
        }
        return list;
    }
}
