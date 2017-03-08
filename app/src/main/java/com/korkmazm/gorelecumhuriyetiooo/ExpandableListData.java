package com.korkmazm.gorelecumhuriyetiooo;

import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by KorkmazM on 18/02/2017.
 */

public class ExpandableListData {

    public static HashMap<String, List<String>> getData(){

        HashMap<String, List<String>> expandableListDetail = new HashMap<String, List<String>>();

        List<String> okulumuz = new ArrayList<String>();
        okulumuz.add("Cumhuriyet İlk Okulu");
        okulumuz.add("Cumhuriyet Orta Okulu");
        okulumuz.add("Facebook Sayfamız");

        List<String> uygulamalar = new ArrayList<String>();
        uygulamalar.add("EBA");
        uygulamalar.add("DYNET");
        uygulamalar.add("Duolingo");
        uygulamalar.add("E-Okul");
        uygulamalar.add("MEBBİS");
        uygulamalar.add("Fatih Projesi");

        List<String> haberler = new ArrayList<String>();
        haberler.add("Acil Duyurular");
        haberler.add("İlçe MEB");
        haberler.add("İl MEB");
        haberler.add("Başkanlık MEB");

        List<String> disBaglantilar = new ArrayList<String>();
        disBaglantilar.add("E-Devlet");
        disBaglantilar.add("Görele Belediyesi");
        disBaglantilar.add("Görele Kymakamlığı");


        expandableListDetail.put("DIŞ BAĞLANTILAR", disBaglantilar);
        expandableListDetail.put("OKULUMUZ", okulumuz);
        expandableListDetail.put("UYGULAMALAR", uygulamalar);
        expandableListDetail.put("HABERLER", haberler);

        return expandableListDetail;
    }
}
