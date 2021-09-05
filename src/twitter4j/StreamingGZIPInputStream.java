package twitter4j;

import java.io.IOException;
import java.io.InputStream;
import java.util.zip.GZIPInputStream;

final class StreamingGZIPInputStream extends GZIPInputStream
{
    private final InputStream wrapped;
    
    public StreamingGZIPInputStream(final InputStream is) throws IOException {
        super(is);
        this.wrapped = is;
    }
    
    @Override
    public int available() throws IOException {
        return this.wrapped.available();
    }
}
