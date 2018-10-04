package com.examprel.examprep.Camera;

import android.Manifest;
import android.arch.core.BuildConfig;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Environment;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.FileProvider;
import android.util.Log;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class CameraUtils {

    public static void refreshGallery(Context context,String filePath){

        MediaScannerConnection.scanFile(context, new String[]{filePath}, null,
                new MediaScannerConnection.OnScanCompletedListener() {
                    @Override
                    public void onScanCompleted(String path, Uri uri) {

                    }
                });
    }
    public static boolean checkPermissions(Context context){
        return ActivityCompat.checkSelfPermission(context, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(context,Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(context,Manifest.permission.RECORD_AUDIO) == PackageManager.PERMISSION_GRANTED;
    }
    public static Bitmap optimizeBitmap(int sampleSize, String filePath){
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = sampleSize;
        return  BitmapFactory.decodeFile(filePath,options);
    }
   public static boolean isDeviceSupportCamera(Context context) {
       if (context.getPackageManager().hasSystemFeature(
               PackageManager.FEATURE_CAMERA)) {
           return true;
       } else {
           return false;
       }
   }
   public static void openSettings(Context context){
       Intent intent = new Intent();
       intent.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
       intent.setData(Uri.fromParts("package", BuildConfig.APPLICATION_ID,null));
       intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
       context.startActivity(intent);
   }
    public static Uri getOutputMediaFileUri(Context context, File file) {
        return FileProvider.getUriForFile(context, context.getPackageName() + ".provider", file);
    }

    public static File getOutputMediaFile(int type) {

        // External sdcard location
        File mediaStorageDir = new File(
                Environment
                        .getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES),
                CameraActivity.GALLERY_DIRECTORY_NAME);

        // Create the storage directory if it does not exist
        if (!mediaStorageDir.exists()) {
            if (!mediaStorageDir.mkdirs()) {
                Log.e(CameraActivity.GALLERY_DIRECTORY_NAME, "Oops! Failed create "
                        + CameraActivity.GALLERY_DIRECTORY_NAME + " directory");
                return null;
            }
        }

        // Preparing media file naming convention
        // adds timestamp
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss",
                Locale.getDefault()).format(new Date());
        File mediaFile;
        if (type == CameraActivity.MEDIAA_TYPE_IMAGE) {
            mediaFile = new File(mediaStorageDir.getPath() + File.separator
                    + "IMG_" + timeStamp + "." + CameraActivity.IMAGEE_EXTENSION);
        }

        else {
            return null;
        }

        return mediaFile;
    }

}