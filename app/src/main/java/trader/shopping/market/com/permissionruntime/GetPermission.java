package trader.shopping.market.com.permissionruntime;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;

import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import static android.R.attr.id;
import static android.os.Build.VERSION_CODES.M;


/**
 * Created by RaoArsalan on 7/22/2017.
 */

public class GetPermission {

    private static final int REQUEST_CODE = 112;
    private static final String TAG = MainActivity.class.getSimpleName();
    static Context context;


    /**
     *
     * @param myPermission is the permission which you manipulate like{manifest.permission.READ_CONTACT}..etc this variable get permission form mainactiviy.
     * @param permissionList this is the arry which used in a requestpermission() method it's alose a arry of permission
     * @param snackBarMessage i'll used snack bar for intercating the users
     * @param request is the flag variable wihich determine which permission granted {110 for location,111 for storage,112 for contacts}
     */






    static   void  getRunTimePermission(String myPermission, final String permissionList[], String snackBarMessage, final int request){

        if(ActivityCompat.checkSelfPermission(context,myPermission)== PackageManager.PERMISSION_GRANTED) {
            Log.i(TAG,"Permission Granted");

            if (request == 110) {
                MainActivity.getLocationTextView().setText(MainActivity.getLocButton().getText()+" is set");
            }
            if (request == 111) {
                MainActivity.getStorageTextView().setText((MainActivity.getReadStorageButton().getText())+" is set");
            }
            if (request == 112) {
                MainActivity.getContactsTextView().setText(MainActivity.getReadContacts().getText()+" is set");
            }

        }else{

            if(ActivityCompat.shouldShowRequestPermissionRationale((Activity) context,myPermission)){
                Log.i(TAG,"Permission is not  Granted having show relational");




                Snackbar.make(((Activity) context).findViewById(android.R.id.content),snackBarMessage,Snackbar.LENGTH_INDEFINITE).setAction("ENABLE",
                        new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                ActivityCompat.requestPermissions((Activity) context,permissionList,request);
                            }
                        }).show();





            }else{

                Log.i(TAG,"Permission being requested for first time");

                ActivityCompat.requestPermissions((Activity) context,permissionList,request);


            }





        }








        }

    }



