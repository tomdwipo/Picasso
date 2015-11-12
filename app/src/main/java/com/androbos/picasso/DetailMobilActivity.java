package com.androbos.picasso;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetailMobilActivity extends AppCompatActivity {
    public static String KEY_ITEM = "item";
    private TextView txtDetail;
    private ImageView imgDetail;
    private MobilModel item;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_mobil);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setTitle("Detail Mobil");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        txtDetail = (TextView)findViewById(R.id.txt_detail);
        imgDetail = (ImageView)findViewById(R.id.img_detail);

        item = (MobilModel)getIntent().getSerializableExtra(KEY_ITEM);
        txtDetail.setText(Html.fromHtml(item.getTitle()+"Berharga: "+item.getHarga()+"<br>"+
        "di <b>"+ item.getLokasi()+"</b>"));
        Picasso.with(DetailMobilActivity.this).load(item.getImage()).into(imgDetail);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_detail_mobil, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_share) {
            share();
            return true;
        }

        if (id == android.R.id.home){
            finish();
        }

        return super.onOptionsItemSelected(item);
    }
    private void share(){
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, item.getTitle() + " " + item.getHarga() + " " + item.getLokasi());
        sendIntent.putExtra(Intent.EXTRA_TITLE, "Jual Mobil Murah");
        sendIntent.setType("text/plain");
        startActivity(sendIntent);
    }
}
