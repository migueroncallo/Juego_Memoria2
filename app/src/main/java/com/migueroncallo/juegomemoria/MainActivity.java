package com.migueroncallo.juegomemoria;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13,b14,b15,b16,restart;
    ArrayList seleccionados;
    int completados;
    long delay=1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=(Button) findViewById(R.id.button1);
        b2=(Button) findViewById(R.id.button2);
        b3=(Button) findViewById(R.id.button3);
        b4=(Button) findViewById(R.id.button4);
        b5=(Button) findViewById(R.id.button5);
        b6=(Button) findViewById(R.id.button6);
        b7=(Button) findViewById(R.id.button7);
        b8=(Button) findViewById(R.id.button8);
        b9=(Button) findViewById(R.id.button9);
        b10=(Button) findViewById(R.id.button10);
        b11=(Button) findViewById(R.id.button11);
        b12=(Button) findViewById(R.id.button12);
        b13=(Button) findViewById(R.id.button13);
        b14=(Button) findViewById(R.id.button14);
        b15=(Button) findViewById(R.id.button15);
        b16=(Button) findViewById(R.id.button16);
        restart=(Button) findViewById(R.id.restart);
        seleccionados=new ArrayList<Button>();
        completados=0;
        restart.setText(R.string.restart);

        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
        b5.setOnClickListener(this);
        b6.setOnClickListener(this);
        b7.setOnClickListener(this);
        b8.setOnClickListener(this);
        b9.setOnClickListener(this);
        b10.setOnClickListener(this);
        b11.setOnClickListener(this);
        b12.setOnClickListener(this);
        b13.setOnClickListener(this);
        b14.setOnClickListener(this);
        b15.setOnClickListener(this);
        b16.setOnClickListener(this);


        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=getIntent();
                finish();
                startActivity(intent);

            }
        });




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

    public void match() throws InterruptedException {
        if (seleccionados.size()==2){
            Button opcion1=(Button) seleccionados.get(0);
            Button opcion2=(Button) seleccionados.get(1);
            seleccionados.clear();

            if (opcion1.getText().equals(opcion2.getText())){
                opcion1.setEnabled(false);
                opcion2.setEnabled(false);
                completados++;
                TextView puntaje= (TextView) findViewById(R.id.textView);
                puntaje.setText("Parejas: "+completados);
                if (completados==8){
                    Toast.makeText(this, "Felicitaciones! Ha ganado.",Toast.LENGTH_LONG).show();

                }


            }else {
                Thread.sleep(delay);
                opcion1.setText("");
                opcion2.setText("");
            }

        }
    }


    @Override
    public void onClick(View v) {

        switch(v.getId()) {

            case R.id.button1:

                b1.setText(R.string.button1);
                seleccionados.add(b1);
                break;
            case R.id.button2:
                b2.setText(R.string.button2);
                seleccionados.add(b2);

                break;
            case R.id.button3:
                b3.setText(R.string.button3);
                seleccionados.add(b3);
                break;
            case R.id.button4:
                b4.setText(R.string.button4);
                seleccionados.add(b4);
                break;
            case R.id.button5:
                b5.setText(R.string.button5);
                seleccionados.add(b5);
                break;
            case R.id.button6:
                b6.setText(R.string.button6);
                seleccionados.add(b6);
                break;
            case R.id.button7:
                b7.setText(R.string.button7);
                seleccionados.add(b7);
                break;
            case R.id.button8:
                b8.setText(R.string.button8);
                seleccionados.add(b8);
                break;
            case R.id.button9:
                b9.setText(R.string.button9);
                seleccionados.add(b9);
                break;
            case R.id.button10:
                b10.setText(R.string.button10);
                seleccionados.add(b10);
                break;
            case R.id.button11:
                b11.setText(R.string.button11);
                seleccionados.add(b11);
                break;
            case R.id.button12:
                b12.setText(R.string.button12);
                seleccionados.add(b12);
                break;
            case R.id.button13:
                b13.setText(R.string.button13);
                seleccionados.add(b13);
                break;
            case R.id.button14:
                b14.setText(R.string.button14);
                seleccionados.add(b14);
                break;
            case R.id.button15:
                b15.setText(R.string.button15);
                seleccionados.add(b15);
                break;
            case R.id.button16:
                b16.setText(R.string.button16);
                seleccionados.add(b16);
                break;
        }
        try {
            match();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
