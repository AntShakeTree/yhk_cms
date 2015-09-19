package com.ykh.tang.agent.message;

/**
 * 54.关闭业务成功应答消息，0x00010122
 *
 * @author xianchao.ji
 */
public class StopServiceMsgResult extends BaseConfMsgResult implements IMessageHandler {
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
