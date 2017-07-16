package fsm.core;

public interface StateSet {
	State state();

	boolean accept(Event evt);

	boolean stopped();

	void start();

	public abstract class Adapter implements StateSet {

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
