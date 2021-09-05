package twitter4j;

import java.io.IOException;
import java.io.Writer;
import java.util.Map;
import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.Collection;
import java.util.ArrayList;

public class JSONArray
{
    private final ArrayList myArrayList;
    
    public JSONArray() {
        this.myArrayList = new ArrayList();
    }
    
    public JSONArray(final JSONTokener x) throws JSONException {
        this();
        if (x.nextClean() != '[') {
            throw x.syntaxError("A JSONArray text must start with '['");
        }
        if (x.nextClean() == ']') {
            return;
        }
        x.back();
        while (true) {
            if (x.nextClean() == ',') {
                x.back();
                this.myArrayList.add(JSONObject.NULL);
            }
            else {
                x.back();
                this.myArrayList.add(x.nextValue());
            }
            switch (x.nextClean()) {
                case ',':
                case ';': {
                    if (x.nextClean() == ']') {
                        return;
                    }
                    x.back();
                    continue;
                }
                case ']': {}
                default: {
                    throw x.syntaxError("Expected a ',' or ']'");
                }
            }
        }
    }
    
    public JSONArray(final String source) throws JSONException {
        this(new JSONTokener(source));
    }
    
    public JSONArray(final Collection collection) {
        this.myArrayList = new ArrayList();
        if (collection != null) {
            for (final Object aCollection : collection) {
                this.myArrayList.add(JSONObject.wrap(aCollection));
            }
        }
    }
    
    public JSONArray(final Object array) throws JSONException {
        this();
        if (array.getClass().isArray()) {
            for (int length = Array.getLength(array), i = 0; i < length; ++i) {
                this.put(JSONObject.wrap(Array.get(array, i)));
            }
            return;
        }
        throw new JSONException("JSONArray initial value should be a string or collection or array.");
    }
    
    public Object get(final int index) throws JSONException {
        final Object object = this.opt(index);
        if (object == null) {
            throw new JSONException("JSONArray[" + index + "] not found.");
        }
        return object;
    }
    
    public boolean getBoolean(final int index) throws JSONException {
        final Object object = this.get(index);
        if (object.equals(Boolean.FALSE) || (object instanceof String && ((String)object).equalsIgnoreCase("false"))) {
            return false;
        }
        if (object.equals(Boolean.TRUE) || (object instanceof String && ((String)object).equalsIgnoreCase("true"))) {
            return true;
        }
        throw new JSONException("JSONArray[" + index + "] is not a boolean.");
    }
    
    public double getDouble(final int index) throws JSONException {
        final Object object = this.get(index);
        try {
            return (object instanceof Number) ? ((Number)object).doubleValue() : Double.parseDouble((String)object);
        }
        catch (Exception e) {
            throw new JSONException("JSONArray[" + index + "] is not a number.");
        }
    }
    
    public int getInt(final int index) throws JSONException {
        final Object object = this.get(index);
        try {
            return (object instanceof Number) ? ((Number)object).intValue() : Integer.parseInt((String)object);
        }
        catch (Exception e) {
            throw new JSONException("JSONArray[" + index + "] is not a number.");
        }
    }
    
    public JSONArray getJSONArray(final int index) throws JSONException {
        final Object object = this.get(index);
        if (object instanceof JSONArray) {
            return (JSONArray)object;
        }
        throw new JSONException("JSONArray[" + index + "] is not a JSONArray.");
    }
    
    public JSONObject getJSONObject(final int index) throws JSONException {
        final Object object = this.get(index);
        if (object instanceof JSONObject) {
            return (JSONObject)object;
        }
        throw new JSONException("JSONArray[" + index + "] is not a JSONObject.");
    }
    
    public long getLong(final int index) throws JSONException {
        final Object object = this.get(index);
        try {
            return (object instanceof Number) ? ((Number)object).longValue() : Long.parseLong((String)object);
        }
        catch (Exception e) {
            throw new JSONException("JSONArray[" + index + "] is not a number.");
        }
    }
    
    public String getString(final int index) throws JSONException {
        final Object object = this.get(index);
        return (object == JSONObject.NULL) ? null : object.toString();
    }
    
    public boolean isNull(final int index) {
        return JSONObject.NULL.equals(this.opt(index));
    }
    
