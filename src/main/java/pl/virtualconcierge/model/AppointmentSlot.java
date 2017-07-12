package pl.virtualconcierge.model;

import java.time.LocalTime;

public class AppointmentSlot {
	private final LocalTime time;
	private final boolean taken;
	public AppointmentSlot(LocalTime time, boolean taken) {
		super();
		this.time = time;
		this.taken = taken;
	}
	public LocalTime getTime() {
		return time;
	}
	public boolean isTaken() {
		return taken;
	}
	

}
