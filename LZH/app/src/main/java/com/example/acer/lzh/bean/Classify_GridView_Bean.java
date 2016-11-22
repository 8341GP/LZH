package com.example.acer.lzh.bean;

import java.util.List;

/**
 * Created by --Rain-- on 2016/11/21.
 */
public class Classify_GridView_Bean {

    /**
     * result : 1
     * error : 操作成功！
     * icons : [{"linkType":10,"linkId":"1002","linkName":"美食","iconImg":"/app/20160711/cd/17281c06-3eae-4ce4-996d-06bcb5405c75.png?1468235872746"},{"linkType":10,"linkId":"1004","linkName":"调味","iconImg":"/app/20160711/cd/eea73bf1-58e5-42d2-9b65-326ce95e7e73.png?1468235903285"},{"linkType":10,"linkId":"1005","linkName":"茶","iconImg":"/app/20160711/cd/afb77703-f84d-4470-9c32-311f6959cd75.png?1468235918897"},{"linkType":10,"linkId":"1006","linkName":"酒","iconImg":"/app/20160711/cd/ed3bfb20-28a9-426f-bdb5-33924154a90b.png?1468236030714"},{"linkType":10,"linkId":"1003","linkName":"滋补","iconImg":"/app/20160711/cd/a0e002b5-470e-44a7-96cb-672523f9d8dd.png?1468235885286"},{"linkType":10,"linkId":"1009","linkName":"文房","iconImg":"/app/20160711/cd/b776247a-dc18-48de-8bdc-599d28d1c606.png?1468236087267"},{"linkType":10,"linkId":"1008","linkName":"装扮","iconImg":"/app/20160711/cd/8031a5a0-dbd2-443b-be0e-6d4f662ee664.png?1468236059951"},{"linkType":10,"linkId":"1007","linkName":"工艺品","iconImg":"/app/20160711/cd/c10ead6e-b03b-49cc-b347-6e0fd6418bb8.png?1468236044311"},{"linkType":10,"linkId":"1010","linkName":"家居","iconImg":"/app/20160711/cd/0dce89f1-3c98-4ed5-9e45-5e9cbf09ee00.png?1468236115910"}]
     * banner : [{"img":"/app/20161116/banner/4569e487-d40b-427c-8480-56909d6f7a60.jpg?1479282849874","linkId":"1048840","linkType":4},{"img":"/app/20161118/banner/b3010a7f-7af8-412f-9d60-e0c9acbb3916.jpg?1479433517290","linkId":"105434","linkType":11},{"img":"/app/20161117/banner/79344fe4-4d0a-4ba0-b149-d21e6601c536.jpg?1479363914034","linkId":"1049931","linkType":4},{"img":"/app/20161121/banner/8783f685-182b-48f9-98d7-457b27528274.jpg?1479716020246","linkId":"94460","linkType":11}]
     * discoverItems : [{"commodityId":19732182,"commodityDesc":"桥头 火锅底料","commodityPrice":25,"commodityImg":"/app/20161117/bd/2101ae97-11e7-4b6d-a36e-b0157044f5db.png?1479354569845"},{"commodityId":19733874,"commodityDesc":"邵万生 五花腊肉","commodityPrice":49,"commodityImg":"http://hzlzh.oss-cn-hangzhou.aliyuncs.com/app/20161117/bd/50638116-6552-418c-a6fa-69511a2f8cf7.png?1479354585223"},{"commodityId":19742889,"commodityDesc":"缸鸭狗 手工酒酿","commodityPrice":24,"commodityImg":"/app/20161117/bd/7ccc33ef-8d7b-4de9-b2a7-cfa23b413b28.png?1479354657271"},{"commodityId":19682521,"commodityDesc":"缸鸭狗 家酿糖桂花","commodityPrice":49,"commodityImg":"/app/20161117/bd/5554d5d1-bca2-4658-825a-ae0641764379.png?1479354910890"},{"commodityId":19679241,"commodityDesc":"宝生园 · 野生蜂巢紫云英蜜 2瓶","commodityPrice":39,"commodityImg":"/app/20161117/bd/79cea5e4-c0db-4576-874d-4db773704846.png?1479354707729"},{"commodityId":19694291,"commodityDesc":"缸鸭狗 高粱汤圆","commodityPrice":29,"commodityImg":"/app/20161117/bd/12fc2f29-4c6c-47d6-9ed2-7f7b1a9be25c.png?1479354734733"},{"commodityId":19689480,"commodityDesc":"缸鸭狗 原味汤圆","commodityPrice":44,"commodityImg":"/app/20161117/bd/754e48d1-6528-4e73-804d-042962cf0bb0.png?1479354781939"},{"commodityId":19667142,"commodityDesc":"老大昌 古法贡醋","commodityPrice":29,"commodityImg":"/app/20161117/bd/1bcce26c-6afe-41f3-b859-c882cb820cf0.png?1479354859691"},{"commodityId":19664628,"commodityDesc":"仁昌记 老缸酱油","commodityPrice":33,"commodityImg":"/app/20161117/bd/05b4ac0e-c35a-44ce-bd21-620acd9403df.png?1479354891399"}]
     */

