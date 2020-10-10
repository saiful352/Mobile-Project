package com.example.rapidambulance;


import androidx.annotation.NonNull;
        import androidx.annotation.Nullable;
        import androidx.appcompat.app.AppCompatActivity;

        import android.content.Context;
import android.os.Bundle;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.ArrayAdapter;
        import android.widget.Button;
        import android.widget.ImageView;
        import android.widget.ListView;
        import android.widget.TextView;

public class MenuActivity extends AppCompatActivity {
    ListView listView;
    TextView textView1,textView2,textView3,textView4,textView5,textView6,textView7;
    Button message,call,btnid;
    int images[]={R.drawable.a1,R.drawable.a2,R.drawable.a3,R.drawable.a4,R.drawable.a5};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        listView=findViewById(R.id.listview);
        textView1=findViewById(R.id.textview1);
        textView2=findViewById(R.id.textview2);
        textView3=findViewById(R.id.textview3);
        textView5=findViewById(R.id.textview5);
        textView4=findViewById(R.id.textview6);


        // btnid=findViewById(R.id.btnid);
        message=findViewById(R.id.message);

        String mTitle[]=getResources().getStringArray(R.array.doctorsName);
        String mdescription[]=getResources().getStringArray(R.array.catagory);
        String availabledoctors[]=getResources().getStringArray(R.array.availableornot);
        String adress[]=getResources().getStringArray(R.array.adress);
        String number[]=getResources().getStringArray(R.array.number);


        MyAdapter adapter=new MyAdapter(this,mTitle,mdescription,images,availabledoctors,adress,number);
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

    class MyAdapter extends ArrayAdapter<String> {
        Context context;
        String rtitle[];
        String rDescription[];
        String dAvailable[];
        int rImag[];
        String radress[];
        String rnumber[];


        MyAdapter(Context c, String title[], String description[], int imgs[],String availabledoctors[] ,String adress[],String number[]){
            super(c,R.layout.menu,R.id.textview1,title);
            this.context=c;
            this.rtitle=title;
            this.rDescription=description;
            this.dAvailable=availabledoctors;
            this.rImag=imgs;
            this.radress=adress;
            this.rnumber=number;


        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater= (LayoutInflater) getApplicationContext().getSystemService(context.LAYOUT_INFLATER_SERVICE);
            View menu=layoutInflater.inflate(R.layout.menu,parent,false);

            ImageView images=menu.findViewById(R.id.imageID);
            TextView myTitle=menu.findViewById(R.id.textview1);
            TextView myDescription =menu.findViewById(R.id.textview2);
            TextView davailable=menu.findViewById(R.id.textview3);
            TextView daddress=menu.findViewById(R.id.textview5);
            TextView dnumber=menu.findViewById(R.id.textview6);

            images.setImageResource(rImag[position]);
            myTitle.setText(rtitle[position]);
            myDescription.setText(rDescription[position]);
            davailable.setText(dAvailable[position]);
            daddress.setText(radress[position]);
            dnumber.setText(rnumber[position]);


            return menu;
        }
    }

}