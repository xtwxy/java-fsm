package fsm.core;

public interface Machine {
	State state();

	boolean accept(Event evt);

	boolean stopped();

	void start();

	public abstract class Adapter implements Machine {

		@Override
		public boolean accept(Event evt) {
			return false;
		}

		@Override
		public boolean stopped() {
			return false;
		}

		@Override
		public void start() {
		}

		public State state() {
			return null;
		}
	}
}
