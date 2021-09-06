package twitter4j;

import java.io.Serializable;

abstract class EntityIndex implements Comparable<EntityIndex>, Serializable {
	private static final long serialVersionUID = 3757474748266170719L;
	private int start;
	private int end;

	EntityIndex() {
		this.start = -1;
		this.end = -1;
	}

	@Override
	public int compareTo(final EntityIndex that) {
		final long delta = this.start - that.start;
		if (delta < -2147483648L) {
			return Integer.MIN_VALUE;
		}
		if (delta > 2147483647L) {
			return Integer.MAX_VALUE;
		}
		return (int) delta;
	}

	void setStart(final int start) {
		this.start = start;
	}

	void setEnd(final int end) {
		this.end = end;
	}

	int getStart() {
		return this.start;
	}

	int getEnd() {
		return this.end;
	}
}