    private int result;
    private String error;
    /**
     * linkType : 10
     * linkId : 1002
     * linkName : 美食
     * iconImg : /app/20160711/cd/17281c06-3eae-4ce4-996d-06bcb5405c75.png?1468235872746
     */

    private List<IconsBean> icons;
    /**
     * img : /app/20161116/banner/4569e487-d40b-427c-8480-56909d6f7a60.jpg?1479282849874
     * linkId : 1048840
     * linkType : 4
     */

    private List<BannerBean> banner;
    /**
     * commodityId : 19732182
     * commodityDesc : 桥头 火锅底料
     * commodityPrice : 25
     * commodityImg : /app/20161117/bd/2101ae97-11e7-4b6d-a36e-b0157044f5db.png?1479354569845
     */

    private List<DiscoverItemsBean> discoverItems;

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public List<IconsBean> getIcons() {
        return icons;
    }

    public void setIcons(List<IconsBean> icons) {
        this.icons = icons;
    }

    public List<BannerBean> getBanner() {
        return banner;
    }

    public void setBanner(List<BannerBean> banner) {
        this.banner = banner;
    }

    public List<DiscoverItemsBean> getDiscoverItems() {
        return discoverItems;
    }

    public void setDiscoverItems(List<DiscoverItemsBean> discoverItems) {
        this.discoverItems = discoverItems;
    }

    public static class IconsBean {
        private int linkType;
        private String linkId;
        private String linkName;
        private String iconImg;

        public int getLinkType() {
            return linkType;
        }

        public void setLinkType(int linkType) {
            this.linkType = linkType;
        }

        public String getLinkId() {
            return linkId;
        }

        public void setLinkId(String linkId) {
            this.linkId = linkId;
        }

        public String getLinkName() {
            return linkName;
        }

        public void setLinkName(String linkName) {
            this.linkName = linkName;
        }

        public String getIconImg() {
            return iconImg;
        }

        public void setIconImg(String iconImg) {
            this.iconImg = iconImg;
        }
    }

    public static class BannerBean {
        private String img;
        private String linkId;
        private int linkType;

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public String getLinkId() {
            return linkId;
        }

        public void setLinkId(String linkId) {
            this.linkId = linkId;
        }

        public int getLinkType() {
            return linkType;
        }

        public void setLinkType(int linkType) {
            this.linkType = linkType;
        }
    }

    public static class DiscoverItemsBean {
        private int commodityId;
        private String commodityDesc;
        private int commodityPrice;
        private String commodityImg;

        public int getCommodityId() {
            return commodityId;
        }

        public void setCommodityId(int commodityId) {
            this.commodityId = commodityId;
        }

        public String getCommodityDesc() {
            return commodityDesc;
        }

        public void setCommodityDesc(String commodityDesc) {
            this.commodityDesc = commodityDesc;
        }

        public int getCommodityPrice() {
            return commodityPrice;
        }

        public void setCommodityPrice(int commodityPrice) {
            this.commodityPrice = commodityPrice;
        }

        public String getCommodityImg() {
            return commodityImg;
        }

        public void setCommodityImg(String commodityImg) {
            this.commodityImg = commodityImg;
        }
    }
}
