package com.fun.playinfo.utils;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 计数器
 */
public class Counter {
	public String name;

	private final AtomicLong ok;
	private long okByLastMin;
	private long okInLastMin;

	private final AtomicLong err;
	private long errByLastMin;
	private long errInLastMin;

	public Counter(String name) {
		this.name = name;
		ok = new AtomicLong(0);
		okByLastMin = 0;
		okInLastMin = 0;
		err = new AtomicLong(0);
		errByLastMin = 0;
		errInLastMin = 0;
	}

	public String getName() {
		return name;
	}

	public long addOk() {
		return ok.incrementAndGet();
	}

	public long addErr() {
		return err.incrementAndGet();
	}

	public long getOk() {
		return ok.get();
	}

	public long getErr() {
		return err.get();
	}

	public void setOkInLastMin() {
		long okNow = ok.get();
		okInLastMin = okNow - okByLastMin;
		okByLastMin = okNow;
	}

	public long getOkInLastMin() {
		return okInLastMin;
	}

	public long getOkInCurMin() {
		return ok.get() - okByLastMin;
	}

	public void setErrInLastMin() {
		long errNow = err.get();
		errInLastMin = errNow - errByLastMin;
		errByLastMin = errNow;
	}

	public long getErrInLastMin() {
		return errInLastMin;
	}

	public long getErrInCurMin() {
		return err.get() - errByLastMin;
	}
}
