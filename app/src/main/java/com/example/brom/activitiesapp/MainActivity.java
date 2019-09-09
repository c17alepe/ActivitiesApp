package com.example.brom.activitiesapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import android.content.Intent;
import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    private String[] mountainNames = {"Matterhorn","Mont Blanc","Denali"};
    private String[] mountainLocations = {"Alps","Alps","Alaska"};
    private int[] mountainHeights ={4478,4808,6190};
    // Create ArrayLists from the raw data above and use these lists when populating your ListView.

    ArrayList<Mountain> mountainData=new ArrayList<>();

    Mountain Matterhorn = new Mountain("Matterhorn", "Alps", 4478);
    Mountain Mont_Blanc = new Mountain("Mont Blanc", "Alps", 4808);
    Mountain Denali = new Mountain("Denali", "Alaska", 6190);

    ArrayList<String> listData=new ArrayList<>(Arrays.asList(mountainNames));
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this, R.layout.list_item_textview,R.id.list_item_textview, listData);

        mountainData.add(Matterhorn);
        mountainData.add(Mont_Blanc);
        mountainData.add(Denali);

        ListView listView=(ListView) findViewById(R.id.listview);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                Intent mInfo = new Intent(MainActivity.this, MountainDetailsActivity.class);

                String bergData= ""+ mountainData.get(position).Name()+ " \n " +  mountainData.get(position).Location()+ "\n " + mountainData.get(position).Height();
                mInfo.putExtra("berg", bergData);

                startActivity(mInfo);
            }
        });

        // 2. Create a new activity named "MountainDetailsActivity
        // 3. Create a new Layout file for the MountainDetailsActivity called
        //    "activity_mountaindetails". MountainDetailsActivity must have MainActivity as its
        //    ´parent activity.
        // 4. The layout file created in step 3 must have a LinearLayout
        // 5. The layout file created in step 3 must be able to display
        //    * Mountain Name
        //    * Mountain Location
        //    * Mountain Height
        // 6. When tapping on a list item: create an Intent that includes
        //    * Mountain Name
        //    * Mountain Location
        //    * Mountain Height
        // 7. Display the MountainDetailsActivity with the data from the Intent created in step
        //    6
        // 8. From the MountainDetailsActivity you should have an option to "go back" using an
        //    left arro button. This is done by letting the MainActivity be the parent activity to
        //    MountainDetailsActivity.
    }
}
