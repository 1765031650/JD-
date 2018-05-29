package com.bw.arp.jd.My.MyMessage.presenter;

import com.bw.arp.jd.My.MyMessage.bean.MyMessageBean;
import com.bw.arp.jd.My.MyMessage.model.MessageModel;
import com.bw.arp.jd.My.MyMessage.view.IMessageView;

/**
 * Created by ARP on 2018/4/25.
 */

public class MessagePresenter implements IMessagePresenter{
    private MessageModel messageModel;
    private IMessageView iMessageView;

    public MessagePresenter(IMessageView iMessageView) {
        this.iMessageView = iMessageView;
        this.messageModel = new MessageModel();
    }

    public void getMessageData(String uid){
        messageModel.getMine(uid,this);
    }

    @Override
    public void Show(MyMessageBean myMessageBean) {
        iMessageView.onSuccess(myMessageBean);
    }
}
