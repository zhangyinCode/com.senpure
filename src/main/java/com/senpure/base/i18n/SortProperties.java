package com.senpure.base.i18n;

import java.util.*;

/**
 * 
 * 不敢说效率
 * 
 *
 * @version 1.0
 */
public class SortProperties extends Properties {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1291274099733093658L;
	private  final LinkedHashSet<Object> keys = new LinkedHashSet<Object>();
	 

    public Enumeration<Object> keys() {

        return Collections.<Object> enumeration(keys);

    }
 

    public Object put(Object key, Object value) {
        keys.add(key);
        return super.put(key, value);

    }
 

    public Set<Object> keySet() {

        return keys;

    }
 

    public Set<String> stringPropertyNames() {

        Set<String> set = new LinkedHashSet<String>();
 

        for (Object key : this.keys) {

            set.add((String) key);

        }
 

        return set;

    }
}
