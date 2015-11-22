package com.doctor;

import eu.bitwalker.useragentutils.UserAgent;
import net.sf.uadetector.ReadableUserAgent;
import net.sf.uadetector.UserAgentStringParser;
import net.sf.uadetector.service.UADetectorServiceFactory;

/**
 * Detect Device Type In Java Web Application
 * 
 * @author sdcuike
 *
 * @time 2015年11月16日 上午9:03:17
 * 
 * @see http://www.javatips.net/blog/2014/09/detect-device-type-in-java-web-application
 *      https://github.com/before/uadetector
 *      https://udger.com/resources/online-parser
 * 
 *      http://www.bitwalker.eu/software/user-agent-utils
 * 
 * 
 * 
 * 
 *      Detect Device Type In Java Web Application explain about identifying the device type such as desktop, tablet or mobile of client by accessing your Website.
 * 
 *      For example, in your project you need to show 2 different versions of website. One is for mobile viewers and another for desktop viewers. For this you need to identify whether the request coming form a Mobile device. After detecting device type using user-agents string from
 *      HttpServletRequest. you can forward to different urls.
 * 
 *      How to identify whether a user request is coming from Mobile/Tablet/Desktop?
 * 
 *      For identifying the device type (whether the request is coming from mobile, tablet or desktop), you need to parse User-Agents string in your java web application, It is server side device detection.
 * 
 *      We have following 3 approaches to detect the device types by parsing User-Agents.
 * 
 *      1) By Using UADetector
 *      2) By Using user-agent-utils
 *      3) By Using Spring Framework
 */
public class DetectDeviceTypeinJavaWebApplicationI {

    public static void main(String[] args) {
        String userAgentString = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10.10; rv:41.0) Gecko/20100101 Firefox/41.0";
        ReadableUserAgent userAgent = getUADetectorExample(userAgentString);
        System.out.println(userAgent);

        UserAgent userAgent2 = UserAgent.parseUserAgentString(userAgentString);
        System.out.println(userAgent2);

    }

    private static ReadableUserAgent getUADetectorExample(String userAgentString) {
        UserAgentStringParser userAgentStringParser = UADetectorServiceFactory.getCachingAndUpdatingParser();
        return userAgentStringParser.parse(userAgentString);
    }

}
