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
            "Jl. Merbabu No.38, Oro-oro Dowo, Kec. Klojen, Kota Malang, Jawa Timur 65112",
            "Jl. Bandung No.18, Penanggungan, Kec. Klojen, Kota Malang, Jawa Timur 65113",
            "Jl. Ronggo Warsito No.15, Klojen, Kec. Klojen, Kota Malang, Jawa Timur 65111",
            "Jl. Pajajaran No.2, Klojen, Malang, Jawa Timur, 65119",
            "Jl. Bandung No.5, Penanggungan, Kec. Klojen, Kota Malang, Jawa Timur 65113",
            "JL. Kalpataru 5, No. 01, Jatimulyo, Kec. Lowokwaru, Kota Malang, Jawa Timur 65141",
            "Jl. Kalpataru No.92, Jatimulyo, Kec. Lowokwaru, Kota Malang, Jawa Timur 65141  ",
            "Jl. Raya Tlogomas No.48A, Tlogomas, Kec. Lowokwaru, Kota Malang, Jawa Timur 65144",
            "Ruko Sawojajar Mas, Jl. Danau Ranau Blok A No.22-23, Sawojajar, Kec. Kedungkandang, Kota Malang, Jawa Timur 65139",
            "Jl. Bungur No.35, Lowokwaru, Kec. Lowokwaru, Kota Malang, Jawa Timur 65141",
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
