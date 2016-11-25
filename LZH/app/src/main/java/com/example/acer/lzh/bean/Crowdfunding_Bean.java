package com.example.acer.lzh.bean;

import java.util.List;

/**
 * Created by acer on 2016-11-25.
 */

public class Crowdfunding_Bean {

    /**
     * crowdfundingId : 1050840
     * mainImg : /app/20161124/cf/5f80f0b2-21ff-45b9-ac28-345b23a68eaa.jpg?1479975022261
     * stateId : 3
     * stateName : 进行中
     * title : 一把檀木梳的理性与感性之美
     * subtitle : 梳子的理性之美，在于万中无一的选材和上万次的雕琢；感性之美则在于传承而出新的好设计。
     * collect : 5
     * support : 2
     * finish : 7
     * label : null
     * min : 78
     * max : 118
     * crowdfundingVideo :
     * targetMoney : 3000
     * money : 236
     * end : 1987200
     * introduction : 梳子的理性之美，在于万中无一的选材和上万次的雕琢；而感性之美则在于传承而出新的好设计。
     * originator : 非遗传承人周广胜
     * day : 24
     * pattern : 拼团
     */

    private List<CrowdfundingBean> crowdfunding;
    /**
     * tagId : 11269
     * tagName : 古法美食
     */

    private List<TagListBean> tagList;

    public List<CrowdfundingBean> getCrowdfunding() {
        return crowdfunding;
    }

    public void setCrowdfunding(List<CrowdfundingBean> crowdfunding) {
        this.crowdfunding = crowdfunding;
    }

    public List<TagListBean> getTagList() {
        return tagList;
    }

    public void setTagList(List<TagListBean> tagList) {
        this.tagList = tagList;
    }

    public static class CrowdfundingBean {
        private int crowdfundingId;
        private String mainImg;
        private int stateId;
        private String stateName;
        private String title;
        private String subtitle;
        private int collect;
        private int support;
        private int finish;
        private Object label;
        private int min;
        private int max;
        private String crowdfundingVideo;
        private int targetMoney;
        private int money;
        private int end;
        private String introduction;
        private String originator;
        private int day;
        private String pattern;

        public int getCrowdfundingId() {
            return crowdfundingId;
        }

        public void setCrowdfundingId(int crowdfundingId) {
            this.crowdfundingId = crowdfundingId;
        }

        public String getMainImg() {
            return mainImg;
        }

        public void setMainImg(String mainImg) {
            this.mainImg = mainImg;
        }

        public int getStateId() {
            return stateId;
        }

        public void setStateId(int stateId) {
            this.stateId = stateId;
        }

        public String getStateName() {
            return stateName;
        }

        public void setStateName(String stateName) {
            this.stateName = stateName;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getSubtitle() {
            return subtitle;
        }

        public void setSubtitle(String subtitle) {
            this.subtitle = subtitle;
        }

        public int getCollect() {
            return collect;
        }

        public void setCollect(int collect) {
            this.collect = collect;
        }

        public int getSupport() {
            return support;
        }

        public void setSupport(int support) {
            this.support = support;
        }

        public int getFinish() {
            return finish;
        }

        public void setFinish(int finish) {
            this.finish = finish;
        }

        public Object getLabel() {
            return label;
        }

        public void setLabel(Object label) {
            this.label = label;
        }

        public int getMin() {
            return min;
        }

        public void setMin(int min) {
            this.min = min;
        }

        public int getMax() {
            return max;
        }

        public void setMax(int max) {
            this.max = max;
        }

        public String getCrowdfundingVideo() {
            return crowdfundingVideo;
        }

        public void setCrowdfundingVideo(String crowdfundingVideo) {
            this.crowdfundingVideo = crowdfundingVideo;
        }

        public int getTargetMoney() {
            return targetMoney;
        }

        public void setTargetMoney(int targetMoney) {
            this.targetMoney = targetMoney;
        }

        public int getMoney() {
            return money;
        }

        public void setMoney(int money) {
            this.money = money;
        }

        public int getEnd() {
            return end;
        }

        public void setEnd(int end) {
            this.end = end;
        }

        public String getIntroduction() {
            return introduction;
        }

        public void setIntroduction(String introduction) {
            this.introduction = introduction;
        }

        public String getOriginator() {
            return originator;
        }

        public void setOriginator(String originator) {
            this.originator = originator;
        }

        public int getDay() {
            return day;
        }

        public void setDay(int day) {
            this.day = day;
        }

        public String getPattern() {
            return pattern;
        }

        public void setPattern(String pattern) {
            this.pattern = pattern;
        }
    }

    public static class TagListBean {
        private int tagId;
        private String tagName;

        public int getTagId() {
            return tagId;
        }

        public void setTagId(int tagId) {
            this.tagId = tagId;
        }

        public String getTagName() {
            return tagName;
        }

        public void setTagName(String tagName) {
            this.tagName = tagName;
        }
    }
}
