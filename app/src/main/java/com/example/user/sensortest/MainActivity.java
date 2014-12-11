package com.example.user.sensortest;

import android.hardware.Sensor;
import android.hardware.SensorManager;
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
import java.util.List;

import static android.view.View.VISIBLE;


public class MainActivity extends ActionBarActivity {

    private Button ButtonStart;
    private Button ButtonStop;
    private TextView SensorListText;
    private EditText TypeFileText;
    private Spinner SpinnerPhone1;
    private Spinner SpinnerPhone2;
    private Spinner SpinnerMotion;
    private SensorManager m_sensorManager;


    private String[] FileList = new String[3];
    private String[] PhoneList = {"SonyTx","HTCSensation","SamsungGTS681","SonyXS","ASUSPadefone","SonyT3"};
    private String[] MotionList = {"垂直上下","水平左右","X","自然上下揮動"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InitValue();
        InitSpinner();
        ShowSensor();
        Log.i("APPTEST", "is open");




    }

    public void ShowSensor(){
        List<Sensor> availableSensor = m_sensorManager.getSensorList(Sensor.TYPE_ALL);//取得手機感測器清單
        String outputString = "";

        for (int i =0; i<availableSensor.size(); i++  ){
            Sensor thisSensor = availableSensor.get(i);

            outputString  += thisSensor.getName(); //取得裝置名稱
            outputString  += PrintSensorType(thisSensor.getType());  //取得型態
            outputString  += "\n";
            /*
            //outputString  += ", ";

            outputString  += String.valueOf(thisSensor.getPower()); //取得功耗
            outputString  += "毫安培\n";
            outputString  += thisSensor.getVendor(); //取得供應商
            outputString  += String.valueOf(thisSensor.getMaximumRange()); //資料範圍
            outputString  += "\n";
            */
        }
        SensorListText.setText(outputString);
    }
    private String PrintSensorType(int i){
        switch(i){
            case 1: return "(三軸加速度感應器)";
            case 2: return "(磁力感應器)";
            case 3: return "(方向感應器)";
            case 4: return "(陀螺儀感應器)";
            case 5: return "(光感應器)";
            case 6: return "(壓力感應器)";
            case 7: return "(溫度感應器)";
            case 8: return "(遠近感應器)";
            case 9: return "(重力感測器)";
            case 10: return "(線性加速度感應器)";
            case 11: return "(翻轉感測器)";

            default: return String.valueOf(i);
        }//switch
        //return "";
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


        m_sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);//取得手機的感測器資訊
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
