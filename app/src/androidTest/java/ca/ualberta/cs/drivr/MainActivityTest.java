/*
 *  Copyright 2016 CMPUT301F16T10
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 *
 */

package ca.ualberta.cs.drivr;

import android.test.ActivityInstrumentationTestCase2;

import com.robotium.solo.Solo;

/**
 * Created by adam on 2016-10-12.
 */

public class MainActivityTest extends ActivityInstrumentationTestCase2<MainActivity> {

    private Solo solo;

    /**
     * Testing our Main Activity can open and have access to all other Activities
     */

    public MainActivityTest() {
        super(ca.ualberta.cs.drivr.MainActivity.class);
    }

    @Override
    public void setUp() throws Exception {
        solo = new Solo(getInstrumentation(), getActivity());
    }

    @Override
    public void tearDown() throws Exception {
        solo.finishOpenedActivities();
    }

    public void testOpenSettingsActivity() {
        solo.assertCurrentActivity("Expected MainActivity", MainActivity.class);
        solo.clickOnButton("Plus button");
        solo.clickOnButton("Settings");
        solo.assertCurrentActivity("Expected SettingsActivity", SettingsActivity.class);
        solo.goBack();
    }

    public void testOpenProfileActivity() {
        solo.assertCurrentActivity("Expected MainActivity", MainActivity.class);
        solo.clickOnButton("Plus button");
        solo.clickOnButton("Profile");
        solo.assertCurrentActivity("Expected ProfileActivity", ProfileActivity.class);
        solo.goBack();
    }

    public void testOpenRequestHistoryActivity() {
        solo.assertCurrentActivity("Expected MainActivity", MainActivity.class);
        solo.clickOnButton("Plus button");
        solo.clickOnButton("Request History");
        solo.assertCurrentActivity("Expected RequestHistoryActivity", RequestHistoryActivity.class);
        solo.goBack();
    }

    public void testOpenRequestsListActivity() {
        solo.assertCurrentActivity("Expected MainActivity", MainActivity.class);
        solo.clickOnButton("Plus button");
        solo.clickOnButton("Requests");
        solo.assertCurrentActivity("Expected RequestsListActivity", RequestsListActivity.class);
        solo.goBack();
    }

    public void testSearchDestination() {
        solo.assertCurrentActivity("Expected MainActivity", MainActivity.class);
        solo.enterText(solo.getEditText("Search bar"), "West Edmonton Mall");
        solo.clickOnButton("Search button");
        assertTrue(solo.waitForText("West Edmonton Mall"));
    }

}
