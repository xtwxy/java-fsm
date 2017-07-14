package fsm.core.mock.delay;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import fsm.core.Context;
import fsm.core.Event;

public class ThreadedTimer implements Context {
	private final BlockingQueue<Runnable> workQueue;
	private final ThreadPoolExecutor executor;
	private final SetTimerAcceptorImpl setTimerAcceptor;

	public ThreadedTimer() {
		workQueue = new ArrayBlockingQueue<>(8);
		executor = new ThreadPoolExecutor(4, 8, 60, TimeUnit.SECONDS, workQueue);
		setTimerAcceptor = new SetTimerAcceptorImpl(executor);
	}

	@Override
	public void accept(Event evt) {
		evt.apply(this, setTimerAcceptor);
	}

	@Override
	public boolean stopped() {
		return executor.isShutdown();
	}

	@Override
	public void start() {
		setTimerAcceptor.enter(this);
	}
}
