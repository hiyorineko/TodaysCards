package com.example.hiyoriaya.todayscards;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;

import com.squareup.picasso.Picasso;

public class MainActivity extends Activity implements View.OnClickListener{
    private Bitmap oBmp;
    private ImageView iv;
    private String[] wsurl;
    private String[] vgurl;
    private String[] bfurl;
    private int vgc;
    private int wsc;
    private int bfc;
    private Spinner spinner;
    private String[] mStrings;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iv = (ImageView)findViewById(R.id.iv);
        context = this;
        seturl();
        Button back = (Button)findViewById(R.id.back);
        back.setOnClickListener(this);
        Button forward = (Button)findViewById(R.id.forward);
        forward.setOnClickListener(this);
        spinner = (Spinner)findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, mStrings);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent,
                                       View view, int position, long id) {
                Spinner spinner = (Spinner) parent;
                String item = (String) spinner.getSelectedItem();
                switch (spinner.getSelectedItemPosition()) {
                    case 0:
                        Picasso.with(context).load(vgurl[vgc]).into(iv);
                        break;
                    case 1:
                        Picasso.with(context).load(wsurl[wsc]).into(iv);
                        break;

                    case 2:
                        Picasso.with(context).load(bfurl[bfc]).into(iv);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Resources r = getResources();
                oBmp = BitmapFactory.decodeResource(r, R.drawable.error);
                iv.setImageBitmap(oBmp);
            }
        });
    }

    public void seturl(){
        mStrings = new String[3];
        mStrings[0]="Vanguard";
        mStrings[1]="Weiβ Schwarz";
        mStrings[2]="BuddyFight";
        wsurl = new String[25];
        vgurl = new String[4];
        bfurl = new String[4];
        vgc =0;
        wsc =0;
        bfc =0;
        wsurl[0] ="http://ws-tcg.com/wp/wp-content/uploads/ws_today.png";
        wsurl[1] ="http://ws-tcg.com/wp/wp-content/uploads/ws_today1.png";
        wsurl[2] ="http://ws-tcg.com/wp/wp-content/uploads/ws_today2.png";
        wsurl[3] ="http://ws-tcg.com/wp/wp-content/uploads/ws_today3.png";
        wsurl[4] ="http://ws-tcg.com/wp/wp-content/uploads/ws_today4.png";
        wsurl[5] ="http://ws-tcg.com/wp/wp-content/uploads/ws_today5.png";
        wsurl[6] ="http://ws-tcg.com/wp/wp-content/uploads/ws_today6.png";
        wsurl[7] ="http://ws-tcg.com/wp/wp-content/uploads/ws_today7.png";
        wsurl[8] ="http://ws-tcg.com/wp/wp-content/uploads/ws_today8.png";
        wsurl[9] ="http://ws-tcg.com/wp/wp-content/uploads/ws_today9.png";
        wsurl[10] ="http://ws-tcg.com/wp/wp-content/uploads/ws_today10.png";
        wsurl[11] ="http://ws-tcg.com/wp/wp-content/uploads/ws_today11.png";
        wsurl[12] ="http://ws-tcg.com/wp/wp-content/uploads/ws_today12.png";
        wsurl[13] ="http://ws-tcg.com/wp/wp-content/uploads/ws_today13.png";
        wsurl[14] ="http://ws-tcg.com/wp/wp-content/uploads/ws_today14.png";
        wsurl[15] ="http://ws-tcg.com/wp/wp-content/uploads/ws_today15.png";
        wsurl[16] ="http://ws-tcg.com/wp/wp-content/uploads/ws_today16.png";
        wsurl[17] ="http://ws-tcg.com/wp/wp-content/uploads/ws_today17.png";
        wsurl[18] ="http://ws-tcg.com/wp/wp-content/uploads/ws_today18.png";
        wsurl[19] ="http://ws-tcg.com/wp/wp-content/uploads/ws_today19.png";
        wsurl[20] ="http://ws-tcg.com/wp/wp-content/uploads/ws_today1.gif";
        wsurl[21] ="http://ws-tcg.com/wp/wp-content/uploads/ws_today2.gif";
        wsurl[22]= "http://ws-tcg.com/wp/wp-content/uploads/ws_today3.gif";
        wsurl[23]="http://ws-tcg.com/wp/wp-content/uploads/ws_today4.gif";
        wsurl[24]="http://ws-tcg.com/wp/wp-content/uploads/ws_today5.gif";

        vgurl[0]="http://cf-vanguard.com/wp/wp-content/uploads/vgd_today.png";
        vgurl[1]="http://cf-vanguard.com/wp/wp-content/uploads/vgd_today01.png";
        vgurl[2]="http://cf-vanguard.com/wp/wp-content/uploads/vgd_today02.png";
        vgurl[3]="http://cf-vanguard.com/wp/wp-content/uploads/vgd_today03.png";

        bfurl[0]="http://fc-buddyfight.com/wp/wp-content/uploads/bf_today.png";
        bfurl[1]="http://fc-buddyfight.com/wp/wp-content/uploads/bf_today1.png";
        bfurl[2]="http://fc-buddyfight.com/wp/wp-content/uploads/bf_today2.png";
        bfurl[3]="http://fc-buddyfight.com/wp/wp-content/uploads/bf_today3.png";
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.forward:
                switch (spinner.getSelectedItemPosition()) {
                    case 0:
                        if (vgc != 3) {
                            vgc++;
                        } else {
                            vgc = 0;
                        }
                        Picasso.with(this).load(vgurl[vgc]).into(iv);
                        break;
                    case 1:
                        if (wsc != 24) {
                            wsc++;
                        } else {
                            wsc=0;
                        }
                        Picasso.with(this).load(wsurl[wsc]).into(iv);
                        break;
                    case 2:
                        if (bfc != 3) {
                            bfc++;
                        } else {
                            bfc=0;
                        }
                        Picasso.with(this).load(bfurl[bfc]).into(iv);
                        break;
                }
            case R.id.back:
                    switch (spinner.getSelectedItemPosition()) {
                            case 0:
                                if (vgc != 0) {
                                    vgc--;
                                } else {
                                    vgc = 3;
                                }
                                Picasso.with(this).load(vgurl[vgc]).into(iv);
                                break;
                            case 1:
                                if (wsc != 0) {
                                    wsc--;
                                } else {
                                    wsc = 24;
                                }
                                Picasso.with(this).load(wsurl[wsc]).into(iv);
                                break;
                            case 2:
                                if (bfc != 0) {
                                    bfc--;
                                } else {
                                    bfc = 3;
                                }
                                Picasso.with(this).load(bfurl[bfc]).into(iv);
                                break;
                        }
                }
        }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
