package com.ykh.tang.agent;

import com.ykh.tang.agent.message.IMessage;

/**
 * 消息回调接口类
 *
 * 备注: 只是一个接口类，CMS需实现此接口
 *
 * @author xianchao.ji
 */
public interface IMessageHandler
{
	public void handler(IMessage msg);
}
