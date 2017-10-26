package model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Class Under Test (CUT): HSVModel.java
 *
 * Purpose: Test every combination of Red, Green and Blue.
 *
 * @author toug0008@algonquinlive.com
 */
public class HSVModelTest {
    private static final int TOLERANCE = 0;

    private HSVModel mModel;

    @Before
    public void setUp() throws Exception {
        mModel = new HSVModel();
        mModel.setAlpha( HSVModel.MAX_ALPHA );
    }

    @Test
    public void getSetRGB() throws Exception {
        for( int red = HSVModel.MIN_RGB; red <= HSVModel.MAX_RGB; red++ ) {
            mModel.setRed( red );
            assertEquals( "Test > Red", red, mModel.getRed(), TOLERANCE );

            for ( int green = HSVModel.MIN_RGB; green <= HSVModel.MAX_RGB; green++ ) {
                mModel.setGreen( green );
                assertEquals( "Test > Green", green, mModel.getGreen(), TOLERANCE );

                for( int blue = HSVModel.MIN_RGB; blue <= HSVModel.MAX_RGB; blue++ ) {
                    mModel.setBlue( blue );
                    assertEquals( "Test > Blue", blue, mModel.getBlue(), TOLERANCE );
                }
            }
        }
    }
}