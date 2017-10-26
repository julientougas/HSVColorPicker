package mad9132.hsv;

import android.app.Activity;
import android.app.DialogFragment;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Observable;
import java.util.Observer;

import model.HSVModel;

/**
 * The Controller for HSV Color Picker
 *
 * @author Julien Tougas toug0008
 * @version 1.0
 */
public class MainActivity extends Activity implements Observer, SeekBar.OnSeekBarChangeListener {
    // CLASS VARIABLES
    private static final String ABOUT_DIALOG_TAG = "About";

    // INSTANCE VARIABLES
    // Pro-tip: different naming style; the 'm' means 'member'
    private AboutDialogFragment mAboutDialog;
    private TextView mColorSwatch;
    private HSVModel mModel;
    private SeekBar mHueSB;
    private SeekBar mSatSB;
    private SeekBar mBrightSB;
    private TextView mHueTV;
    private TextView mSatTV;
    private TextView mBrightTV;
    private Button mBlackBtn;
    private Button mRedBtn;
    private Button mLimeBtn;
    private Button mBlueBtn;
    private Button mYellowBtn;
    private Button mCyanBtn;
    private Button mMagentaBtn;
    private Button mSilverBtn;
    private Button mGrayBtn;
    private Button mMaroonBtn;
    private Button mOliveBtn;
    private Button mGreenBtn;
    private Button mPurpleBtn;
    private Button mTealBtn;
    private Button mNavyBtn;

    public float convertFloatValue(int intValue) {
        float floatValue;
        floatValue = 0.01f * intValue;
        return floatValue;
    }

    public int convertIntValue(float floatValue) {
        int intValue;
        intValue = Math.round(100 * floatValue);
        return intValue;
    }

    public float convertFloatHue(int intValue) {
        float floatValue;
        floatValue = 1.0f * intValue;
        return floatValue;
    }

