package fsm.core;

import java.util.ArrayList;
import java.util.List;

public class ReplyEvent implements Event {

	private StateMachine source;
	private List<Object> contents;

	public ReplyEvent(StateMachine src) {
		this.source = src;
		this.contents = new ArrayList<>();
	}

	protected List<Object> getContents() {
		return contents;
	}

	public void addContent(Object o) {
		this.contents.add(o);
	}

	@Override
	public boolean apply(State s) {
		ReplyAcceptor acceptor = (ReplyAcceptor) s;
		acceptor.accept(this);
		return true;
	}

	@Override
	public StateMachine source() {
		return this.source;
	}
}
