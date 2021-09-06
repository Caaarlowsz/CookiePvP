package twitter4j;

public final class Version {

	private Version() {
		throw new AssertionError();
	}

	public static String getVersion() {
		return "4.0.4";
	}

	public static void main(final String[] args) {
		System.out.println("Twitter4J 4.0.4");
	}
}
