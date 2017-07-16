package fsm.core;

public interface StateSet {
	State state();

	boolean stopped();

	void start();

	public abstract class Adapter implements StateSet {

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
