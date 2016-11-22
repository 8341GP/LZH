package com.example.acer.lzh.url;

/**
 * Created by acer on 2016-11-19.
 */

public class Url {
    //图片的地址
    public static final String IMAGE_PATH="http://images.laozihaojia.com";
    //故事首页
    public static String getAlbumPath(){
        String path ="http://api.laozihaojia.com/album/list.do";
        return   path;
    }
    //故事跳转
    public static String getAlbumDetail(String albumId){
        String path ="http://api.laozihaojia.com/album/view.do?albumId="+albumId;
        return  path;
    }
    //故事评论
    public static String getAlbumComment(String albumId){
        String path ="http://api.laozihaojia.com/album/commentlist.do?albumId="+albumId;
        return  path;
    }
    ///////////////////////////////////////////////////////////////////////////
    //发现中国好东西
    public static String getSearchHotTagPath(){
        String path ="http://api.laozihaojia.com/search/hot/tag.do";
        return   path;
    }
    //发现中国好东西跳转
    public static String getSearchHotTagGoodPath(String tadId ){
        String path ="http://api.laozihaojia.com/search/hot/tag.do?tagId="+tadId;
        return   path;
    }
    //发现中国好东西--二级跳转--三级跳转
    public static String getSearchHotTag_Path(String commodityId ){
        String path ="http://api.laozihaojia.com/commodity/view.do?commodityId="+commodityId+"&_=1479483572825";
        return   path;
    }

    //发现分类
    public static String getSearchHotPath(){
        String path ="http://api.laozihaojia.com/icon/hot.do";
        return   path;
    }
    //发现分类的跳转
    public static String getSearchHot_Path(String linkType,String linkId,String pageIndex,String linkName){
        String path ="http://api.laozihaojia.com/icon/search.do?linkType="+linkType+"&pageNum=20&pageIndex="+pageIndex+"&linkId="+linkId+"&linkName"+linkName;
        return   path;
    }
    //发现listview
    public static String getSearchListPath(String needType,String  pageIndex){
        String path ="http://api.laozihaojia.com/subject/list.do?needType="+needType+"&pageNum=20&pageIndex="+pageIndex;
        return  path;
    }
    //发现--美物质的跳转
    public static String getSearchList_Path1(String needType,String  pageIndex,String subjectTypeId){
        String path ="http://api.laozihaojia.com/subject/list.do?needType="+needType+"&pageNum=20&pageIndex="+pageIndex+"&subjectType"+subjectTypeId;
        return  path;
    }
    //发现--listview的跳转
    public static String getSearchList_Path2(String subjectId,String  pageIndex){
        String path ="http://api.laozihaojia.com/subject/view.do?subjectId="+subjectId+"&pageIndex=1&pageNum=10&_=1479478781900";
        return  path;
    }

    ///////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////
    // 定制首页
    public static String getCrowdfundingPath(){
        String path ="http://api.laozihaojia.com/crowdfunding/list.do?pageIndex=1&pageNum=2&_=1479478865286";
        return   path;
    }
    //定制跳转
    public static String getCrowdfunding_Path(String crowdfundingId){
        String path ="http://api.laozihaojia.com/crowdfunding/view.do?crowdfundingId="+crowdfundingId+"&_=1479480435107";
        return   path;
    }
    //定制跳转--已经有两人定制:
    public static String getCrowdfunding_Person_Path(String crowdfundingId){
        String path ="http://api.laozihaojia.com/assets/templates/support-num-list.html?crowdfundingId="+crowdfundingId+"&isApp=1";
        return   path;
    }
    //定制跳转--评论
    public static String getCrowdfunding_commentlist_Path(String crowdfundingId){
        String path ="http://api.laozihaojia.com/crowdfunding/commentlist.do?crowdfundingId="+crowdfundingId;
        return   path;
    }
    ///////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////
    // 字号 --解析since时间
    public static String getBrandPath(String crowdfundingId){
        String path ="http://api.laozihaojia.com/brand/list.do";
        return   path;
    }
    //字号跳转
    public static String getBrand_Path(String brandId){
        String path ="http://api.laozihaojia.com/brand/detail.do?brandId="+brandId;
        return   path;
    }
    //字号跳转--品牌故事
    public static String getBrand_Story_Path(String brandId){
        String path ="http://api.laozihaojia.com/brand/story.do?brandId="+brandId;
        return   path;
    }
    //字号跳转--评论
    public static String getBrand_CommentlistPath(String brandId){
        String path ="http://api.laozihaojia.com/brand/commentlist.do?brandId="+brandId;
        return   path;
    }

    ///////////////////////////////////////////////////////////////////////////
}
