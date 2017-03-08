package com.korkmazm.gorelecumhuriyetiooo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by KorkmazM on 01/03/2017.
 */

public class GridAdapter extends BaseAdapter {

    private Context _Context;
    private final String[] _values;
    private final boolean _gridType;

    public GridAdapter(Context c, String[] values, boolean gridType) {
        this._Context = c;
        this._values = values;
        this._gridType = gridType;
    }

    @Override
    public int getCount() {
        return _values.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        LayoutInflater inflater = (LayoutInflater) _Context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View gridView;

        if (view == null) {

            gridView = new View(_Context);

            if (!_gridType) {
                // get layout from mobile.xml
                gridView = inflater.inflate(R.layout.grid_item, null);

                // set value into textview
                /*TextView textView = (TextView) gridView
                    .findViewById(R.id.grid_item_label);*/
                //textView.setText(_values[i]);

                // set image based on selected text
                ImageView imageView = (ImageView) gridView
                        .findViewById(R.id.grid_item_image);
                //imageView.setLayoutParams(new GridView.LayoutParams(85, 85));
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                imageView.setPadding(8, 8, 8, 8);

                String mobile = _values[i];

                if (mobile.equals("Duolingo")) {
                    imageView.setImageResource(R.drawable.logoduolingo);
                } else if (mobile.equals("Eba")) {
                    imageView.setImageResource(R.drawable.logoeba);
                } else if (mobile.equals("Dyned")) {
                    imageView.setImageResource(R.drawable.logodyned);
                } else if (mobile.equals("EOkulO")) {
                    imageView.setImageResource(R.drawable.logoeokulo);
                } else if (mobile.equals("EOkulV")) {
                    imageView.setImageResource(R.drawable.logoeokulv);
                } else if (mobile.equals("MEB Personel")) {
                    imageView.setImageResource(R.drawable.logomebpersonel);
                } else if (mobile.equals("AOF")) {
                    imageView.setImageResource(R.drawable.logoaof);
                } else if (mobile.equals("Edevlet")) {
                    imageView.setImageResource(R.drawable.logoedev);
                } else if (mobile.equals("Facebook")) {
                    imageView.setImageResource(R.drawable.logofacebook);
                } else if (mobile.equals("Messenger")) {
                    imageView.setImageResource(R.drawable.logomessenger);
                } else if (mobile.equals("Twitter")) {
                    imageView.setImageResource(R.drawable.logotwitter);
                } else if (mobile.equals("Instagram")) {
                    imageView.setImageResource(R.drawable.logoinstagram);
                } else if (mobile.equals("Telegram")) {
                    imageView.setImageResource(R.drawable.logotelegram);
                } else if (mobile.equals("MEBBİS")) {
                    imageView.setImageResource(R.drawable.logomebbis);
                } else if (mobile.equals("Fatih Projesi")) {
                    imageView.setImageResource(R.drawable.logofatih);
                } else if (mobile.equals("E-Devlet")) {
                    imageView.setImageResource(R.drawable.logoedevlet);
                }

            } else {
                gridView = inflater.inflate(R.layout.griditemwithtext, null);

                // set value into textview
                TextView textView = (TextView) gridView
                        .findViewById(R.id.grid_item_label_text);
                textView.setText(_values[i]);

                // set image based on selected text
                ImageView imageView = (ImageView) gridView
                        .findViewById(R.id.grid_item_image_text);
                //imageView.setLayoutParams(new GridView.LayoutParams(85, 85));
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                imageView.setPadding(8, 8, 8, 8);

                String mobile = _values[i];

                if (mobile.equals("Görele Cumhuriyet İO")) {
                    imageView.setImageResource(R.drawable.cumilogo);
                } else if (mobile.equals("Görele Cumhuriyet OO")) {
                    imageView.setImageResource(R.drawable.cumologo);
                } else if (mobile.equals("Duyurular")) {
                    imageView.setImageResource(R.drawable.duyurularlogo);
                } else if (mobile.equals("İlçe MEB")) {
                    imageView.setImageResource(R.drawable.gorelemeblogo);
                } else if (mobile.equals("İl MEB")) {
                    imageView.setImageResource(R.drawable.gorelemeblogo);
                } else if (mobile.equals("MEB")) {
                    imageView.setImageResource(R.drawable.meblogo);
                } else if (mobile.equals("Belediye")) {
                    imageView.setImageResource(R.drawable.belediyelogo);
                } else if (mobile.equals("Kaymakamlık")) {
                    imageView.setImageResource(R.drawable.kaymakamliklogo);
                }
            }
        } else {
            gridView = (View) view;
        }

        return gridView;
    }
}
