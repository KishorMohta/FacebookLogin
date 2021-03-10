package com.facebook.Assertion;

import org.testng.Assert;

public class HomePageAssertions {
    public static final String ExpectedFACEBOOKQUOTES = "Facebook helps you connect and share with the people in your life.";

    public static Boolean quoteAssertions(String actualFaceBookQuote) {
        Assert.assertEquals(actualFaceBookQuote, ExpectedFACEBOOKQUOTES);
        return true;
    }
}
