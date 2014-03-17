/*
 *   The MIT License (MIT)
 *
 *   Copyright (c) 2014 Pieter Van Eeckhout
 *
 *   Permission is hereby granted, free of charge, to any person obtaining a copy of
 *   this software and associated documentation files (the "Software"), to deal in
 *   the Software without restriction, including without limitation the rights to
 *   use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of
 *   the Software, and to permit persons to whom the Software is furnished to do so,
 *   subject to the following conditions:
 *
 *   The above copyright notice and this permission notice shall be included in all
 *   copies or substantial portions of the Software.
 *
 *   THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 *   IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
 *   FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
 *   COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER
 *   IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
 *   CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package timecloud.util.converters;

import org.joda.time.DateTime;

/**
 *
 * @author Pieter Van Eeckhout
 */
public class StringDateTimeConverter {

    public static DateTime stringToDateTime(String dateString) {
        String split[] = dateString.split(" ");

        String datePart = split[0];
        String timePart = split[1];

        String dateSplit[] = datePart.split("-");
        String timeSplit[] = timePart.split(":");

        return new DateTime(Integer.parseInt(dateSplit[0]), Integer.parseInt(dateSplit[1]), Integer.parseInt(dateSplit[2]), Integer.parseInt(timeSplit[0]), Integer.parseInt(timeSplit[1]), Integer.parseInt(timeSplit[2]));

    }
}
