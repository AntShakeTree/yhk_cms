package com.ykh.tang.agent.message;

/**
 * 53.开启业务失败应答消息，0x00010114
 *
 * @author xianchao.ji
 */
public class StartServiceMsgFault extends BaseConfMsgFault implements IMessageHandler {
    private int serviced;// 业务类型ID

    public int getServiced() {
        return serviced;
    }

    public void setServiced(int serviced) {
        this.serviced = serviced;
    }

    @Override
    public void invoke() {
        System.out.println("invoke(msgType = " + super.getMessageType() + " confID=" + super.getConfID() + ")...............");
    }
}
