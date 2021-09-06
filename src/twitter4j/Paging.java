package twitter4j;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public final class Paging implements Serializable {
	private static final long serialVersionUID = -7226113618341047983L;
	private int page;
	private int count;
	private long sinceId;
	private long maxId;
	static final char[] S;
	static final char[] SMCP;
	static final String COUNT = "count";
	static final String PER_PAGE = "per_page";
	private static final HttpParameter[] NULL_PARAMETER_ARRAY;
	private static final List<HttpParameter> NULL_PARAMETER_LIST;

	static {
		S = new char[] { 's' };
		SMCP = new char[] { 's', 'm', 'c', 'p' };
		NULL_PARAMETER_ARRAY = new HttpParameter[0];
		NULL_PARAMETER_LIST = new ArrayList<HttpParameter>(0);
	}

	List<HttpParameter> asPostParameterList() {
		return this.asPostParameterList(Paging.SMCP, "count");
	}

	HttpParameter[] asPostParameterArray() {
		final List<HttpParameter> list = this.asPostParameterList(Paging.SMCP, "count");
		if (list.size() == 0) {
			return Paging.NULL_PARAMETER_ARRAY;
		}
		return list.toArray(new HttpParameter[list.size()]);
	}

	List<HttpParameter> asPostParameterList(final char[] supportedParams) {
		return this.asPostParameterList(supportedParams, "count");
	}

	List<HttpParameter> asPostParameterList(final char[] supportedParams, final String perPageParamName) {
		final List<HttpParameter> pagingParams = new ArrayList<HttpParameter>(supportedParams.length);
		this.addPostParameter(supportedParams, 's', pagingParams, "since_id", this.getSinceId());
		this.addPostParameter(supportedParams, 'm', pagingParams, "max_id", this.getMaxId());
		this.addPostParameter(supportedParams, 'c', pagingParams, perPageParamName, this.getCount());
		this.addPostParameter(supportedParams, 'p', pagingParams, "page", this.getPage());
		if (pagingParams.size() == 0) {
			return Paging.NULL_PARAMETER_LIST;
		}
		return pagingParams;
	}

	HttpParameter[] asPostParameterArray(final char[] supportedParams, final String perPageParamName) {
		final List<HttpParameter> pagingParams = new ArrayList<HttpParameter>(supportedParams.length);
		this.addPostParameter(supportedParams, 's', pagingParams, "since_id", this.getSinceId());
		this.addPostParameter(supportedParams, 'm', pagingParams, "max_id", this.getMaxId());
		this.addPostParameter(supportedParams, 'c', pagingParams, perPageParamName, this.getCount());
		this.addPostParameter(supportedParams, 'p', pagingParams, "page", this.getPage());
		if (pagingParams.size() == 0) {
			return Paging.NULL_PARAMETER_ARRAY;
		}
		return pagingParams.toArray(new HttpParameter[pagingParams.size()]);
	}

	private void addPostParameter(final char[] supportedParams, final char paramKey,
			final List<HttpParameter> pagingParams, final String paramName, final long paramValue) {
		boolean supported = false;
		for (final char supportedParam : supportedParams) {
			if (supportedParam == paramKey) {
				supported = true;
				break;
			}
		}
		if (!supported && -1L != paramValue) {
			throw new IllegalStateException(
					"Paging parameter [" + paramName + "] is not supported with this operation.");
		}
		if (-1L != paramValue) {
			pagingParams.add(new HttpParameter(paramName, String.valueOf(paramValue)));
		}
	}

	public Paging() {
		this.page = -1;
		this.count = -1;
		this.sinceId = -1L;
		this.maxId = -1L;
	}

	public Paging(final int page) {
		this.page = -1;
		this.count = -1;
		this.sinceId = -1L;
		this.maxId = -1L;
		this.setPage(page);
	}

	public Paging(final long sinceId) {
		this.page = -1;
		this.count = -1;
		this.sinceId = -1L;
		this.maxId = -1L;
		this.setSinceId(sinceId);
	}

	public Paging(final int page, final int count) {
		this(page);
		this.setCount(count);
	}

	public Paging(final int page, final long sinceId) {
		this(page);
		this.setSinceId(sinceId);
	}

	public Paging(final int page, final int count, final long sinceId) {
		this(page, count);
		this.setSinceId(sinceId);
	}

	public Paging(final int page, final int count, final long sinceId, final long maxId) {
		this(page, count, sinceId);
		this.setMaxId(maxId);
	}

	public int getPage() {
		return this.page;
	}

	public void setPage(final int page) {
		if (page < 1) {
			throw new IllegalArgumentException("page should be positive integer. passed:" + page);
		}
		this.page = page;
	}

	public int getCount() {
		return this.count;
	}

	public void setCount(final int count) {
		if (count < 1) {
			throw new IllegalArgumentException("count should be positive integer. passed:" + count);
		}
		this.count = count;
	}

	public Paging count(final int count) {
		this.setCount(count);
		return this;
	}

	public long getSinceId() {
		return this.sinceId;
	}

	public void setSinceId(final long sinceId) {
		if (sinceId < 1L) {
			throw new IllegalArgumentException("since_id should be positive integer. passed:" + sinceId);
		}
		this.sinceId = sinceId;
	}

	public Paging sinceId(final long sinceId) {
		this.setSinceId(sinceId);
		return this;
	}

	public long getMaxId() {
		return this.maxId;
	}

	public void setMaxId(final long maxId) {
		if (maxId < 1L) {
			throw new IllegalArgumentException("max_id should be positive integer. passed:" + maxId);
		}
		this.maxId = maxId;
	}

	public Paging maxId(final long maxId) {
		this.setMaxId(maxId);
		return this;
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof Paging)) {
			return false;
		}
		final Paging paging = (Paging) o;
		return this.count == paging.count && this.maxId == paging.maxId && this.page == paging.page
				&& this.sinceId == paging.sinceId;
	}

	@Override
	public int hashCode() {
		int result = this.page;
		result = 31 * result + this.count;
		result = 31 * result + (int) (this.sinceId ^ this.sinceId >>> 32);
		result = 31 * result + (int) (this.maxId ^ this.maxId >>> 32);
		return result;
	}

	@Override
	public String toString() {
		return "Paging{page=" + this.page + ", count=" + this.count + ", sinceId=" + this.sinceId + ", maxId="
				+ this.maxId + '}';
	}
}
