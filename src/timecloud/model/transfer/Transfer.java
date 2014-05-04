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
package timecloud.model.transfer;

import java.io.Serializable;
import org.joda.time.DateTime;

/**
 *
 * Model interface defining the available getters, setters, constructors and
 * operations for Transfer
 *
 * @author Pieter Van Eeckhout
 */
public interface Transfer extends Serializable {

    long getTransferID();

    void setTransferID(long transferID);

    String getEndBed();

    String getEndDepartment();

    String getEndMedicalDepartment();

    String getStartBed();

    String getStartDepartment();

    String getStartMedicalDepartment();

    DateTime getTransferTimestamp();

    void setEndBed(String endBed);

    void setEndDepartment(String endDepartment);

    void setEndMedicalDepartment(String endMedicalDepartment);

    void setStartBed(String startBed);

    void setStartDepartment(String startDepartment);

    void setStartMedicalDeparment(String StartMedicalDeparment);

    void setTransferTimestamp(DateTime transferTimestamp);

}
