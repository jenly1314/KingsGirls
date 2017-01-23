package com.king.girl.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * @author Jenly <a href="mailto:jenly1314@gmail.com">Jenly</a>
 * @since 2017/1/12
 */
public class GirlResult {
    /**
     * error : false
     * results : [{"_id":"58758a6e421aa9315bfbe854","createdAt":"2017-01-11T09:29:18.702Z","desc":"1-11","publishedAt":"2017-01-11T12:05:20.787Z","source":"chrome","type":"福利","url":"http://ww4.sinaimg.cn/large/0060lm7Tgw1fbmfo9is9hj30u00u0ai3.jpg","used":true,"who":"daimajia"},{"_id":"58745425421aa93161103dd7","createdAt":"2017-01-10T11:25:25.871Z","desc":"1-10","publishedAt":"2017-01-10T11:33:19.525Z","source":"chrome","type":"福利","url":"http://ww3.sinaimg.cn/large/610dc034gw1fbldexdog4j20u011h41b.jpg","used":true,"who":"daimajia"},{"_id":"5872f7f2421aa9316407fb84","createdAt":"2017-01-09T10:39:46.599Z","desc":"1-9","publishedAt":"2017-01-09T11:46:59.821Z","source":"chrome","type":"福利","url":"http://ww1.sinaimg.cn/large/610dc034gw1fbk6h23k3ij20u00jymyw.jpg","used":true,"who":"daunahu"},{"_id":"586e1aad421aa9315ea79905","createdAt":"2017-01-05T18:06:37.810Z","desc":"1-5","publishedAt":"2017-01-06T13:20:19.591Z","source":"chrome","type":"福利","url":"http://ww4.sinaimg.cn/large/610dc034gw1fbfwwsjh3zj20u00u00w1.jpg","used":true,"who":"daimajia"},{"_id":"586d8f74421aa9316407fb56","createdAt":"2017-01-05T08:12:36.360Z","desc":"1-5","publishedAt":"2017-01-05T13:18:10.185Z","source":"chrome","type":"福利","url":"http://ww4.sinaimg.cn/large/610dc034jw1fbffqo6jjoj20u011hgpx.jpg","used":true,"who":"daimajia "},{"_id":"586c63a6421aa94dc1ac0b02","createdAt":"2017-01-04T10:53:26.957Z","desc":"1-4","publishedAt":"2017-01-04T11:39:01.326Z","source":"chrome","type":"福利","url":"http://ww4.sinaimg.cn/large/610dc034jw1fbeerrs7aqj20u011htec.jpg","used":true,"who":"daimajia"},{"_id":"586b0915421aa94dbbd82bcf","createdAt":"2017-01-03T10:14:45.467Z","desc":"1-3","publishedAt":"2017-01-03T11:51:31.742Z","source":"chrome","type":"福利","url":"http://ww3.sinaimg.cn/large/610dc034jw1fbd818kkwjj20u011hjup.jpg","used":true,"who":"daimajia"},{"_id":"5865ad4e421aa94dbe2ccdb0","createdAt":"2016-12-30T08:41:50.830Z","desc":"12-30","publishedAt":"2016-12-30T16:16:11.125Z","source":"chrome","type":"福利","url":"http://ww4.sinaimg.cn/large/610dc034jw1fb8iv9u08ij20u00u0tc7.jpg","used":true,"who":"daimajia"},{"_id":"58645be0421aa94dbbd82bac","createdAt":"2016-12-29T08:42:08.389Z","desc":"12-29","publishedAt":"2016-12-29T11:56:56.946Z","source":"chrome","type":"福利","url":"http://ww4.sinaimg.cn/large/610dc034gw1fb7d9am05gj20u011hq64.jpg","used":true,"who":"daimajia"},{"_id":"58632374421aa9723d29b9ba","createdAt":"2016-12-28T10:29:08.507Z","desc":"12-28","publishedAt":"2016-12-28T11:57:39.616Z","source":"chrome","type":"福利","url":"http://ww1.sinaimg.cn/large/610dc034gw1fb6aqccs3nj20u00u0wk4.jpg","used":true,"who":"daimajia"}]
     */

    private boolean error;
    /**
     * _id : 58758a6e421aa9315bfbe854
     * createdAt : 2017-01-11T09:29:18.702Z
     * desc : 1-11
     * publishedAt : 2017-01-11T12:05:20.787Z
     * source : chrome
     * type : 福利
     * url : http://ww4.sinaimg.cn/large/0060lm7Tgw1fbmfo9is9hj30u00u0ai3.jpg
     * used : true
     * who : daimajia
     */

    private List<Girl> results;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public List<Girl> getResults() {
        return results;
    }

    public void setResults(List<Girl> results) {
        this.results = results;
    }

    @Override
    public String toString() {
        return "GirlResult{" +
                "error=" + error +
                ", results=" + results +
                '}';
    }

    public static class Girl implements Parcelable {
        private String _id;
        private String createdAt;
        private String desc;
        private String publishedAt;
        private String source;
        private String type;
        private String url;
        private boolean used;
        private String who;

        public String get_id() {
            return _id;
        }

        public void set_id(String _id) {
            this._id = _id;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getPublishedAt() {
            return publishedAt;
        }

        public void setPublishedAt(String publishedAt) {
            this.publishedAt = publishedAt;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public boolean isUsed() {
            return used;
        }

        public void setUsed(boolean used) {
            this.used = used;
        }

        public String getWho() {
            return who;
        }

        public void setWho(String who) {
            this.who = who;
        }


        @Override
        public String toString() {
            return "Girl{" +
                    "_id='" + _id + '\'' +
                    ", createdAt='" + createdAt + '\'' +
                    ", desc='" + desc + '\'' +
                    ", publishedAt='" + publishedAt + '\'' +
                    ", source='" + source + '\'' +
                    ", type='" + type + '\'' +
                    ", url='" + url + '\'' +
                    ", used=" + used +
                    ", who='" + who + '\'' +
                    '}';
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this._id);
            dest.writeString(this.createdAt);
            dest.writeString(this.desc);
            dest.writeString(this.publishedAt);
            dest.writeString(this.source);
            dest.writeString(this.type);
            dest.writeString(this.url);
            dest.writeByte(this.used ? (byte) 1 : (byte) 0);
            dest.writeString(this.who);
        }

        public Girl() {
        }

        protected Girl(Parcel in) {
            this._id = in.readString();
            this.createdAt = in.readString();
            this.desc = in.readString();
            this.publishedAt = in.readString();
            this.source = in.readString();
            this.type = in.readString();
            this.url = in.readString();
            this.used = in.readByte() != 0;
            this.who = in.readString();
        }

        public static final Creator<Girl> CREATOR = new Creator<Girl>() {
            @Override
            public Girl createFromParcel(Parcel source) {
                return new Girl(source);
            }

            @Override
            public Girl[] newArray(int size) {
                return new Girl[size];
            }
        };
    }
}
