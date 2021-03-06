package org.ssase.objective.optimization.moaco;

import java.util.Arrays;

import org.ssase.util.Tuple;

public class BasicAnt extends Ant {

	
	public BasicAnt(String antID, AntColony antColony, Structure strcture) {
		super(antID, antColony, strcture);
		//System.out.print(strcture.getObjective().getName() + "\n");
	}


	@Override
	public Tuple<Integer, Double> valueTransitionRule(int r) {
		double[] p = strcture.getValueProbability(r, antColony.getMu());
		int index = doProbabilisticSelection(p);
		
		/*System.out.print("=====================\n");
		System.out.print(Arrays.toString(p) + "\n");
		System.out.print("for " + r + " we get " + index + "\n");
		System.out.print("=====================\n");*/
		return new Tuple<Integer, Double>(index, antColony.getPrimitive(r).getValueVector()[index]);
	}

	@Override
	public void localUpdatingRule() {
		strcture.localUpdate(this);
	}

	@Override
	public boolean end() {
		return antColony.done(pathCounter);
	}

	private int doProbabilisticSelection(double[] probability) {
		double p = Math.random();
		double cumulativeProbability = 0.0;
		for (int i = 0; i < probability.length;i++) {
		    cumulativeProbability += probability[i];
		    if (p <= cumulativeProbability && probability[i] != 0) {
		        return i;
		    }
		}
		
		// Select the last one if the random number is too large
		// However, this is unlikely to occur.
		return probability.length-1;
	}


	

}
