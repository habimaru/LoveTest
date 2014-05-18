package habimaru.lovetest.app;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity  implements SensorEventListener {

    private TextView text;
    private ImageView image;
    private SensorManager sensorManager = null;
    private float valor;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        // Capture magnetic sensor related view elements
        text = (TextView) findViewById(R.id.textView);
        image = (ImageView) findViewById(R.id.imageView);

        // Register magnetic sensor
        sensorManager.registerListener(this,
                sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD),
                SensorManager.SENSOR_DELAY_NORMAL);


        text.setText(String.valueOf(valor));
        AnimationDrawable animation = new AnimationDrawable();
        animation.addFrame(getResources().getDrawable(R.drawable.base1), 1000);
        animation.addFrame(getResources().getDrawable(R.drawable.base2), 1000);
        animation.addFrame(getResources().getDrawable(R.drawable.base3), 1000);
        animation.addFrame(getResources().getDrawable(R.drawable.base4), 1000);
        animation.addFrame(getResources().getDrawable(R.drawable.base5), 1000);
        animation.addFrame(getResources().getDrawable(R.drawable.base6), 1000);
        animation.setOneShot(false);

        image.setImageDrawable(animation);

        // start the animation!
        animation.start();

    }

    @Override
    protected void onPause() {
        // Unregister the listener
        sensorManager.unregisterListener(this);
        super.onPause();
    }

    @Override
    protected void onStop() {
        // Unregister the listener
        sensorManager.unregisterListener(this);
        super.onStop();
    }

    @Override
    protected void onResume() {
        super.onResume();

        // Register magnetic sensor
        sensorManager.registerListener(this,
                sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD),
                SensorManager.SENSOR_DELAY_NORMAL);
    }

    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        // Ignoring this for now

    }

    public void onSensorChanged(SensorEvent sensorEvent) {
        synchronized (this) {
            if (sensorEvent.sensor.getType() == Sensor.TYPE_MAGNETIC_FIELD) {
                //magneticX.setText( Float.toString( sensorEvent.values[0]));
                //System.out.println(sensorEvent.values[0]);
                //magneticY.setText( Float.toString( sensorEvent.values[1]));
                //System.out.println(sensorEvent.values[1]);
                //magneticZ.setText( Float.toString( sensorEvent.values[2]));
                //System.out.println(sensorEvent.values[2]);
                valor=Math.abs(sensorEvent.values[2]+sensorEvent.values[1]+sensorEvent.values[0]);

            }
        }


    }

    public void estado(View v){
        text.setText(String.valueOf(valor));
        AnimationDrawable animation = new AnimationDrawable();
        animation.addFrame(getResources().getDrawable(R.drawable.base1), 200);
        animation.addFrame(getResources().getDrawable(R.drawable.base2), 200);
        animation.addFrame(getResources().getDrawable(R.drawable.base3), 200);
        animation.addFrame(getResources().getDrawable(R.drawable.base4), 200);
        animation.addFrame(getResources().getDrawable(R.drawable.base5), 200);
        animation.addFrame(getResources().getDrawable(R.drawable.base6), 200);
        animation.addFrame(getResources().getDrawable(R.drawable.base1), 400);
        animation.addFrame(getResources().getDrawable(R.drawable.base2), 400);
        animation.addFrame(getResources().getDrawable(R.drawable.base3), 400);
        animation.addFrame(getResources().getDrawable(R.drawable.base4), 400);
        animation.addFrame(getResources().getDrawable(R.drawable.base5), 400);
        animation.addFrame(getResources().getDrawable(R.drawable.base6), 400);
        animation.setOneShot(true);


        image.setImageDrawable(animation);

        // start the animation!



        if(valor>100){
            animation.addFrame(getResources().getDrawable(R.drawable.base1), 400);
            animation.addFrame(getResources().getDrawable(R.drawable.base2), 400);
            animation.addFrame(getResources().getDrawable(R.drawable.base3), 400);
            animation.addFrame(getResources().getDrawable(R.drawable.base4), 400);
            animation.addFrame(getResources().getDrawable(R.drawable.base5), 600);
            animation.addFrame(getResources().getDrawable(R.drawable.base6), 800);
            animation.addFrame(getResources().getDrawable(R.drawable.faker1), 250);
            animation.addFrame(getResources().getDrawable(R.drawable.faker0), 250);
            animation.addFrame(getResources().getDrawable(R.drawable.faker1), 500);
            animation.addFrame(getResources().getDrawable(R.drawable.faker0), 750);
            animation.addFrame(getResources().getDrawable(R.drawable.faker1), 750);
            animation.addFrame(getResources().getDrawable(R.drawable.faker0), 1000);
            animation.addFrame(getResources().getDrawable(R.drawable.faker1), 2000);
            animation.addFrame(getResources().getDrawable(R.drawable.faker0), 2000);
            animation.addFrame(getResources().getDrawable(R.drawable.faker1), 3000);
        }else{
            if(valor>80){
                animation.addFrame(getResources().getDrawable(R.drawable.base1), 400);
                animation.addFrame(getResources().getDrawable(R.drawable.base2), 400);
                animation.addFrame(getResources().getDrawable(R.drawable.base3), 400);
                animation.addFrame(getResources().getDrawable(R.drawable.base4), 400);
                animation.addFrame(getResources().getDrawable(R.drawable.base5), 400);
                animation.addFrame(getResources().getDrawable(R.drawable.base6), 600);
                animation.addFrame(getResources().getDrawable(R.drawable.base1), 800);
                animation.addFrame(getResources().getDrawable(R.drawable.reggie1), 250);
                animation.addFrame(getResources().getDrawable(R.drawable.reggie0), 250);
                animation.addFrame(getResources().getDrawable(R.drawable.reggie1), 500);
                animation.addFrame(getResources().getDrawable(R.drawable.reggie0), 750);
                animation.addFrame(getResources().getDrawable(R.drawable.reggie1), 750);
                animation.addFrame(getResources().getDrawable(R.drawable.reggie0), 1000);
                animation.addFrame(getResources().getDrawable(R.drawable.reggie1), 2000);
                animation.addFrame(getResources().getDrawable(R.drawable.reggie0), 2000);
                animation.addFrame(getResources().getDrawable(R.drawable.reggie1), 3000);            }else{
                if(valor>60){
                    animation.addFrame(getResources().getDrawable(R.drawable.base1), 600);
                    animation.addFrame(getResources().getDrawable(R.drawable.base2), 800);
                    animation.addFrame(getResources().getDrawable(R.drawable.jeff1), 250);
                    animation.addFrame(getResources().getDrawable(R.drawable.jeff0), 250);
                    animation.addFrame(getResources().getDrawable(R.drawable.jeff1), 500);
                    animation.addFrame(getResources().getDrawable(R.drawable.jeff0), 750);
                    animation.addFrame(getResources().getDrawable(R.drawable.jeff1), 750);
                    animation.addFrame(getResources().getDrawable(R.drawable.jeff0), 1000);
                    animation.addFrame(getResources().getDrawable(R.drawable.jeff1), 2000);
                    animation.addFrame(getResources().getDrawable(R.drawable.jeff0), 2000);
                    animation.addFrame(getResources().getDrawable(R.drawable.jeff1), 3000);

                }else{
                    if(valor>40){
                        animation.addFrame(getResources().getDrawable(R.drawable.base1), 400);
                        animation.addFrame(getResources().getDrawable(R.drawable.base2), 600);
                        animation.addFrame(getResources().getDrawable(R.drawable.base3), 800);
                        animation.addFrame(getResources().getDrawable(R.drawable.spiderman1), 250);
                        animation.addFrame(getResources().getDrawable(R.drawable.spiderman0), 250);
                        animation.addFrame(getResources().getDrawable(R.drawable.spiderman1), 500);
                        animation.addFrame(getResources().getDrawable(R.drawable.spiderman0), 750);
                        animation.addFrame(getResources().getDrawable(R.drawable.spiderman1), 750);
                        animation.addFrame(getResources().getDrawable(R.drawable.spiderman0), 1000);
                        animation.addFrame(getResources().getDrawable(R.drawable.spiderman1), 2000);
                        animation.addFrame(getResources().getDrawable(R.drawable.spiderman0), 2000);
                        animation.addFrame(getResources().getDrawable(R.drawable.spiderman1), 3000);
                    }else{
                        if(valor>20){
                            animation.addFrame(getResources().getDrawable(R.drawable.base1), 400);
                            animation.addFrame(getResources().getDrawable(R.drawable.base2), 400);
                            animation.addFrame(getResources().getDrawable(R.drawable.base3), 600);
                            animation.addFrame(getResources().getDrawable(R.drawable.base4), 800);
                            animation.addFrame(getResources().getDrawable(R.drawable.batman1), 250);
                            animation.addFrame(getResources().getDrawable(R.drawable.batman0), 250);
                            animation.addFrame(getResources().getDrawable(R.drawable.batman1), 500);
                            animation.addFrame(getResources().getDrawable(R.drawable.batman0), 750);
                            animation.addFrame(getResources().getDrawable(R.drawable.batman1), 750);
                            animation.addFrame(getResources().getDrawable(R.drawable.batman0), 1000);
                            animation.addFrame(getResources().getDrawable(R.drawable.batman1), 2000);
                            animation.addFrame(getResources().getDrawable(R.drawable.batman0), 2000);
                            animation.addFrame(getResources().getDrawable(R.drawable.batman1), 3000);
                        }else{
                            animation.addFrame(getResources().getDrawable(R.drawable.base1), 400);
                            animation.addFrame(getResources().getDrawable(R.drawable.base2), 400);
                            animation.addFrame(getResources().getDrawable(R.drawable.base3), 400);
                            animation.addFrame(getResources().getDrawable(R.drawable.base4), 600);
                            animation.addFrame(getResources().getDrawable(R.drawable.base5), 800);
                            animation.addFrame(getResources().getDrawable(R.drawable.enlightened1), 250);
                            animation.addFrame(getResources().getDrawable(R.drawable.enlightened0), 250);
                            animation.addFrame(getResources().getDrawable(R.drawable.enlightened1), 500);
                            animation.addFrame(getResources().getDrawable(R.drawable.enlightened0), 750);
                            animation.addFrame(getResources().getDrawable(R.drawable.enlightened1), 750);
                            animation.addFrame(getResources().getDrawable(R.drawable.enlightened0), 1000);
                            animation.addFrame(getResources().getDrawable(R.drawable.enlightened1), 2000);
                            animation.addFrame(getResources().getDrawable(R.drawable.enlightened0), 2000);
                            animation.addFrame(getResources().getDrawable(R.drawable.enlightened1), 3000);
                        }
                    }
                }

            }
        }
        animation.start();

    }
}
