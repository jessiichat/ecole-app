package com.example.promotions;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import com.example.promotions.entite.Promotion;

import java.util.ArrayList;

public class PromotionActivity extends AppCompatActivity implements View.OnClickListener  {

  //  private ArrayAdapter<String> adapter;
  private static String TAG= "PromotionActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_promotion);

        ArrayList<Promotion> promotions = (ArrayList<Promotion>) getIntent().getSerializableExtra("promotions");

        ListView promotionListView = findViewById(R.id.listView);
        promotionListView.setAdapter(new PromotionItemAdapter(this,  promotions));

        Log.i(TAG,"Promotions  = "+ promotions);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0, 1, Menu.NONE, "Voir toutes les promotions");
        menu.add(0, 2, Menu.NONE, "Voir tous les étudiants");
        menu.add(0, 3, Menu.NONE, "Ajouter un étudiant");
        return true;
    }

    // Process clicks on Options Menu items
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        Log.i(TAG, "itemId=" + itemId);

        if(itemId == 1){

            Log.i(TAG, "Voir toutes les promotions");

            return true;

        } else if(itemId == 2) {

            Log.i(TAG, "Voir tous les étudiants");

            return true;

        } else if(itemId == 3) {

            Log.i(TAG, "Ajouter un étudiant");
            Intent intent = new Intent(PromotionActivity.this, EtudiantActivity.class);
            startActivity(intent);

            return true;
        }

        else return false;
    }

    @Override
    public void onClick(View v) {

        //ouverture IHM Dynamique liste des étudiants de la promotion
        Intent intent = new Intent(PromotionActivity.this, ListEtudiantsActivity.class);
        startActivity(intent);

        Log.i(TAG,"coucou");
    }


}