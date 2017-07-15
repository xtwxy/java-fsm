package fsm.core;

public interface Context {
	void accept(Event evt);

	boolean stopped();

	void start();

	public class Adapter implements Context {

		@Override
		public void accept(Event evt) {
		}

		@Override
		public boolean stopped() {
			return false;
		}

		@Override
		public void start() {
		}

	}
}
