package com.ykh.services.conference.exception;


public enum CMSErrorCode {

    PARAMETER_NULL(101, "parameter is null。"),
    CONFERENCE_NAME_NULL(102, "conference name is null"),
    STATTTIME_ERROR(103, "starttime is before now"),
    SCALE_ERROR(104, "conference scale is bigger than the open scale"),
    BILLINGCODE_NOT_OPEN(105, "reservConf: owner billingCode error, not opened"),
    SUB_BILLINGCODE_NULL(106, "reservConf: sub billingCode error, billing is null"),
    CONFERENCE_NULL(107, "obtainPin: the conference is not exists, conferenID: "),
    IS_OPENNED(108, "openProduct: the billingcode is opened, billingcode: "),
    SCALE_NULL(109, "parameter conf scale is null"),
    IP_ERROR(110, "ip is not correct"),
    CONFERENCE_NOT_FOUND(111, "conference not found"),
    CONFERENCE_NULL1(112, "obtainPinByTempConfID: the conference is not exists, tempConferenID: "),
    DURATION_ERROR(113, "Duration cannot greater than 1440");

    private final int value;
    private final String msg;

    private CMSErrorCode(int v, String msg) {
        this.value = v;
        this.msg = msg;
    }

    public int value() {
        return this.value;
    }

    public String msg() {
        return msg;
    }

    public String getDescription() {
        return this.value + " = " + msg;
    }

}