    public int convertIntHue(float floatValue) {
        int intValue;
        intValue = Math.round(1 * floatValue);
        return intValue;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Instantiate a new AboutDialogFragment()
        // but do not show it (yet)
        mAboutDialog = new AboutDialogFragment();

        // Instantiate a new HSV model
        // Initialize the model hue (max), sat (min), bright (min)
        mModel = new HSVModel();
        mModel.setHue(HSVModel.MIN_HUE);
        mModel.setSat(HSVModel.MIN_SAT);
        mModel.setBright(HSVModel.MIN_BRIGHT);
        // The Model is observing this Controller (class MainActivity implements Observer)
        mModel.addObserver(this);

        // reference each View
        mColorSwatch = (TextView) findViewById(R.id.colorSwatch);
        mHueSB = (SeekBar) findViewById(R.id.hueSB);
        mSatSB = (SeekBar) findViewById(R.id.satSB);
        mBrightSB = (SeekBar) findViewById(R.id.brightSB);
        mHueTV = (TextView) findViewById(R.id.hue);
        mSatTV = (TextView) findViewById(R.id.sat);
        mBrightTV = (TextView) findViewById(R.id.bright);

        // reference each color button
        mBlackBtn = (Button) findViewById(R.id.blackButton);
        mRedBtn = (Button) findViewById(R.id.redButton);
        mLimeBtn = (Button) findViewById(R.id.limeButton);
        mBlueBtn = (Button) findViewById(R.id.blueButton);
        mYellowBtn = (Button) findViewById(R.id.yellowButton);
        mCyanBtn = (Button) findViewById(R.id.cyanButton);
        mMagentaBtn = (Button) findViewById(R.id.magentaButton);
        mSilverBtn = (Button) findViewById(R.id.silverButton);
        mGrayBtn = (Button) findViewById(R.id.grayButton);
        mMaroonBtn = (Button) findViewById(R.id.maroonButton);
        mOliveBtn = (Button) findViewById(R.id.oliveButton);
        mGreenBtn = (Button) findViewById(R.id.greenButton);
        mPurpleBtn = (Button) findViewById(R.id.purpleButton);
        mTealBtn = (Button) findViewById(R.id.tealButton);
        mNavyBtn = (Button) findViewById(R.id.navyButton);

        // set the domain (i.e. max) for each component
        mHueSB.setMax(convertIntHue(HSVModel.MAX_HUE));
        mSatSB.setMax(convertIntValue(HSVModel.MAX_SAT));
        mBrightSB.setMax(convertIntValue(HSVModel.MAX_BRIGHT));

        // register the event handler for each <SeekBar>
        mHueSB.setOnSeekBarChangeListener(this);
        mSatSB.setOnSeekBarChangeListener(this);
        mBrightSB.setOnSeekBarChangeListener(this);

        // Click Listeners for color buttons
        mBlackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mModel.asBlack();
                Toast.makeText(getApplicationContext(),
                        "H: " + mModel.getHue() + "\u00B0" + " S: " + convertIntValue(mModel.getSat()) + "%" + " V: " + convertIntValue(mModel.getBright()) + "%",
                        Toast.LENGTH_SHORT).show();
            }
        });
        mRedBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mModel.asRed();
                Toast.makeText(getApplicationContext(),
                        "H: " + mModel.getHue() + "\u00B0" + " S: " + convertIntValue(mModel.getSat()) + "%" + " V: " + convertIntValue(mModel.getBright()) + "%",
                        Toast.LENGTH_SHORT).show();
            }
        });
        mLimeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mModel.asLime();
                Toast.makeText(getApplicationContext(),
                        "H: " + mModel.getHue() + "\u00B0" + " S: " + convertIntValue(mModel.getSat()) + "%" + " V: " + convertIntValue(mModel.getBright()) + "%",
                        Toast.LENGTH_SHORT).show();

            }
        });
        mBlueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mModel.asBlue();
                Toast.makeText(getApplicationContext(),
                        "H: " + mModel.getHue() + "\u00B0" + " S: " + convertIntValue(mModel.getSat()) + "%" + " V: " + convertIntValue(mModel.getBright()) + "%",
                        Toast.LENGTH_SHORT).show();

            }
        });
        mYellowBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mModel.asYellow();
                Toast.makeText(getApplicationContext(),
                        "H: " + mModel.getHue() + "\u00B0" + " S: " + convertIntValue(mModel.getSat()) + "%" + " V: " + convertIntValue(mModel.getBright()) + "%",
                        Toast.LENGTH_SHORT).show();

            }
        });
        mCyanBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mModel.asCyan();
                Toast.makeText(getApplicationContext(),
                        "H: " + mModel.getHue() + "\u00B0" + " S: " + convertIntValue(mModel.getSat()) + "%" + " V: " + convertIntValue(mModel.getBright()) + "%",
                        Toast.LENGTH_SHORT).show();

            }
        });
        mMagentaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mModel.asMagenta();
                Toast.makeText(getApplicationContext(),
                        "H: " + mModel.getHue() + "\u00B0" + " S: " + convertIntValue(mModel.getSat()) + "%" + " V: " + convertIntValue(mModel.getBright()) + "%",
                        Toast.LENGTH_SHORT).show();

            }
        });
        mSilverBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mModel.asSilver();
                Toast.makeText(getApplicationContext(),
                        "H: " + mModel.getHue() + "\u00B0" + " S: " + convertIntValue(mModel.getSat()) + "%" + " V: " + convertIntValue(mModel.getBright()) + "%",
                        Toast.LENGTH_SHORT).show();

            }
        });
        mGrayBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mModel.asGray();
                Toast.makeText(getApplicationContext(),
                        "H: " + mModel.getHue() + "\u00B0" + " S: " + convertIntValue(mModel.getSat()) + "%" + " V: " + convertIntValue(mModel.getBright()) + "%",
                        Toast.LENGTH_SHORT).show();

            }
        });
        mMaroonBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mModel.asMaroon();
                Toast.makeText(getApplicationContext(),
                        "H: " + mModel.getHue() + "\u00B0" + " S: " + convertIntValue(mModel.getSat()) + "%" + " V: " + convertIntValue(mModel.getBright()) + "%",
                        Toast.LENGTH_SHORT).show();

            }
        });
        mOliveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mModel.asOlive();
                Toast.makeText(getApplicationContext(),
                        "H: " + mModel.getHue() + "\u00B0" + " S: " + convertIntValue(mModel.getSat()) + "%" + " V: " + convertIntValue(mModel.getBright()) + "%",
                        Toast.LENGTH_SHORT).show();

            }
        });
        mGreenBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mModel.asGreen();
                Toast.makeText(getApplicationContext(),
                        "H: " + mModel.getHue() + "\u00B0" + " S: " + convertIntValue(mModel.getSat()) + "%" + " V: " + convertIntValue(mModel.getBright()) + "%",
                        Toast.LENGTH_SHORT).show();

            }
        });
        mPurpleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mModel.asPurple();
                Toast.makeText(getApplicationContext(),
                        "H: " + mModel.getHue() + "\u00B0" + " S: " + convertIntValue(mModel.getSat()) + "%" + " V: " + convertIntValue(mModel.getBright()) + "%",
                        Toast.LENGTH_SHORT).show();

            }
        });
        mTealBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mModel.asTeal();
                Toast.makeText(getApplicationContext(),
                        "H: " + mModel.getHue() + "\u00B0" + " S: " + convertIntValue(mModel.getSat()) + "%" + " V: " + convertIntValue(mModel.getBright()) + "%",
                        Toast.LENGTH_SHORT).show();

            }
        });
        mNavyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mModel.asNavy();
                Toast.makeText(getApplicationContext(),
                        "H: " + mModel.getHue() + "\u00B0" + " S: " + convertIntValue(mModel.getSat()) + "%" + " V: " + convertIntValue(mModel.getBright()) + "%",
                        Toast.LENGTH_SHORT).show();

            }
        });

        // event handler for color swatch
        // display toast message with color swatch hsv values
        mColorSwatch.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(getApplicationContext(),
                        "H: " + mModel.getHue() + "\u00B0" + " S: " + convertIntValue(mModel.getSat()) + "%" + " V: " + convertIntValue(mModel.getBright()) + "%",
                        Toast.LENGTH_SHORT).show();
                return true;
            }
        });

        // initialize the View to the values of the Model
        this.updateView();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    // Handle action bar click of the about menu
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_about) {
            DialogFragment newFragment = new AboutDialogFragment();
            newFragment.show(getFragmentManager(), ABOUT_DIALOG_TAG);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    /**
     * Event handler for the <SeekBar>s: hue, sat, bright
     */
    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

        // Did the user cause this event?
        // YES > continue
        // NO  > leave this method
        if (!fromUser) {
            return;
        }

        // Determine which <SeekBark> caused the event (switch + case)
        // GET the SeekBar's progress, and SET the model to it's new value
        switch (seekBar.getId()) {
            case R.id.hueSB:
                mModel.setHue(convertFloatHue(mHueSB.getProgress()));
                mHueTV.setText("HUE: " + mHueSB.getProgress() + "\u00B0");
                break;

            case R.id.satSB:
                mModel.setSat(convertFloatValue(mSatSB.getProgress()));
                mSatTV.setText("SATURATION: " + mSatSB.getProgress() + "%");
                break;

            case R.id.brightSB:
                mModel.setBright(convertFloatValue(mBrightSB.getProgress()));
                mBrightTV.setText("BRIGHTNESS: " + mBrightSB.getProgress() + "%");
                break;
        }
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        // No-Operation
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        switch (seekBar.getId()) {
            case R.id.hueSB:
                mHueTV.setText(getResources().getString(R.string.hue));
                break;
            case R.id.satSB:
                mSatTV.setText(getResources().getString(R.string.sat));
                break;
            case R.id.brightSB:
                mBrightTV.setText(getResources().getString(R.string.bright));
                break;
        }
    }

    // The Model has changed state!
    // Refresh the View to display the current values of the Model.
    @Override
    public void update(Observable observable, Object data) {

        this.updateView();
    }

    private void updateColorSwatch() {
        //GET the model's h,s,v values, and SET the background colour of the swatch <TextView>

        mColorSwatch.setBackgroundColor(Color.HSVToColor(new float[]{mModel.getHue(), mModel.getSat(), mModel.getBright()}));

    }

    private void updateHueSB() {
        //GET the model's hue value, and SET the hue <SeekBar>
        mHueSB.setProgress(convertIntHue(mModel.getHue()));
    }

    private void updateSatSB() {
        //GET the model's saturation value, and SET the saturation <SeekBar>
        mSatSB.setProgress(convertIntValue(mModel.getSat()));
    }

    private void updateBrightSB() {
        //GET the model's brightness value, and SET the brightness <SeekBar>
        mBrightSB.setProgress(convertIntValue(mModel.getBright()));
    }

    // synchronize each View component with the Model
    public void updateView() {

        this.updateColorSwatch();
        this.updateHueSB();
        this.updateSatSB();
        this.updateBrightSB();


    }

}   // end of class
