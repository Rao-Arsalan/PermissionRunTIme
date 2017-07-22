package trader.shopping.market.com.permissionruntime;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import static android.R.attr.permission;

public class MainActivity extends AppCompatActivity {

    static Button locButton;
    static Button readContacts;
    static Button readStorageButton;
    static TextView contactsTextView;
    static TextView storageTextView;
    static TextView locationTextView;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        setXmlViews();


        GetPermission.context = MainActivity.this;





        locButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new GetPermission().getRunTimePermission(Manifest.permission.ACCESS_FINE_LOCATION, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, "Need Location Permission",110);
            }
        });

        readStorageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new GetPermission().getRunTimePermission(Manifest.permission.READ_EXTERNAL_STORAGE, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, "Need read your exxternal permission",111);
            }
        });

        readContacts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new GetPermission().getRunTimePermission(Manifest.permission.READ_CONTACTS, new String[]{Manifest.permission.READ_CONTACTS, Manifest.permission.WRITE_CONTACTS}, "Need your Contacts Read Permission",112);

            }
        });



    }








    private void setXmlViews() {


        locButton = (Button) findViewById(R.id.getLocation);
        readContacts = (Button) findViewById(R.id.readContacts);
        readStorageButton = (Button) findViewById(R.id.readStorage);
        contactsTextView = (TextView) findViewById(R.id.setReadPermission);
        locationTextView  = (TextView) findViewById(R.id.readLocation) ;
        storageTextView = (TextView) findViewById(R.id.readdata) ;

    }


    //getter of button and text view
    public static Button getLocButton() {
        return locButton;
    }

    public static Button getReadContacts() {
        return readContacts;
    }

    public static Button getReadStorageButton() {
        return readStorageButton;
    }

    public static TextView getContactsTextView() {
        return contactsTextView;
    }

    public static TextView getStorageTextView() {
        return storageTextView;
    }

    public static TextView getLocationTextView() {
        return locationTextView;
    }




    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode){

            case 110:
                if(grantResults.length>0 && grantResults[0]==PackageManager.PERMISSION_GRANTED){
                    locationTextView.setText((getLocButton().getText())+" is set");
                }else{

                    Toast.makeText(this, "Location result i failed", Toast.LENGTH_SHORT).show();
                }
                break;
            case 111:
                if(grantResults.length>0 && grantResults[0]==PackageManager.PERMISSION_GRANTED){
                    storageTextView.setText((getReadStorageButton().getText())+" is set");
                }else{

                    Toast.makeText(this, "Read storage result is failed", Toast.LENGTH_SHORT).show();
                }
                break;
            case 112:
                if(grantResults.length>0 && grantResults[0]==PackageManager.PERMISSION_GRANTED){
                    contactsTextView.setText((getReadContacts().getText())+" is set");
                }else{

                    Toast.makeText(this, "Read contact result is failed", Toast.LENGTH_SHORT).show();
                }
                break;
            default:
                return;

        }

    }
}