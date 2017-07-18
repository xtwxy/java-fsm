package fsm.core;

public interface StateMachine {
	State state();

	boolean stopped();

	void start();

	public abstract class Adapter implements StateMachine {

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
