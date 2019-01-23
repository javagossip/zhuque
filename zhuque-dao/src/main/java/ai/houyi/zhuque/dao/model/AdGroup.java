package ai.houyi.zhuque.dao.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class AdGroup {
    private Integer id;

    private String name;

    private Integer campaignId;

    private String scheduling;

    private Integer deliverMethod;

    private Date beginTime;

    private Date endTime;

    private Integer deliverTimes;

    private Integer budget;

    private Integer promotionType;

    private String landingPage;

    private Integer costType;

    private String appId;

    private String pkgName;

    private Integer bidStrategy;

    private Boolean freqCappingEnabled;

    private String frequency;

    private Integer freqCappingType;

    private Integer status;

    private String targetArea;

    private String targetLbs;

    private Integer targetOs;

    private String targetBehavior;

    private String targetMedia;

    private Integer targetTerminal;

    private Integer targetDeviceType;

    private Integer targetModel;

    private Integer targetCarrier;

    private Integer targetConnectionType;

    private String targetDevice;

    private Integer targetInterests;

    private Integer targetAudience;

    private String targetExt;

    private String dealId;

    private String impTrackers;

    private String clkTrackers;

    private Integer bidPrice;

    private Date createTime;

    private Date updateTime;

    private Integer adPositionId;

    private Boolean deleted;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCampaignId() {
        return campaignId;
    }

    public void setCampaignId(Integer campaignId) {
        this.campaignId = campaignId;
    }

    public String getScheduling() {
        return scheduling;
    }

    public void setScheduling(String scheduling) {
        this.scheduling = scheduling;
    }

    public Integer getDeliverMethod() {
        return deliverMethod;
    }

    public void setDeliverMethod(Integer deliverMethod) {
        this.deliverMethod = deliverMethod;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getDeliverTimes() {
        return deliverTimes;
    }

    public void setDeliverTimes(Integer deliverTimes) {
        this.deliverTimes = deliverTimes;
    }

    public Integer getBudget() {
        return budget;
    }

    public void setBudget(Integer budget) {
        this.budget = budget;
    }

    public Integer getPromotionType() {
        return promotionType;
    }

    public void setPromotionType(Integer promotionType) {
        this.promotionType = promotionType;
    }

    public String getLandingPage() {
        return landingPage;
    }

    public void setLandingPage(String landingPage) {
        this.landingPage = landingPage;
    }

    public Integer getCostType() {
        return costType;
    }

    public void setCostType(Integer costType) {
        this.costType = costType;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getPkgName() {
        return pkgName;
    }

    public void setPkgName(String pkgName) {
        this.pkgName = pkgName;
    }

    public Integer getBidStrategy() {
        return bidStrategy;
    }

    public void setBidStrategy(Integer bidStrategy) {
        this.bidStrategy = bidStrategy;
    }

    public Boolean getFreqCappingEnabled() {
        return freqCappingEnabled;
    }

    public void setFreqCappingEnabled(Boolean freqCappingEnabled) {
        this.freqCappingEnabled = freqCappingEnabled;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public Integer getFreqCappingType() {
        return freqCappingType;
    }

    public void setFreqCappingType(Integer freqCappingType) {
        this.freqCappingType = freqCappingType;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getTargetArea() {
        return targetArea;
    }

    public void setTargetArea(String targetArea) {
        this.targetArea = targetArea;
    }

    public String getTargetLbs() {
        return targetLbs;
    }

    public void setTargetLbs(String targetLbs) {
        this.targetLbs = targetLbs;
    }

    public Integer getTargetOs() {
        return targetOs;
    }

    public void setTargetOs(Integer targetOs) {
        this.targetOs = targetOs;
    }

    public String getTargetBehavior() {
        return targetBehavior;
    }

    public void setTargetBehavior(String targetBehavior) {
        this.targetBehavior = targetBehavior;
    }

    public String getTargetMedia() {
        return targetMedia;
    }

    public void setTargetMedia(String targetMedia) {
        this.targetMedia = targetMedia;
    }

    public Integer getTargetTerminal() {
        return targetTerminal;
    }

    public void setTargetTerminal(Integer targetTerminal) {
        this.targetTerminal = targetTerminal;
    }

    public Integer getTargetDeviceType() {
        return targetDeviceType;
    }

    public void setTargetDeviceType(Integer targetDeviceType) {
        this.targetDeviceType = targetDeviceType;
    }

    public Integer getTargetModel() {
        return targetModel;
    }

    public void setTargetModel(Integer targetModel) {
        this.targetModel = targetModel;
    }

    public Integer getTargetCarrier() {
        return targetCarrier;
    }

    public void setTargetCarrier(Integer targetCarrier) {
        this.targetCarrier = targetCarrier;
    }

    public Integer getTargetConnectionType() {
        return targetConnectionType;
    }

    public void setTargetConnectionType(Integer targetConnectionType) {
        this.targetConnectionType = targetConnectionType;
    }

    public String getTargetDevice() {
        return targetDevice;
    }

    public void setTargetDevice(String targetDevice) {
        this.targetDevice = targetDevice;
    }

    public Integer getTargetInterests() {
        return targetInterests;
    }

    public void setTargetInterests(Integer targetInterests) {
        this.targetInterests = targetInterests;
    }

    public Integer getTargetAudience() {
        return targetAudience;
    }

    public void setTargetAudience(Integer targetAudience) {
        this.targetAudience = targetAudience;
    }

    public String getTargetExt() {
        return targetExt;
    }

    public void setTargetExt(String targetExt) {
        this.targetExt = targetExt;
    }

    public String getDealId() {
        return dealId;
    }

    public void setDealId(String dealId) {
        this.dealId = dealId;
    }

    public String getImpTrackers() {
        return impTrackers;
    }

    public void setImpTrackers(String impTrackers) {
        this.impTrackers = impTrackers;
    }

    public String getClkTrackers() {
        return clkTrackers;
    }

    public void setClkTrackers(String clkTrackers) {
        this.clkTrackers = clkTrackers;
    }

    public Integer getBidPrice() {
        return bidPrice;
    }

    public void setBidPrice(Integer bidPrice) {
        this.bidPrice = bidPrice;
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

    public Integer getAdPositionId() {
        return adPositionId;
    }

    public void setAdPositionId(Integer adPositionId) {
        this.adPositionId = adPositionId;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ad_group
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    public static AdGroup.Builder builder() {
        return new AdGroup.Builder();
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table ad_group
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    public static class Builder {
        /**
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database table ad_group
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        private AdGroup obj;

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table ad_group
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder() {
            this.obj = new AdGroup();
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column ad_group.id
         *
         * @param id the value for ad_group.id
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder id(Integer id) {
            obj.setId(id);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column ad_group.name
         *
         * @param name the value for ad_group.name
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder name(String name) {
            obj.setName(name);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column ad_group.campaign_id
         *
         * @param campaignId the value for ad_group.campaign_id
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder campaignId(Integer campaignId) {
            obj.setCampaignId(campaignId);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column ad_group.scheduling
         *
         * @param scheduling the value for ad_group.scheduling
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder scheduling(String scheduling) {
            obj.setScheduling(scheduling);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column ad_group.deliver_method
         *
         * @param deliverMethod the value for ad_group.deliver_method
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder deliverMethod(Integer deliverMethod) {
            obj.setDeliverMethod(deliverMethod);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column ad_group.begin_time
         *
         * @param beginTime the value for ad_group.begin_time
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder beginTime(Date beginTime) {
            obj.setBeginTime(beginTime);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column ad_group.end_time
         *
         * @param endTime the value for ad_group.end_time
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder endTime(Date endTime) {
            obj.setEndTime(endTime);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column ad_group.deliver_times
         *
         * @param deliverTimes the value for ad_group.deliver_times
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder deliverTimes(Integer deliverTimes) {
            obj.setDeliverTimes(deliverTimes);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column ad_group.budget
         *
         * @param budget the value for ad_group.budget
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder budget(Integer budget) {
            obj.setBudget(budget);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column ad_group.promotion_type
         *
         * @param promotionType the value for ad_group.promotion_type
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder promotionType(Integer promotionType) {
            obj.setPromotionType(promotionType);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column ad_group.landing_page
         *
         * @param landingPage the value for ad_group.landing_page
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder landingPage(String landingPage) {
            obj.setLandingPage(landingPage);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column ad_group.cost_type
         *
         * @param costType the value for ad_group.cost_type
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder costType(Integer costType) {
            obj.setCostType(costType);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column ad_group.app_id
         *
         * @param appId the value for ad_group.app_id
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder appId(String appId) {
            obj.setAppId(appId);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column ad_group.pkg_name
         *
         * @param pkgName the value for ad_group.pkg_name
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder pkgName(String pkgName) {
            obj.setPkgName(pkgName);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column ad_group.bid_strategy
         *
         * @param bidStrategy the value for ad_group.bid_strategy
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder bidStrategy(Integer bidStrategy) {
            obj.setBidStrategy(bidStrategy);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column ad_group.freq_capping_enabled
         *
         * @param freqCappingEnabled the value for ad_group.freq_capping_enabled
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder freqCappingEnabled(Boolean freqCappingEnabled) {
            obj.setFreqCappingEnabled(freqCappingEnabled);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column ad_group.frequency
         *
         * @param frequency the value for ad_group.frequency
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder frequency(String frequency) {
            obj.setFrequency(frequency);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column ad_group.freq_capping_type
         *
         * @param freqCappingType the value for ad_group.freq_capping_type
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder freqCappingType(Integer freqCappingType) {
            obj.setFreqCappingType(freqCappingType);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column ad_group.status
         *
         * @param status the value for ad_group.status
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder status(Integer status) {
            obj.setStatus(status);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column ad_group.target_area
         *
         * @param targetArea the value for ad_group.target_area
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder targetArea(String targetArea) {
            obj.setTargetArea(targetArea);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column ad_group.target_lbs
         *
         * @param targetLbs the value for ad_group.target_lbs
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder targetLbs(String targetLbs) {
            obj.setTargetLbs(targetLbs);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column ad_group.target_os
         *
         * @param targetOs the value for ad_group.target_os
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder targetOs(Integer targetOs) {
            obj.setTargetOs(targetOs);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column ad_group.target_behavior
         *
         * @param targetBehavior the value for ad_group.target_behavior
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder targetBehavior(String targetBehavior) {
            obj.setTargetBehavior(targetBehavior);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column ad_group.target_media
         *
         * @param targetMedia the value for ad_group.target_media
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder targetMedia(String targetMedia) {
            obj.setTargetMedia(targetMedia);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column ad_group.target_terminal
         *
         * @param targetTerminal the value for ad_group.target_terminal
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder targetTerminal(Integer targetTerminal) {
            obj.setTargetTerminal(targetTerminal);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column ad_group.target_device
         *
         * @param targetDevice the value for ad_group.target_device
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder targetDevice(String targetDevice) {
            obj.setTargetDevice(targetDevice);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column ad_group.target_device_type
         *
         * @param targetDeviceType the value for ad_group.target_device_type
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder targetDeviceType(Integer targetDeviceType) {
            obj.setTargetDeviceType(targetDeviceType);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column ad_group.target_model
         *
         * @param targetModel the value for ad_group.target_model
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder targetModel(Integer targetModel) {
            obj.setTargetModel(targetModel);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column ad_group.target_carrier
         *
         * @param targetCarrier the value for ad_group.target_carrier
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder targetCarrier(Integer targetCarrier) {
            obj.setTargetCarrier(targetCarrier);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column ad_group.target_connection_type
         *
         * @param targetConnectionType the value for ad_group.target_connection_type
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder targetConnectionType(Integer targetConnectionType) {
            obj.setTargetConnectionType(targetConnectionType);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column ad_group.target_interests
         *
         * @param targetInterests the value for ad_group.target_interests
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder targetInterests(Integer targetInterests) {
            obj.setTargetInterests(targetInterests);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column ad_group.target_audience
         *
         * @param targetAudience the value for ad_group.target_audience
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder targetAudience(Integer targetAudience) {
            obj.setTargetAudience(targetAudience);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column ad_group.target_ext
         *
         * @param targetExt the value for ad_group.target_ext
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder targetExt(String targetExt) {
            obj.setTargetExt(targetExt);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column ad_group.deal_id
         *
         * @param dealId the value for ad_group.deal_id
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder dealId(String dealId) {
            obj.setDealId(dealId);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column ad_group.imp_trackers
         *
         * @param impTrackers the value for ad_group.imp_trackers
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder impTrackers(String impTrackers) {
            obj.setImpTrackers(impTrackers);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column ad_group.clk_trackers
         *
         * @param clkTrackers the value for ad_group.clk_trackers
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder clkTrackers(String clkTrackers) {
            obj.setClkTrackers(clkTrackers);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column ad_group.bid_price
         *
         * @param bidPrice the value for ad_group.bid_price
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder bidPrice(Integer bidPrice) {
            obj.setBidPrice(bidPrice);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column ad_group.create_time
         *
         * @param createTime the value for ad_group.create_time
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder createTime(Date createTime) {
            obj.setCreateTime(createTime);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column ad_group.update_time
         *
         * @param updateTime the value for ad_group.update_time
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder updateTime(Date updateTime) {
            obj.setUpdateTime(updateTime);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column ad_group.ad_position_id
         *
         * @param adPositionId the value for ad_group.ad_position_id
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder adPositionId(Integer adPositionId) {
            obj.setAdPositionId(adPositionId);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column ad_group.deleted
         *
         * @param deleted the value for ad_group.deleted
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Builder deleted(Boolean deleted) {
            obj.setDeleted(deleted);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table ad_group
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public AdGroup build() {
            return this.obj;
        }
    }

    /**
     * This enum was generated by MyBatis Generator.
     * This enum corresponds to the database table ad_group
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    public enum Column {
        id("id", "id", "INTEGER", false),
        name("name", "name", "VARCHAR", false),
        campaignId("campaign_id", "campaignId", "INTEGER", false),
        scheduling("scheduling", "scheduling", "VARCHAR", false),
        deliverMethod("deliver_method", "deliverMethod", "INTEGER", false),
        beginTime("begin_time", "beginTime", "TIMESTAMP", false),
        endTime("end_time", "endTime", "TIMESTAMP", false),
        deliverTimes("deliver_times", "deliverTimes", "INTEGER", false),
        budget("budget", "budget", "INTEGER", false),
        promotionType("promotion_type", "promotionType", "INTEGER", false),
        landingPage("landing_page", "landingPage", "VARCHAR", false),
        costType("cost_type", "costType", "INTEGER", false),
        appId("app_id", "appId", "VARCHAR", false),
        pkgName("pkg_name", "pkgName", "VARCHAR", false),
        bidStrategy("bid_strategy", "bidStrategy", "INTEGER", false),
        freqCappingEnabled("freq_capping_enabled", "freqCappingEnabled", "BIT", false),
        frequency("frequency", "frequency", "VARCHAR", false),
        freqCappingType("freq_capping_type", "freqCappingType", "INTEGER", false),
        status("status", "status", "INTEGER", false),
        targetArea("target_area", "targetArea", "VARCHAR", false),
        targetLbs("target_lbs", "targetLbs", "VARCHAR", false),
        targetOs("target_os", "targetOs", "INTEGER", false),
        targetBehavior("target_behavior", "targetBehavior", "VARCHAR", false),
        targetMedia("target_media", "targetMedia", "VARCHAR", false),
        targetTerminal("target_terminal", "targetTerminal", "INTEGER", false),
        targetDeviceType("target_device_type", "targetDeviceType", "INTEGER", false),
        targetModel("target_model", "targetModel", "INTEGER", false),
        targetCarrier("target_carrier", "targetCarrier", "INTEGER", false),
        targetConnectionType("target_connection_type", "targetConnectionType", "INTEGER", false),
        targetDevice("target_device", "targetDevice", "VARCHAR", false),
        targetInterests("target_interests", "targetInterests", "INTEGER", false),
        targetAudience("target_audience", "targetAudience", "INTEGER", false),
        targetExt("target_ext", "targetExt", "VARCHAR", false),
        dealId("deal_id", "dealId", "VARCHAR", false),
        impTrackers("imp_trackers", "impTrackers", "VARCHAR", false),
        clkTrackers("clk_trackers", "clkTrackers", "VARCHAR", false),
        bidPrice("bid_price", "bidPrice", "INTEGER", false),
        createTime("create_time", "createTime", "TIMESTAMP", false),
        updateTime("update_time", "updateTime", "TIMESTAMP", false),
        adPositionId("ad_position_id", "adPositionId", "INTEGER", false),
        deleted("deleted", "deleted", "BIT", false);

        /**
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database table ad_group
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        private static final String BEGINNING_DELIMITER = "\"";

        /**
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database table ad_group
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        private static final String ENDING_DELIMITER = "\"";

        /**
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database table ad_group
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        private final String column;

        /**
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database table ad_group
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        private final boolean isColumnNameDelimited;

        /**
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database table ad_group
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        private final String javaProperty;

        /**
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database table ad_group
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        private final String jdbcType;

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table ad_group
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public String value() {
            return this.column;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table ad_group
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public String getValue() {
            return this.column;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table ad_group
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public String getJavaProperty() {
            return this.javaProperty;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table ad_group
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public String getJdbcType() {
            return this.jdbcType;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table ad_group
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        Column(String column, String javaProperty, String jdbcType, boolean isColumnNameDelimited) {
            this.column = column;
            this.javaProperty = javaProperty;
            this.jdbcType = jdbcType;
            this.isColumnNameDelimited = isColumnNameDelimited;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table ad_group
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public String desc() {
            return this.getEscapedColumnName() + " DESC";
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table ad_group
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public String asc() {
            return this.getEscapedColumnName() + " ASC";
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table ad_group
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public static Column[] excludes(Column ... excludes) {
            ArrayList<Column> columns = new ArrayList<>(Arrays.asList(Column.values()));
            if (excludes != null && excludes.length > 0) {
                columns.removeAll(new ArrayList<>(Arrays.asList(excludes)));
            }
            return columns.toArray(new Column[]{});
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table ad_group
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public String getEscapedColumnName() {
            if (this.isColumnNameDelimited) {
                return new StringBuilder().append(BEGINNING_DELIMITER).append(this.column).append(ENDING_DELIMITER).toString();
            } else {
                return this.column;
            }
        }
    }
}