    public String join(final String separator) throws JSONException {
        final int len = this.length();
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; ++i) {
            if (i > 0) {
                sb.append(separator);
            }
            sb.append(JSONObject.valueToString(this.myArrayList.get(i)));
        }
        return sb.toString();
    }
    
    public int length() {
        return this.myArrayList.size();
    }
    
    public Object opt(final int index) {
        return (index < 0 || index >= this.length()) ? null : this.myArrayList.get(index);
    }
    
    public JSONArray put(final boolean value) {
        this.put(value ? Boolean.TRUE : Boolean.FALSE);
        return this;
    }
    
    public JSONArray put(final Collection value) {
        this.put(new JSONArray(value));
        return this;
    }
    
    public JSONArray put(final int value) {
        this.put(new Integer(value));
        return this;
    }
    
    public JSONArray put(final long value) {
        this.put(new Long(value));
        return this;
    }
    
    public JSONArray put(final Map value) {
        this.put(new JSONObject(value));
        return this;
    }
    
    public JSONArray put(final Object value) {
        this.myArrayList.add(value);
        return this;
    }
    
    public JSONArray put(final int index, final boolean value) throws JSONException {
        this.put(index, value ? Boolean.TRUE : Boolean.FALSE);
        return this;
    }
    
    public JSONArray put(final int index, final Collection value) throws JSONException {
        this.put(index, new JSONArray(value));
        return this;
    }
    
    public JSONArray put(final int index, final double value) throws JSONException {
        this.put(index, new Double(value));
        return this;
    }
    
    public JSONArray put(final int index, final int value) throws JSONException {
        this.put(index, new Integer(value));
        return this;
    }
    
    public JSONArray put(final int index, final long value) throws JSONException {
        this.put(index, new Long(value));
        return this;
    }
    
    public JSONArray put(final int index, final Map value) throws JSONException {
        this.put(index, new JSONObject(value));
        return this;
    }
    
    public JSONArray put(final int index, final Object value) throws JSONException {
        JSONObject.testValidity(value);
        if (index < 0) {
            throw new JSONException("JSONArray[" + index + "] not found.");
        }
        if (index < this.length()) {
            this.myArrayList.set(index, value);
        }
        else {
            while (index != this.length()) {
                this.put(JSONObject.NULL);
            }
            this.put(value);
        }
        return this;
    }
    
    @Override
    public String toString() {
        try {
            return String.valueOf('[') + this.join(",") + ']';
        }
        catch (Exception e) {
            return null;
        }
    }
    
    public String toString(final int indentFactor) throws JSONException {
        return this.toString(indentFactor, 0);
    }
    
    String toString(final int indentFactor, final int indent) throws JSONException {
        final int len = this.length();
        if (len == 0) {
            return "[]";
        }
        final StringBuilder sb = new StringBuilder("[");
        if (len == 1) {
            sb.append(JSONObject.valueToString(this.myArrayList.get(0), indentFactor, indent));
        }
        else {
            final int newindent = indent + indentFactor;
            sb.append('\n');
            for (int i = 0; i < len; ++i) {
                if (i > 0) {
                    sb.append(",\n");
                }
                for (int j = 0; j < newindent; ++j) {
                    sb.append(' ');
                }
                sb.append(JSONObject.valueToString(this.myArrayList.get(i), indentFactor, newindent));
            }
            sb.append('\n');
            for (int i = 0; i < indent; ++i) {
                sb.append(' ');
            }
        }
        sb.append(']');
        return sb.toString();
    }
    
    public Writer write(final Writer writer) throws JSONException {
        try {
            boolean b = false;
            final int len = this.length();
            writer.write(91);
            for (int i = 0; i < len; ++i) {
                if (b) {
                    writer.write(44);
                }
                final Object v = this.myArrayList.get(i);
                if (v instanceof JSONObject) {
                    ((JSONObject)v).write(writer);
                }
                else if (v instanceof JSONArray) {
                    ((JSONArray)v).write(writer);
                }
                else {
                    writer.write(JSONObject.valueToString(v));
                }
                b = true;
            }
            writer.write(93);
            return writer;
        }
        catch (IOException e) {
            throw new JSONException(e);
        }
    }
}
