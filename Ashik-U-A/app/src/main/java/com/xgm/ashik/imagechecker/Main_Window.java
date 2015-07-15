package com.xgm.ashik.imagechecker;

import android.app.Activity;
import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;


public class Main_Window extends Activity {

   ImageView imgview;
    ImageView imgview2;
    EditText urlText;
    Button btn1;
    Button btn2;
    Button bcmp;
    ProgressDialog pg;
    TextView result;
    int w,h;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main__window);
        imgview = (ImageView)findViewById(R.id.imageView1);
        imgview2 = (ImageView)findViewById(R.id.imageView2);
        result = (TextView)findViewById(R.id.resultTxt);
        urlText = (EditText)findViewById(R.id.url);
        btn1 = (Button)findViewById(R.id.button1);
        btn2 = (Button)findViewById(R.id.button2);
        bcmp = (Button)findViewById(R.id.btncompare);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LoadImageFromURL loadImage = new LoadImageFromURL(imgview);
                loadImage.execute();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LoadImageFromURL loadImage = new LoadImageFromURL(imgview2);
                loadImage.execute();
            }
        });
        bcmp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bitmap b1 = ((BitmapDrawable)imgview.getDrawable()).getBitmap();
                Bitmap b2 = ((BitmapDrawable)imgview2.getDrawable()).getBitmap();
                if(b1.getWidth()>b2.getWidth()) w=b2.getWidth();
                else w=b1.getWidth();
                if(b1.getHeight()>b2.getHeight()) h=b2.getHeight();
                else h=b1.getHeight();
                System.out.println("Width and Height : "+w+" and "+h);
                int pxCount = w*h;
                float count=0;
                int count2=0;
                for(int i=0;i<w;i++)
                    for(int j=0;j<h;j++)
                    {
                        int x=Color.red(b1.getPixel(i,j))-Color.red(b2.getPixel(i,j));
                        if(x<0) x*=-1;
                        int y=Color.green(b1.getPixel(i,j))-Color.green(b2.getPixel(i,j));
                        if(y<0) y*=-1;
                        int z=Color.blue(b1.getPixel(i,j))-Color.blue(b2.getPixel(i,j));
                        if(z<0) z*=-1;
                        x=(255-x)/255;y=(255-y)/255;z=(255-z)/255;
                        count+=x+y+z;
                    }
                    count/=3;
                count2=((int)count)/pxCount*100;
                System.out.println("The Match : "+ count2);
                result.setText(count2+"%");
               /*System.out.println("Red : "+Color.red(b1.getPixel(10,10))+" and "+Color.red(b2.getPixel(10,10)));
                System.out.println("Green : "+Color.green(b1.getPixel(10,10))+" and "+Color.green(b2.getPixel(10,10)));
                System.out.println("Blue : "+Color.blue(b1.getPixel(10,10))+" and "+Color.blue(b2.getPixel(10,10)));*/
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu;  this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main__window, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    public class LoadImageFromURL extends AsyncTask<String,Void,Bitmap>
    {
        ImageView im;
        LoadImageFromURL(ImageView m){
            im = m;
        }
        @Override
        protected Bitmap doInBackground(String... strings) {
            try {
                URL url = new URL(urlText.getText().toString());
                InputStream is = url.openConnection().getInputStream();
                Bitmap bitMap = BitmapFactory.decodeStream(is);
                return bitMap;

            } catch (MalformedURLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            pg.dismiss();
            return null;
        }
        @Override
        protected void onPreExecute()
        {
            pg = ProgressDialog.show(Main_Window.this,"Image Checker","Your Image is being Downloaded. . .");
        }
        @Override
        protected void onPostExecute(Bitmap result) {
            // TODO Auto-generated method stub
            super.onPostExecute(result);
            im.setImageBitmap(result);
            pg.dismiss();
        }
    }
}
