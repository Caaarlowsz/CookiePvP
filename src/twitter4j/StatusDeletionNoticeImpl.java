package twitter4j;

import java.io.Serializable;

class StatusDeletionNoticeImpl implements StatusDeletionNotice, Serializable {
	private static final long serialVersionUID = 9144204870473786368L;
	private final long statusId;
	private final long userId;

	StatusDeletionNoticeImpl(final JSONObject status) {
		this.statusId = ParseUtil.getLong("id", status);
		this.userId = ParseUtil.getLong("user_id", status);
	}

	@Override
	public long getStatusId() {
		return this.statusId;
	}

	@Override
	public long getUserId() {
		return this.userId;
	}

	@Override
	public int compareTo(final StatusDeletionNotice that) {
		final long delta = this.statusId - that.getStatusId();
		if (delta < -2147483648L) {
			return Integer.MIN_VALUE;
		}
		if (delta > 2147483647L) {
			return Integer.MAX_VALUE;
		}
		return (int) delta;
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || this.getClass() != o.getClass()) {
			return false;
		}
		final StatusDeletionNoticeImpl that = (StatusDeletionNoticeImpl) o;
		return this.statusId == that.statusId && this.userId == that.userId;
	}

	@Override
	public int hashCode() {
		int result = (int) (this.statusId ^ this.statusId >>> 32);
		result = 31 * result + (int) (this.userId ^ this.userId >>> 32);
		return result;
	}

	@Override
	public String toString() {
		return "StatusDeletionNoticeImpl{statusId=" + this.statusId + ", userId=" + this.userId + '}';
	}
}
