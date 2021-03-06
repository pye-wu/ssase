package org.ssase.sensor.control;

import org.ssase.sensor.Sensor;

public class SpareThreadSensor implements Sensor {

	private double concurency = 0.0;
	private double maxConcurency = 0.0;
	
	// If less than maxSpare, then this sensor should be the same
	// as maxThread, but it can not exceed maxSpare.
	/**********
	 * 
	 * Need to be changed manually.
	 * 
	 */
	private int maxSpare = 25;
	
	@Override
	public double recordPriorToTask(Object value) {
		synchronized (this) {
			
			concurency++;
			if (maxConcurency < concurency && concurency <= maxSpare) {
				maxConcurency = concurency;
			}
		}
		return 0;
	}

	@Override
	public double recordPostToTask(double value) {
		synchronized (this) {
			concurency--;
		}
		return 0;
	}

	@Override
	public boolean isOutput() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public synchronized double[] runMonitoring() {
		
		if(maxConcurency > maxSpare) {
			maxConcurency = maxSpare;
		}
		
		double current = maxConcurency;
		maxConcurency = concurency > maxSpare? maxSpare : concurency;
		return new double[]{current};
	}

	@Override
	public boolean isVMLevel() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String[] getName() {
		return new String[]{"minSpareThreads"};
	}

	@Override
	public void destory() {
		// TODO Auto-generated method stub

	}
	
	public void updateSpare(int maxSpare) {
		synchronized (this) {
		    this.maxSpare = maxSpare;
		}
	}

	@Override
	public void initInstance(Object object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setAlias(String alias) {
		// TODO Auto-generated method stub
		
	}

}
