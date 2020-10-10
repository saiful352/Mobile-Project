package com.example.doctorsdetails;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    TextView textView1,textView2,textView3,textView4,textView5,textView6,textView7;
    Button message,call,btnid;
    int images[]={R.drawable.dicon5,R.drawable.dicon3,R.drawable.dicon6,R.drawable.dicon1,R.drawable.dicon2};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=findViewById(R.id.listview);
        textView1=findViewById(R.id.textview1);
        textView2=findViewById(R.id.textview2);
        textView3=findViewById(R.id.textview3);
        textView4=findViewById(R.id.textview4);
        textView5=findViewById(R.id.textview5);
        textView4=findViewById(R.id.textview6);
        textView5=findViewById(R.id.textview7);

        // btnid=findViewById(R.id.btnid);
         message=findViewById(R.id.message);

        String mTitle[]=getResources().getStringArray(R.array.doctorsName);
        String mdescription[]=getResources().getStringArray(R.array.catagory);
        String availabledoctors[]=getResources().getStringArray(R.array.availableornot);
        String adress[]=getResources().getStringArray(R.array.adress);
        String gender[]=getResources().getStringArray(R.array.gender);
        String number[]=getResources().getStringArray(R.array.number);
        String email[]=getResources().getStringArray(R.array.email);

        MyAdapter adapter=new MyAdapter(this,mTitle,mdescription,images,availabledoctors,adress,gender,number,email);
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

        MyAdapter(Context c, String title[], String description[], int imgs[],String availabledoctors[] ,String adress[],String gender[],String number[],String email[]){
            super(c,R.layout.row,R.id.textview1,title);
            this.context=c;
            this.rtitle=title;
            this.rDescription=description;
            this.dAvailable=availabledoctors;
            this.rImag=imgs;
            this.radress=adress;
            this.rgender=gender;
            this.rnumber=number;
            this.remail=email;

        }

                   @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                LayoutInflater layoutInflater= (LayoutInflater) getApplicationContext().getSystemService(context.LAYOUT_INFLATER_SERVICE);
                View row=layoutInflater.inflate(R.layout.row,parent,false);

                ImageView images=row.findViewById(R.id.imageID);
                TextView myTitle=row.findViewById(R.id.textview1);
                TextView myDescription =row.findViewById(R.id.textview2);
                TextView davailable=row.findViewById(R.id.textview3);
                TextView dgender=row.findViewById(R.id.textview4);
                TextView daddress=row.findViewById(R.id.textview5);
                TextView dnumber=row.findViewById(R.id.textview6);
                TextView demail=row.findViewById(R.id.textview7);

                images.setImageResource(rImag[position]);
                myTitle.setText(rtitle[position]);
                myDescription.setText(rDescription[position]);
                davailable.setText(dAvailable[position]);
                dgender.setText(rgender[position]);
                daddress.setText(radress[position]);
                demail.setText(remail[position]);
                dnumber.setText(rnumber[position]);


                return row;
        }
    }

}