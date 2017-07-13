package fsm.core;

import java.util.ArrayList;
import java.util.List;

import fsm.nfa.State;

public class ReplyEvent implements Event {

	private Context source;
	private List<Object> contents;

	public ReplyEvent(Context src) {
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
	public State apply(Context ctx, State s) {
		return s.accept(ctx, this);
	}

	@Override
	public Context source() {
		return this.source;
	}

}
