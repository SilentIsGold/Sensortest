package com.example.user.sensortest;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Arrays;

import static android.view.View.VISIBLE;


public class MainActivity extends ActionBarActivity {

    private Button ButtonStart;
    private Button ButtonStop;
    private TextView SensorListText;
    private EditText TypeFileText;
    private Spinner SpinnerPhone1;
    private Spinner SpinnerPhone2;
    private Spinner SpinnerMotion;


    private String[] FileList = new String[3];
    private String[] PhoneList = {"SonyTx","HTCSensation","SamsungGTS681","SonyXS","ASUSPadefone","SonyT3"};
    private String[] MotionList = {"垂直上下","水平左右","X","自然上下揮動"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InitValue();
        InitSpinner();
        Log.i("APPTEST", "is open");




    }

    public void InitValue(){

        ButtonStart=(Button)findViewById(R.id.Start);
        ButtonStop=(Button)findViewById(R.id.Stop);

        TypeFileText=(EditText)findViewById(R.id.TypeFileText);
        SensorListText=(TextView) findViewById(R.id.SensorList);
        SpinnerPhone1=(Spinner)findViewById( R.id.Phone1);
        SpinnerPhone2=(Spinner)findViewById( R.id.Phone2);
        SpinnerMotion=(Spinner)findViewById( R.id.Motion);

        FileList[0]=PhoneList[0];
        FileList[1]=PhoneList[1];
        FileList[2]=MotionList[2];

    }

    public void InitSpinner(){
        ArrayAdapter<String> listAdapter = new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,PhoneList);
        listAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);

        ArrayAdapter<String> listAdapter2 = new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,PhoneList);
        listAdapter2.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);

        ArrayAdapter<String> motionAdapter = new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,MotionList);
        motionAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);

        Log.i("APPTEST", "is open2");
        SpinnerPhone1.setAdapter(listAdapter);
        SpinnerPhone2.setAdapter(listAdapter2);
        SpinnerMotion.setAdapter(motionAdapter);
        Log.i("APPTEST", "is open3");
        SpinnerPhone1.setOnItemSelectedListener(new Spinner.OnItemSelectedListener()
        {

            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1,int arg2, long arg3)
            {
                // TODO Auto-generated method stub
                FileList[0]=PhoneList[arg2];

                TypeFileText.setText(Arrays.toString(FileList));
                //Text.append("手機A:"+PhoneList[arg2]+"\n");     //设置显示当前选择的项
                arg0.setVisibility(View.VISIBLE);
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub

            }


        });

        SpinnerPhone2.setOnItemSelectedListener(new Spinner.OnItemSelectedListener()
        {

            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1,int arg2, long arg3)
            {
                // TODO Auto-generated method stub
                FileList[1]=PhoneList[arg2];

                TypeFileText.setText(Arrays.toString(FileList));
                //Text.append("手機B:"+PhoneList[arg2]+"\n");     //设置显示当前选择的项
                arg0.setVisibility(VISIBLE);
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub

            }


        });

        SpinnerMotion.setOnItemSelectedListener(new Spinner.OnItemSelectedListener()
        {

            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1,int arg2, long arg3)
            {
                // TODO Auto-generated method stub
                FileList[2]=MotionList[arg2];

                TypeFileText.setText(Arrays.toString(FileList));
                //Text.append("動作為:"+MotionList[arg2]+"\n");     //设置显示当前选择的项
                arg0.setVisibility(View.VISIBLE);
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub

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
}
