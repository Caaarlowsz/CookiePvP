package twitter4j;

class StringUtil
{
    private StringUtil() {
        throw new AssertionError();
    }
    
    public static String join(final long[] follows) {
        final StringBuilder buf = new StringBuilder(11 * follows.length);
        for (final long follow : follows) {
            if (buf.length() != 0) {
                buf.append(",");
            }
            buf.append(follow);
        }
        return buf.toString();
    }
    
    public static String join(final String[] track) {
        final StringBuilder buf = new StringBuilder(11 * track.length);
        for (final String str : track) {
            if (buf.length() != 0) {
                buf.append(",");
            }
            buf.append(str);
        }
        return buf.toString();
    }
}
