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

import org.joda.time.DateTime;

public class TransferBuilderImpl implements TransferBuilder {

    private long transferID;
    private DateTime transferTimestamp;
    private String startDepartment;
    private String startBed;
    private String StartMedicalDeparment;
    private String endDepartment;
    private String endBed;
    private String endMedicalDepartment;

    @Override
    public TransferBuilderImpl setTransferID(long transferID) {
        this.transferID = transferID;
        return this;
    }

    @Override
    public TransferBuilderImpl setTransferTimestamp(DateTime transferTimestamp) {
        this.transferTimestamp = transferTimestamp;
        return this;
    }

    @Override
    public TransferBuilderImpl setStartDepartment(String startDepartment) {
        this.startDepartment = startDepartment;
        return this;
    }

    @Override
    public TransferBuilderImpl setStartBed(String startBed) {
        this.startBed = startBed;
        return this;
    }

    @Override
    public TransferBuilderImpl setStartMedicalDepartment(String StartMedicalDeparment) {
        this.StartMedicalDeparment = StartMedicalDeparment;
        return this;
    }

    @Override
    public TransferBuilderImpl setEndDepartment(String endDepartment) {
        this.endDepartment = endDepartment;
        return this;
    }

    @Override
    public TransferBuilderImpl setEndBed(String endBed) {
        this.endBed = endBed;
        return this;
    }

    @Override
    public TransferBuilderImpl setEndMedicalDepartment(String endMedicalDepartment) {
        this.endMedicalDepartment = endMedicalDepartment;
        return this;
    }

    @Override
    public Transfer createTransfer() {
        return new TransferImpl(transferID, transferTimestamp, startDepartment, startBed, StartMedicalDeparment, endDepartment, endBed, endMedicalDepartment);
    }

}
