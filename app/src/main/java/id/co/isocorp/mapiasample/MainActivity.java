package id.co.isocorp.mapiasample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import id.co.isocorp.mapsmarkerlib.MapsMarkerLib;

public class MainActivity extends AppCompatActivity {
    private MapsMarkerLib pickAddress;
    private TextView tV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pickAddress = new MapsMarkerLib(this,this);
        tV = (TextView)findViewById(R.id.my_chosen_address);
    }

    public void pickAddress(View view) {
        pickAddress.getMapsMarker();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode != RESULT_CANCELED){
            if(requestCode==pickAddress.MARKER_LIB){
                tV.setText("Chosen Location : " + data.getStringExtra(pickAddress.ADDRESS_NAME));
            }else{
                return;
            }
        }else {
            return;
        }

    }
}
