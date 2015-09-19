package com.ykh.tang.agent.message;

/**
 * 52.开启业务成功应答消息，0x00010112
 *
 * @author xianchao.ji
 */
public class StartServiceMsgResult extends BaseConfMsgResult implements IMessageHandler {
    int serviceID;// 业务类型ID
    int groupID;
    int channeled; // 通道ID

    public int getServiceID() {
        return serviceID;
    }

    public void setServiceID(int serviceID) {
        this.serviceID = serviceID;
    }

    public int getGroupID() {
        return groupID;
    }

    public void setGroupID(int groupID) {
        this.groupID = groupID;
    }

    public int getChanneled() {
        return channeled;
    }

    public void setChanneled(int channeled) {
        this.channeled = channeled;
    }

    @Override
    public void invoke() {
        System.out.println("invoke(msgType = " + super.getMessageType() + " confID=" + super.getConfID() + ")...............");
    }
}
