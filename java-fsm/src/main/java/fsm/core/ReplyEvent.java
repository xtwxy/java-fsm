package fsm.core;

import java.util.ArrayList;
import java.util.List;

public class ReplyEvent implements Event {

	private StateSet source;
	private List<Object> contents;

	public ReplyEvent(StateSet src) {
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
	public StateSet source() {
		return this.source;
	}
}
