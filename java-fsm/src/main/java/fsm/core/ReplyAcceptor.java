package fsm.core;

import fsm.nfa.State;

public interface ReplyAcceptor extends State {
	State acceptReply(Context ctx, ReplyEvent evt);
}
