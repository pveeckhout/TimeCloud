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
package timecloud.dto.transfer;

import org.joda.time.DateTime;
import timecloud.model.transfer.TransferBuilder;
import timecloud.model.transfer.TransferBuilderImpl;

public class TransferDtoBuilderImpl implements TransferDtoBuilder {

    private final TransferBuilder transferBuilder;

    public TransferDtoBuilderImpl() {
        transferBuilder = new TransferBuilderImpl();
    }

    @Override
    public TransferDtoBuilder setTransferID(long transferID) {
        this.transferBuilder.setTransferID(transferID);
        return this;
    }

    @Override
    public TransferDtoBuilder setTransferTimestamp(DateTime transferTimestamp) {
         this.transferBuilder.setTransferTimestamp(transferTimestamp);
        return this;
    }

    @Override
    public TransferDtoBuilder setStartDepartment(String startDepartment) {
         this.transferBuilder.setStartDepartment(startDepartment);
        return this;
    }

    @Override
    public TransferDtoBuilder setStartBed(String startBed) {
         this.transferBuilder.setStartBed(startBed);
        return this;
    }

    @Override
    public TransferDtoBuilder setStartMedicalDepartment(String StartMedicalDeparment) {
         this.transferBuilder.setStartMedicalDepartment(StartMedicalDeparment);
        return this;
    }

    @Override
    public TransferDtoBuilder setEndDepartment(String endDepartment) {
         this.transferBuilder.setEndDepartment(endDepartment);
        return this;
    }

    @Override
    public TransferDtoBuilder setEndBed(String endBed) {
         this.transferBuilder.setEndBed(endBed);
        return this;
    }

    @Override
    public TransferDtoBuilder setEndMedicalDepartment(String endMedicalDepartment) {
         this.transferBuilder.setEndMedicalDepartment(endMedicalDepartment);
        return this;
    }

    @Override
    public TransferDTO createTransferDto() {
        return new TransferDtoImpl(transferBuilder.createTransfer());
    }

}
