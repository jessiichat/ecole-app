package com.example.promotions;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.promotions.entite.Promotion;

import java.util.List;

public class PromotionItemAdapter extends BaseAdapter {

    private Context context;
    private List<Promotion> promotions;
    private LayoutInflater inflater;

    // constructeur
    public PromotionItemAdapter(Context context, List<Promotion> promotions) {
        this.context = context;
        this.promotions = promotions;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return promotions.size();
    }

    @Override
    public Promotion getItem(int position) {
        return promotions.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup parent) {
        view = inflater.inflate(R.layout.adapter_item_promotions, null);

        //Recuperer le infos de l'objet courrant
        Promotion currentPromotion = getItem(i);
        String itemAcronyme = currentPromotion.getAcronyme();
        String itemIntitule = currentPromotion.getIntitule();

        //On recupere le champs dans lequel on doit positionner le motif et le bilan
        TextView itemMotifView = view.findViewById(R.id.item_acronyme);
        itemMotifView.setText(itemAcronyme);
        TextView itemBilanView = view.findViewById(R.id.item_intitule);
        itemBilanView.setText(itemIntitule);


        return view;
    }
}
