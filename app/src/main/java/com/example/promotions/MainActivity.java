package com.example.promotions;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.promotions.rest.ServicePromotionRest;
import com.example.promotions.entite.Promotion;
import com.example.promotions.rest.IServicePromotionRest;

import java.io.Serializable;
import java.util.List;

import retrofit2.Response;
import retrofit2.Callback;
import retrofit2.Call;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static String TAG= "Main";
    private IServicePromotionRest serviceRest;
    private EditText nom;
    private EditText prenom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        serviceRest = ServicePromotionRest.getInstance();

        Button submit = (Button)findViewById(R.id.submit);
        submit.setOnClickListener(this);

        Button addEtudiant = (Button)findViewById(R.id.addEtudiant);
        addEtudiant.setOnClickListener(this);
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

            serviceRest.getPromotions().enqueue(new Callback<List<Promotion>>() {

                @Override
                public void onResponse(Call<List<Promotion>> call, Response<List<Promotion>> response) {
                    if (response.isSuccessful()) {
                        List<Promotion> promotions = response.body();
                        Log.i(TAG,"promotions=" + promotions);
                        Intent intent = new Intent(MainActivity.this, PromotionActivity.class);
                        intent.putExtra("promotions", (Serializable) promotions);
                        startActivity(intent);
                    }
                }

                @Override
                public void onFailure(Call<List<Promotion>> call, Throwable t) {
                    Log.i(TAG,"ERREUR - getPromotions");
                }
            });

            return true;

        } else if(itemId == 2) {

            Log.i(TAG, "Voir tous les étudiants");

            return true;

        } else if(itemId == 3) {

            Log.i(TAG, "Ajouter un étudiant");

            Intent intent = new Intent(MainActivity.this, EtudiantActivity.class);
            startActivity(intent);

            return true;

        } else {

            return false;
        }
    }

    @Override
    public void onClick(View v){

      if (v.getId() == R.id.submit) {

          Log.i(TAG, "onClick pour affichage liste promotion");

         serviceRest.getPromotions().enqueue(new Callback<List<Promotion>>() {

              @Override
              public void onResponse(Call<List<Promotion>> call, Response<List<Promotion>> response) {

                  if (response.isSuccessful()) {

                      List<Promotion> promotions = response.body();
                      Log.i(TAG,"promotions=" + promotions);

                      Intent intent = new Intent(MainActivity.this, PromotionActivity.class);
                      intent.putExtra("promotions", (Serializable) promotions);

                      startActivity(intent);
                  }

              }

              @Override
              public void onFailure(Call<List<Promotion>> call, Throwable t) {
                  Log.i(TAG,"ERREUR - getPromotions");
              }

          });
         addEtudiant(nom, prenom);
      }
      else if (v.getId() == R.id.addEtudiant) {

          Intent intent = new Intent(MainActivity.this, EtudiantActivity.class);
          startActivity(intent);
      }
    }

    public void addEtudiant(EditText nom, EditText prenom){

        Log.i(TAG,"Etudiant = " + nom + prenom);

    }
}