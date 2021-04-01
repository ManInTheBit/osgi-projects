package org.burakisik.osgi.utils;

import org.burakisik.osgi.common.service.utils.StringUtils;
import org.osgi.service.component.annotations.*;

@Component
public class StringUtilsImpl implements StringUtils {
	
	@Override
	public String format(String str, int maxLength) {
		String result = str;
		if(str.length() >= maxLength) {
			result = result.substring(0, maxLength);
		}
		return result;
	}
}
