package twitter4j;

import java.io.Serializable;

public class GeoLocation implements Serializable
{
    private static final long serialVersionUID = 6353721071298376949L;
    private double latitude;
    private double longitude;
    
    public GeoLocation(final double latitude, final double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }
    
    GeoLocation() {
    }
    
    public double getLatitude() {
        return this.latitude;
    }
    
    public double getLongitude() {
        return this.longitude;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof GeoLocation)) {
            return false;
        }
        final GeoLocation that = (GeoLocation)o;
        return Double.compare(that.getLatitude(), this.latitude) == 0 && Double.compare(that.getLongitude(), this.longitude) == 0;
    }
    
    @Override
    public int hashCode() {
        long temp = Double.doubleToLongBits(this.latitude);
        int result = (int)(temp ^ temp >>> 32);
        temp = Double.doubleToLongBits(this.longitude);
        result = 31 * result + (int)(temp ^ temp >>> 32);
        return result;
    }
    
    @Override
    public String toString() {
        return "GeoLocation{latitude=" + this.latitude + ", longitude=" + this.longitude + '}';
    }
}
