package com.korkmazm.gorelecumhuriyetiooo;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

/**
 * Created by KorkmazM on 15/02/2017.
 */

public class ExpandableListAdapter extends BaseExpandableListAdapter {

    private Context _context;
    private List<String> _expandableListTitle;
    private HashMap<String, List<String>> _expandableListDetail;



    public ExpandableListAdapter(Context context, List<String> expandableListTitle,
                                 HashMap<String, List<String>> expandableListDetail){
        this._context = context;
        this._expandableListTitle = expandableListTitle;
        this._expandableListDetail = expandableListDetail;
    }

    @Override
    public int getGroupCount() {
        return this._expandableListTitle.size();
    }

    @Override
    public int getChildrenCount(int listPosition) {
        return this._expandableListDetail.get(this._expandableListTitle.get(listPosition)).size();
    }

    @Override
    public Object getGroup(int listPosition) {

        return this._expandableListTitle.get(listPosition);
    }

    @Override
    public Object getChild(int listPosition, int expandedListPosition) {
        return this._expandableListDetail.get(this._expandableListTitle.get(listPosition))
                .get(expandedListPosition);
    }

    @Override
    public long getGroupId(int listPosition) {

        return listPosition;
    }

    @Override
    public long getChildId(int i, int i1) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int listPosition, boolean isExpanded, View convertView,
                             ViewGroup parent) {
        String listTitle = (String)getGroup(listPosition);

        if (convertView == null){
            LayoutInflater layoutInflater = (LayoutInflater)this._context.getSystemService(
                    Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.list_group, null);
        }

        TextView listTitleTextView = (TextView)convertView.findViewById(R.id.listTitle);
        listTitleTextView.setTypeface(null, Typeface.BOLD);
        listTitleTextView.setText(listTitle);

        return convertView;
    }

    @Override
    public View getChildView(int listPosition, int expandedListPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {
        final String expandedListText = (String)getChild(listPosition,expandedListPosition);
        final String listText = (String) getGroup(listPosition);

        if (convertView == null){
            LayoutInflater layoutInflater = (LayoutInflater)this._context.getSystemService(
                    Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.list_item, null);
        }

        TextView expandedListTextView = (TextView)
                convertView.findViewById(R.id.expandedListItem);
        expandedListTextView.setText(expandedListText);

        ImageView expandedListImageView = (ImageView)
                convertView.findViewById(R.id.expandableLİstImage);

        if (listText.equals("OKULUMUZ")) {
            if (expandedListText.equals("Cumhuriyet İlk Okulu")) {
                expandedListImageView.setImageResource(R.drawable.cumilogo);
            }else if (expandedListText.equals("Cumhuriyet Orta Okulu")) {
                expandedListImageView.setImageResource(R.drawable.cumologo);
            }else if ( expandedListText.equals("Facebook Sayfamız")){
                expandedListImageView.setImageResource(R.drawable.cumface);
            }
        }else if (listText.equals("UYGULAMALAR")) {
            if (expandedListText.equals("EBA")) {
                expandedListImageView.setImageResource(R.drawable.ebalogo);
            } else if (expandedListText.equals("DYNET")) {
                expandedListImageView.setImageResource(R.drawable.dynedlogo);
            } else if (expandedListText.equals("E-Okul")) {
                expandedListImageView.setImageResource(R.drawable.eokullogo);
            } else if (expandedListText.equals("MEBBİS")) {
                expandedListImageView.setImageResource(R.drawable.mebbislogo);
            }else if (expandedListText.equals("Duolingo")){
                expandedListImageView.setImageResource(R.drawable.duolingologo);
            }else if (expandedListText.equals("Fatih Projesi")) {
                expandedListImageView.setImageResource(R.drawable.fatihlogo);
            }
        }else if (listText.equals("HABERLER")){
            if (expandedListText.equals("Acil Duyurular")){
                expandedListImageView.setImageResource(R.drawable.duyurularlogo);
            }else if (expandedListText.equals("İlçe MEB")){
                expandedListImageView.setImageResource(R.drawable.gorelemeblogo);
            }else if (expandedListText.equals("İl MEB")){
                expandedListImageView.setImageResource(R.drawable.gorelemeblogo);
            }else if (expandedListText.equals("Başkanlık MEB")){
                expandedListImageView.setImageResource(R.drawable.meblogo);
            }
        }else if (listText.equals("DIŞ BAĞLANTILAR")){
            if (expandedListText.equals("E-Devlet")){
                expandedListImageView.setImageResource(R.drawable.edevletlogo);
            }else if (expandedListText.equals("Görele Belediyesi")){
                expandedListImageView.setImageResource(R.drawable.belediyelogo);
            }else if (expandedListText.equals("Görele Kymakamlığı")){
                expandedListImageView.setImageResource(R.drawable.kaymakamliklogo);
            }
        }
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }
}
