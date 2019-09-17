package com.nchu.model;

import org.apache.solr.client.solrj.beans.Field;

import java.io.Serializable;
import java.util.Date;

public class Item implements Serializable {
    @Field("id")
    private Long id;
    @Field("title")
    private String title;
    @Field("sell_point")
    private String sellPoint;
    @Field("price")
    private double price;
    @Field("stock_count")
    private Integer stockCount;
    @Field("num")
    private Integer num;
    @Field("barcode")
    private String barcode;

    private String image;
    @Field("categoryId")
    private Long categoryid;
    @Field("status")
    private String status;
    @Field("create_time")
    private Date createTime;
    @Field("update_time")
    private Date updateTime;
    @Field("item_sn")
    private String itemSn;
    @Field("cost_price")
    private double costPirce;
    @Field("marke_price")
    private double marketPrice;
    @Field("is_default")
    private String isDefault;
    @Field("goods_id")
    private Long goodsId;
    @Field("seler_id")
    private String sellerId;
    @Field("cart_thumbnail")
    private String cartThumbnail;
    @Field("category")
    private String category;
    @Field("brand")
    private String brand;
    @Field("spec")
    private String spec;
    @Field("seller")
    private String seller;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getSellPoint() {
        return sellPoint;
    }

    public void setSellPoint(String sellPoint) {
        this.sellPoint = sellPoint == null ? null : sellPoint.trim();
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Integer getStockCount() {
        return stockCount;
    }

    public void setStockCount(Integer stockCount) {
        this.stockCount = stockCount;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode == null ? null : barcode.trim();
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
    }

    public Long getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(Long categoryid) {
        this.categoryid = categoryid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getItemSn() {
        return itemSn;
    }

    public void setItemSn(String itemSn) {
        this.itemSn = itemSn == null ? null : itemSn.trim();
    }

    public double getCostPirce() {
        return costPirce;
    }

    public void setCostPirce(double costPirce) {
        this.costPirce = costPirce;
    }

    public double getMarketPrice() {
        return marketPrice;
    }

    public void setMarketPrice(double marketPrice) {
        this.marketPrice = marketPrice;
    }

    public String getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(String isDefault) {
        this.isDefault = isDefault == null ? null : isDefault.trim();
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId == null ? null : sellerId.trim();
    }

    public String getCartThumbnail() {
        return cartThumbnail;
    }

    public void setCartThumbnail(String cartThumbnail) {
        this.cartThumbnail = cartThumbnail == null ? null : cartThumbnail.trim();
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category == null ? null : category.trim();
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand == null ? null : brand.trim();
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec == null ? null : spec.trim();
    }

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller == null ? null : seller.trim();
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", sellPoint='" + sellPoint + '\'' +
                ", price=" + price +
                ", stockCount=" + stockCount +
                ", num=" + num +
                ", barcode='" + barcode + '\'' +
                ", image='" + image + '\'' +
                ", categoryid=" + categoryid +
                ", status='" + status + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", itemSn='" + itemSn + '\'' +
                ", costPirce=" + costPirce +
                ", marketPrice=" + marketPrice +
                ", isDefault='" + isDefault + '\'' +
                ", goodsId=" + goodsId +
                ", sellerId='" + sellerId + '\'' +
                ", cartThumbnail='" + cartThumbnail + '\'' +
                ", category='" + category + '\'' +
                ", brand='" + brand + '\'' +
                ", spec='" + spec + '\'' +
                ", seller='" + seller + '\'' +
                '}';
    }
}