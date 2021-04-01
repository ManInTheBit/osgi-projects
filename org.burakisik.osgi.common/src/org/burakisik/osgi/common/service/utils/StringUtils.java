package org.burakisik.osgi.common.service.utils;

public interface StringUtils {
		
    /**
     * Format string by given length
     * 
     * @param str the string to be formated
     * @param maxLength the length that is maximum length of formated string
     * @return formated string
     */
    public String format(String str, int maxLength);


}
