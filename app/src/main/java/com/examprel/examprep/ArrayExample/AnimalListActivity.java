package com.examprel.examprep.ArrayExample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.examprel.examprep.R;

import java.util.ArrayList;

public class AnimalListActivity extends AppCompatActivity {
    ArrayList<String> animalList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_list);
ListView animal = (ListView)findViewById(R.id.listViewAnimals);
        animalList = new ArrayList<String>();
        getAnimalName();

        ArrayAdapter<String> arrayAdapter =
                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,animalList);
        animal.setAdapter(arrayAdapter);
        animal.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String ani = animalList.get(position);
                Toast.makeText(getApplicationContext(),""+position,Toast.LENGTH_SHORT).show();
            }
        });

}

    private void getAnimalName() {
        animalList.add("Horse");
        animalList.add("Goat");
        animalList.add("Cow");
        animalList.add("Ass");
        animalList.add("Buffalo");
        animalList.add("Lion");
        animalList.add("Tiger");
        animalList.add("Deer");
        animalList.add("Snake");
        animalList.add("Lamb");
        animalList.add("Elephant");
    }
    }
