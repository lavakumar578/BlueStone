package com.tyss.blueStone.listeners;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;
/**
 * This class is used to transform the fully quailified class name to xml 
 * @author LAVA KUMAR
 *
 */
public class RetryAnalyserListenerImplementation implements IAnnotationTransformer{


	@Override
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
		annotation.setRetryAnalyzer(com.tyss.blueStone.listeners.RetryAnalyserImplementation.class);
		
	}
}