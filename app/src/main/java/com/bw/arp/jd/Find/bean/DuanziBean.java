package com.bw.arp.jd.Find.bean;

import java.util.List;

/**
 * Created by ARP on 2018/4/26.
 */

public class DuanziBean {

    /**
     * msg : 获取段子列表成功
     * code : 0
     * data : [{"commentNum":null,"content":"哈哈哈","createTime":"2018-04-26T10:59:14","imgUrls":"https://www.zhaoapi.cn/images/quarter/1524711554574Screenshot_2018-04-23-21-57-17.jpg|https://www.zhaoapi.cn/images/quarter/1524711554574temphead.jpg","jid":2254,"praiseNum":null,"shareNum":null,"uid":3116,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/1524644963145temphead.jpg","nickname":null,"praiseNum":"null"}},{"commentNum":null,"content":"呜哈哈哈哈","createTime":"2018-04-26T10:56:43","imgUrls":"https://www.zhaoapi.cn/images/quarter/1524711403276temphead.jpg|https://www.zhaoapi.cn/images/quarter/1524711403276temphead.jpg|https://www.zhaoapi.cn/images/quarter/1524711403276Screenshot_2018-04-23-21-57-17.jpg","jid":2253,"praiseNum":null,"shareNum":null,"uid":3116,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/1524644963145temphead.jpg","nickname":null,"praiseNum":"null"}},{"commentNum":null,"content":"123455","createTime":"2018-04-26T10:55:05","imgUrls":"https://www.zhaoapi.cn/images/quarter/1524711305353temphead.jpg|https://www.zhaoapi.cn/images/quarter/1524711305353temphead.jpg","jid":2252,"praiseNum":null,"shareNum":null,"uid":3116,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/1524644963145temphead.jpg","nickname":null,"praiseNum":"null"}},{"commentNum":null,"content":"12351515","createTime":"2018-04-26T10:48:59","imgUrls":"https://www.zhaoapi.cn/images/quarter/1524710939023temphead.jpg|https://www.zhaoapi.cn/images/quarter/1524710939023temphead.jpg","jid":2251,"praiseNum":null,"shareNum":null,"uid":3116,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/1524644963145temphead.jpg","nickname":null,"praiseNum":"null"}},{"commentNum":null,"content":"12315681","createTime":"2018-04-26T10:48:27","imgUrls":null,"jid":2250,"praiseNum":null,"shareNum":null,"uid":3116,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/1524644963145temphead.jpg","nickname":null,"praiseNum":"null"}},{"commentNum":null,"content":"快要毕业了，别紧张","createTime":"2018-04-26T09:11:24","imgUrls":null,"jid":2249,"praiseNum":null,"shareNum":null,"uid":10962,"user":{"age":null,"fans":"null","follow":false,"icon":null,"nickname":null,"praiseNum":"null"}},{"commentNum":null,"content":"傻子","createTime":"2018-04-26T08:53:05","imgUrls":"https://www.zhaoapi.cn/images/quarter/15247039856152018-04-26_08-52-30.jpg","jid":2248,"praiseNum":null,"shareNum":null,"uid":12882,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/1524568491723head_icon.jpg","nickname":null,"praiseNum":"null"}},{"commentNum":null,"content":"这是发布的测试数据","createTime":"2018-04-26T08:40:23","imgUrls":null,"jid":2247,"praiseNum":null,"shareNum":null,"uid":11510,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/1524473753240spl.jpg","nickname":null,"praiseNum":"null"}},{"commentNum":null,"content":"图片","createTime":"2018-04-25T22:26:33","imgUrls":null,"jid":2246,"praiseNum":null,"shareNum":null,"uid":2561,"user":{"age":null,"fans":"null","follow":false,"icon":null,"nickname":"嗜血任心","praiseNum":"null"}},{"commentNum":null,"content":"图片","createTime":"2018-04-25T22:24:11","imgUrls":"https://www.zhaoapi.cn/images/quarter/1524666251358一刻钟新版接口文档v1.9.2.docx","jid":2245,"praiseNum":null,"shareNum":null,"uid":2561,"user":{"age":null,"fans":"null","follow":false,"icon":null,"nickname":"嗜血任心","praiseNum":"null"}}]
     */

    private String msg;
    private String code;
    private List<DataBean> data;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * commentNum : null
         * content : 哈哈哈
         * createTime : 2018-04-26T10:59:14
         * imgUrls : https://www.zhaoapi.cn/images/quarter/1524711554574Screenshot_2018-04-23-21-57-17.jpg|https://www.zhaoapi.cn/images/quarter/1524711554574temphead.jpg
         * jid : 2254
         * praiseNum : null
         * shareNum : null
         * uid : 3116
         * user : {"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/1524644963145temphead.jpg","nickname":null,"praiseNum":"null"}
         */

        private Object commentNum;
        private String content;
        private String createTime;
        private String imgUrls;
        private String jid;
        private Object praiseNum;
        private Object shareNum;
        private int uid;
        private UserBean user;

        public Object getCommentNum() {
            return commentNum;
        }

        public void setCommentNum(Object commentNum) {
            this.commentNum = commentNum;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public String getImgUrls() {
            return imgUrls;
        }

        public void setImgUrls(String imgUrls) {
            this.imgUrls = imgUrls;
        }

        public String getJid() {
            return jid;
        }

        public void setJid(String jid) {
            this.jid = jid;
        }

        public Object getPraiseNum() {
            return praiseNum;
        }

        public void setPraiseNum(Object praiseNum) {
            this.praiseNum = praiseNum;
        }

        public Object getShareNum() {
            return shareNum;
        }

        public void setShareNum(Object shareNum) {
            this.shareNum = shareNum;
        }

        public int getUid() {
            return uid;
        }

        public void setUid(int uid) {
            this.uid = uid;
        }

        public UserBean getUser() {
            return user;
        }

        public void setUser(UserBean user) {
            this.user = user;
        }

        public static class UserBean {
            /**
             * age : null
             * fans : null
             * follow : false
             * icon : https://www.zhaoapi.cn/images/1524644963145temphead.jpg
             * nickname : null
             * praiseNum : null
             */

            private Object age;
            private String fans;
            private boolean follow;
            private String icon;
            private Object nickname;
            private String praiseNum;

            public Object getAge() {
                return age;
            }

            public void setAge(Object age) {
                this.age = age;
            }

            public String getFans() {
                return fans;
            }

            public void setFans(String fans) {
                this.fans = fans;
            }

            public boolean isFollow() {
                return follow;
            }

            public void setFollow(boolean follow) {
                this.follow = follow;
            }

            public String getIcon() {
                return icon;
            }

            public void setIcon(String icon) {
                this.icon = icon;
            }

            public Object getNickname() {
                return nickname;
            }

            public void setNickname(Object nickname) {
                this.nickname = nickname;
            }

            public String getPraiseNum() {
                return praiseNum;
            }

            public void setPraiseNum(String praiseNum) {
                this.praiseNum = praiseNum;
            }
        }
    }
}
