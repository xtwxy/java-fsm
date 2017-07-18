package fsm.core;

public interface EventQueue {

	void send(Event evt);

	public abstract class Adaptor implements EventQueue {

		@Override
		public void send(Event evt) {
		}
	}
}
