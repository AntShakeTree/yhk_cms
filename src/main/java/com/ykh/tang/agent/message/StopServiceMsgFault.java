package com.ykh.tang.agent.message;

/**
 * 55.关闭业务失败应答消息，0x00010124
 *
 * @author xianchao.ji
 */
public class StopServiceMsgFault extends BaseConfMsgFault implements IMessageHandler {
    int serviceID;// 业务类型ID

    public int getServiceID() {
        return serviceID;
    }

    public void setServiceID(int serviceID) {
        this.serviceID = serviceID;
    }

    @Override
    public void invoke() {
        System.out.println("invoke(msgType = " + super.getMessageType() + " confID=" + super.getConfID() + ")...............");
    }
}
