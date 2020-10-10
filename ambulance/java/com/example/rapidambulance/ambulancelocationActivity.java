package com.example.rapidambulance;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ambulancelocationActivity extends AppCompatActivity {
    ListView listView;
    TextView textView1;
    Button message,call,btnid;
    //int images[]={R.drawable.dicon5,R.drawable.dicon3,R.drawable.dicon6,R.drawable.dicon1,R.drawable.dicon2};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ambulancelocation);
        listView=findViewById(R.id.listview);
        textView1=findViewById(R.id.textview1);


        // btnid=findViewById(R.id.btnid);
        message=findViewById(R.id.message);

        String mTitle[]=getResources().getStringArray(R.array.locationName);

        MyAdapter adapter=new MyAdapter(this,mTitle);
        listView.setAdapter(adapter);

//        btnid.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View view) {
////                 Intent intent=new Intent(Intent.ACTION_DIAL);
////                  startActivity(intent);
//                String number = "7777777777";
//                Uri call = Uri.parse("tel:" + number);
//                Intent surf = new Intent(Intent.ACTION_CALL, call);
//                startActivity(surf);
//            }
//        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(i==0){

                    Intent intent=new Intent(ambulancelocationActivity.this, com.example.rapidambulance.MenuActivity.class);
                    startActivity(intent);
                }
            }
        });



    }

    class MyAdapter extends ArrayAdapter<String>{
        Context context;
        String rtitle[];
        String rDescription[];
        String dAvailable[];
        int rImag[];
        String radress[];
        String rgender[];
        String rnumber[];
        String remail[];

        MyAdapter(Context c, String title[]){
            super(c,R.layout.location,R.id.textview1,title);
            this.context=c;
            this.rtitle=title;

        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater= (LayoutInflater) getApplicationContext().getSystemService(context.LAYOUT_INFLATER_SERVICE);
            View location=layoutInflater.inflate(R.layout.location,parent,false);

            TextView myTitle=location.findViewById(R.id.textview1);



            myTitle.setText(rtitle[position]);



            return location;
        }
    }

}