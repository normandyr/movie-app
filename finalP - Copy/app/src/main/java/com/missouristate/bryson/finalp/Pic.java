package com.missouristate.bryson.finalp;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.ImageView;
import android.widget.Toast;

public class Pic extends Activity {

    private static final int PHOTO_REQUEST = 1;
    private Bitmap bitmap;
    public ImageView imageview;

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.picview);
        imageview = findViewById(R.id.picture);

        PackageManager manager = this.getPackageManager();
        if(manager.hasSystemFeature(PackageManager.FEATURE_CAMERA)){
            Intent takePictureIntent = new Intent (MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(takePictureIntent, PHOTO_REQUEST);

        }
        else{
            Toast.makeText(this, "Sorry -- Your device does not have a camera", Toast.LENGTH_LONG).show();
        }
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == PHOTO_REQUEST && resultCode == RESULT_OK){
            Bundle extras = data.getExtras();
            bitmap = (Bitmap) extras.get("data");
            imageview.setImageBitmap(bitmap);
        }
    }

}
