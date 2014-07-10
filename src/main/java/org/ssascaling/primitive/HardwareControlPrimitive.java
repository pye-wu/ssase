package org.ssascaling.primitive;

import org.ssascaling.actuator.Actuator;
import org.ssascaling.objective.Objective;

public class HardwareControlPrimitive  extends ControlPrimitive {

	public HardwareControlPrimitive(String alias, String VM_ID, boolean isHardware,
			Type type, Actuator actuator, long provision, double constraint,
			double[] valueVector) {
		super(alias, VM_ID, isHardware, type, actuator, provision, constraint, valueVector);
		// TODO Auto-generated constructor stub
	}
	@Deprecated
	public HardwareControlPrimitive(double[] array) {
		super(array);
		// TODO Auto-generated constructor stub
	}
	@Deprecated
	public HardwareControlPrimitive(double[] array, Objective... objs) {
		super(array, objs);
		// TODO Auto-generated constructor stub
	}
	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return this.hashCode();
	}

}