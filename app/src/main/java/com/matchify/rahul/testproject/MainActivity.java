package com.matchify.rahul.testproject;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.ImageView;


import java.util.ArrayList;
import java.util.Random;


public class MainActivity extends AppCompatActivity {

    DraggableGridView mDraggableGridView;
    ArrayList<Integer> mArrayList;
    ImageView mImageView1, mImageView2, mImageView3;
    LayoutInflater mInflater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final SurfaceView surfaceView = (SurfaceView)findViewById(R.id.surface_view);

        SurfaceHolder surfaceHolder = surfaceView.getHolder();

        surfaceHolder.addCallback(new SurfaceHolder.Callback(){

            @Override
            public void surfaceCreated(SurfaceHolder holder) {

                Log.v("CREATED","SURFACE CREATED");
                Canvas canvas = holder.lockCanvas();

                int width  = surfaceView.getWidth();
                int height = surfaceView.getHeight();
                int[] colorArray = new int[width * height];

                for(int index = 0; index < colorArray.length; index++){

                    colorArray[index] = 0xFFEEAA;
                }
                Bitmap bitmap = null;

                try {
                    /*bitmap = Bitmap.createBitmap(colorArray,width,height,Bitmap.Config.RGB_565);

                    Rect rect = new Rect(0,0,width,height);

                    Paint paint = new Paint();

                    canvas.drawBitmap(bitmap,null,rect,paint);

                    //surfaceView.draw(canvas);

                    holder.unlockCanvasAndPost(canvas);*/

                    /***********************************************************/
                    // color noise salt and pepper
                    /*Random random = new Random();
                    Paint paint  = new Paint();

                    for(int x = 0; x < width; x++){

                        for(int y=0; y<height; y++){

                            Point point = new Point(x,y);
                            int color = random.nextInt()%0xFFFFFF;
                            paint.setColor(color);

                            canvas.drawPoint(x,y,paint);

                        }

                    }

                    holder.unlockCanvasAndPost(canvas);*/
                    /*****************************************************************/
                    // single circle
                    /*Paint paint = new Paint();

                    paint.setColor(Color.RED);

                    paint.setStyle(Paint.Style.STROKE);
                    paint.setStrokeWidth(10);

                    canvas.drawCircle(width/2, height/2, 200, paint);

                    holder.unlockCanvasAndPost(canvas);*/
                    /*******************************************************************/

                    // multiple circles

                    Random random = new Random();
                    Paint paint = new Paint();

                    int[] colorArr = {Color.RED,Color.GREEN,Color.YELLOW,Color.BLUE,Color.CYAN,Color.RED};
                    for(int i=0;i<6; i++) {
                        int number = random.nextInt();

                        int color = colorArr[i];

                        int randomHeight = (number % (height/2)) + 10;

                        int randomWidth = (number % (width/2)) + 10;

                        int radius = number%250;

                        paint.setColor(color);
                        paint.setStyle(Paint.Style.FILL_AND_STROKE);

                        canvas.drawCircle(width/2,height/2,radius, paint);

                    }

                    holder.unlockCanvasAndPost(canvas);


                    /*********************************************************************/

                }
                catch(IllegalArgumentException exception){

                    width = 300;
                    height = 300;

                    int[] colorArrayException = new int[width * height];

                    for(int index = 0; index < width * height; index++){

                        colorArrayException[index] = 0x00FF00;
                    }

                    bitmap = Bitmap.createBitmap(colorArrayException,width,height,Bitmap.Config.RGB_565);

                }
                catch(Exception exception){

                    Log.v("TOUGH LUCK","BRO");
                }

            }

            @Override
            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

                Log.v("CHANGED","SURFACE CHANGED");
            }

            @Override
            public void surfaceDestroyed(SurfaceHolder holder) {

                Log.v("HOLDER","HOLDER");
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
