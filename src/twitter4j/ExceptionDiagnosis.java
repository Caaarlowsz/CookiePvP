package twitter4j;

import java.io.Serializable;

final class ExceptionDiagnosis implements Serializable {
	private static final long serialVersionUID = 8501009773274399369L;
	private int stackLineHash;
	private int lineNumberHash;
	private String hexString;

	ExceptionDiagnosis(final Throwable th) {
		this(th, new String[0]);
	}

	ExceptionDiagnosis(final Throwable th, final String[] inclusionFilter) {
		this.hexString = "";
		final StackTraceElement[] stackTrace = th.getStackTrace();
		this.stackLineHash = 0;
		this.lineNumberHash = 0;
		for (int i = stackTrace.length - 1; i >= 0; --i) {
			final StackTraceElement line = stackTrace[i];
			for (final String filter : inclusionFilter) {
				if (line.getClassName().startsWith(filter)) {
					final int hash = line.getClassName().hashCode() + line.getMethodName().hashCode();
					this.stackLineHash = 31 * this.stackLineHash + hash;
					this.lineNumberHash = 31 * this.lineNumberHash + line.getLineNumber();
					break;
				}
			}
		}
		this.hexString = String.valueOf(this.hexString) + this.toHexString(this.stackLineHash) + "-"
				+ this.toHexString(this.lineNumberHash);
		if (th.getCause() != null) {
			this.hexString = String.valueOf(this.hexString) + " "
					+ new ExceptionDiagnosis(th.getCause(), inclusionFilter).asHexString();
		}
	}

	int getStackLineHash() {
		return this.stackLineHash;
	}

	String getStackLineHashAsHex() {
		return this.toHexString(this.stackLineHash);
	}

	int getLineNumberHash() {
		return this.lineNumberHash;
	}

	String getLineNumberHashAsHex() {
		return this.toHexString(this.lineNumberHash);
	}

	String asHexString() {
		return this.hexString;
	}

	private String toHexString(final int value) {
		final String str = "0000000" + Integer.toHexString(value);
		return str.substring(str.length() - 8, str.length());
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || this.getClass() != o.getClass()) {
			return false;
		}
		final ExceptionDiagnosis that = (ExceptionDiagnosis) o;
		return this.lineNumberHash == that.lineNumberHash && this.stackLineHash == that.stackLineHash;
	}

	@Override
	public int hashCode() {
		int result = this.stackLineHash;
		result = 31 * result + this.lineNumberHash;
		return result;
	}

	@Override
	public String toString() {
		return "ExceptionDiagnosis{stackLineHash=" + this.stackLineHash + ", lineNumberHash=" + this.lineNumberHash
				+ '}';
	}
}
