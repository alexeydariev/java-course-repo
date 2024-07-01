package student.examples;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.Arrays;

public class Listener implements ITestListener
{
    @Override
    public void onTestStart(ITestResult result) {
        // TODO Auto-generated method stub
        System.out.println("Test starting : " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        // TODO Auto-generated method stub
        System.out.println("Test ending : "+result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        // TODO Auto-generated method stub
        System.out.println("Test ending : "+result.getName() + " FAILED " + result.getParameters()[0]);
        //System.out.println("Failure of test cases and its details are : "+result.getName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        // TODO Auto-generated method stub
        System.out.println("Skip of test cases and its details are : "+result.getName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // TODO Auto-generated method stub
        System.out.println("Failure of test cases and its details are : "+result.getName());
    }
/*
    @Override
    public void onStart(ITestContext context) {
        // TODO Auto-generated method stub
        System.out.println("Test : "+context.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        // TODO Auto-generated method stub
        System.out.println("Success of test cases and its details are : "+context.getName());
    }

  */
}