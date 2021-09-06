package twitter4j;

class PagableResponseListImpl<T extends TwitterResponse> extends ResponseListImpl<T> implements PagableResponseList<T> {
	private static final long serialVersionUID = -8603601553967559275L;
	private final long previousCursor;
	private final long nextCursor;

	PagableResponseListImpl(final RateLimitStatus rateLimitStatus, final int accessLevel) {
		super(rateLimitStatus, accessLevel);
		this.previousCursor = 0L;
		this.nextCursor = 0L;
	}

	PagableResponseListImpl(final int size, final JSONObject json, final HttpResponse res) {
		super(size, res);
		this.previousCursor = ParseUtil.getLong("previous_cursor", json);
		this.nextCursor = ParseUtil.getLong("next_cursor", json);
	}

	@Override
	public boolean hasPrevious() {
		return 0L != this.previousCursor;
	}

	@Override
	public long getPreviousCursor() {
		return this.previousCursor;
	}

	@Override
	public boolean hasNext() {
		return 0L != this.nextCursor;
	}

	@Override
	public long getNextCursor() {
		return this.nextCursor;
	}
}
