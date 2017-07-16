package fsm.core;

import java.util.Set;
import java.util.TreeSet;

public interface EventQueue {

	void send(Event evt);

	void connect(StateSet m);

	void disconnect(StateSet m);

	public abstract class Adaptor implements EventQueue {
		protected Set<StateSet> machines;

		public Adaptor() {
			this.machines = new TreeSet<>();
		}

		@Override
		public void send(Event evt) {
		}

		@Override
		public void connect(StateSet m) {
			this.machines.add(m);
		}

		@Override
		public void disconnect(StateSet m) {
			this.machines.remove(m);
		}
	}
}
