package com.centit.dde.po;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

/**
 * create by scaffold
 *
 * @author codefan@hotmail.com
 */
@Entity
@Table(name="D_EXCHANGE_MAPINFO")
public class ExchangeMapinfo implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="MAPINFO_ID")
    @GeneratedValue(generator = "assignedGenerator")
    @GenericGenerator(name = "assignedGenerator", strategy = "assigned")
    private Long mapinfoId;
    
    @Column(name="DEST_DATABASE_NAME")
    private String destDatabaseName;
    
    @Column(name="MAPINFO_NAME")
    private String mapinfoName;
    
    @Column(name="QUERY_SQL")
    private String querySql;
    
    @Column(name="SOURCE_DATABASE_NAME")
    private String sourceDatabaseName;

    @Column(name="SOURCE_TABLENAME")
    private String sourceTablename;

    @Column(name="DEST_TABLENAME")
    private String destTablename;

    @Column(name="IS_REPEAT")
    private String isRepeat;

    @Column(name="MAPINFO_DESC")
    private String mapinfoDesc;

    @Column(name="RECORD_OPERATE")
    private String recordOperate;

    @Transient
    private Long mapinfoOrder;

    @OneToMany(orphanRemoval=true,fetch=FetchType.LAZY)
    @JoinColumn(name="MAPINFO_ID") //这里表示数据库的外键 在t_street里面创建
    private List<MapinfoDetail> mapinfoDetails = null;

    @OneToMany(orphanRemoval=true,fetch=FetchType.LAZY)
    @JoinColumn(name="MAPINFO_ID") //这里表示数据库的外键 在t_street里面创建
    private List<MapinfoTrigger> mapinfoTriggers = null;

    @OneToMany(orphanRemoval=true,fetch=FetchType.LAZY)
    @JoinColumn(name="MAPINFO_ID") //这里表示数据库的外键 在t_street里面创建
    private List<ExchangeTaskdetail> exchangeTaskdetails = null;

    public List<ExchangeTaskdetail> getExchangeTaskdetails() {
        if (null == exchangeTaskdetails) {
            exchangeTaskdetails = new ArrayList<ExchangeTaskdetail>();
        }
        return exchangeTaskdetails;
    }

    public void setExchangeTaskdetails(List<ExchangeTaskdetail> exchangeTaskdetails) {
        this.exchangeTaskdetails = exchangeTaskdetails;
    }

    public String getRecordOperate() {
        return recordOperate;
    }

    public void setRecordOperate(String recordOperate) {
        this.recordOperate = recordOperate;
    }

    public Long getMapinfoOrder() {
        return mapinfoOrder;
    }

    public void setMapinfoOrder(Long mapinfoOrder) {
        this.mapinfoOrder = mapinfoOrder;
    }

    public String getSourceTablename() {
        return sourceTablename;
    }

    public void setSourceTablename(String sourceTablename) {
        this.sourceTablename = sourceTablename;
    }

    public List<MapinfoDetail> getMapinfoDetails() {
        if (null == mapinfoDetails) {
            mapinfoDetails = new ArrayList<MapinfoDetail>();
        }
        return mapinfoDetails;
    }

    public void setMapinfoDetails(List<MapinfoDetail> mapinfoDetails) {
        this.mapinfoDetails = mapinfoDetails;
    }

    public List<MapinfoTrigger> getMapinfoTriggers() {
        if (null == mapinfoTriggers) {
            mapinfoTriggers = new ArrayList<MapinfoTrigger>();
        }
        return mapinfoTriggers;
    }

    public void setMapinfoTriggers(List<MapinfoTrigger> mapinfoTriggers) {
        this.mapinfoTriggers = mapinfoTriggers;
    }

    // Constructors

    /**
     * default constructor
     */
    public ExchangeMapinfo() {
    }

    /**
     * minimal constructor
     */
    public ExchangeMapinfo(Long mapinfoId, String mapinfoName) {

        this.mapinfoId = mapinfoId;

        this.mapinfoName = mapinfoName;
    }

    /**
     * full constructor
     */
    public ExchangeMapinfo(Long mapinfoId, String destDatabaseName, String mapinfoName, String querySql,
                           String sourceDatabaseName, String destTablename, String isRepeat, String mapinfoDesc) {

        this.mapinfoId = mapinfoId;

        this.destDatabaseName = destDatabaseName;
        this.mapinfoName = mapinfoName;
        this.querySql = querySql;
        this.sourceDatabaseName = sourceDatabaseName;
        this.destTablename = destTablename;
        this.isRepeat = isRepeat;
        this.mapinfoDesc = mapinfoDesc;
    }

    public Long getMapinfoId() {
        return this.mapinfoId;
    }

    public void setMapinfoId(Long mapinfoId) {
        this.mapinfoId = mapinfoId;
    }

    // Property accessors

    public String getDestDatabaseName() {
        return this.destDatabaseName;
    }

    public void setDestDatabaseName(String destDatabaseName) {
        this.destDatabaseName = destDatabaseName;
    }

    public String getMapinfoName() {
        return this.mapinfoName;
    }

    public void setMapinfoName(String mapinfoName) {
        this.mapinfoName = mapinfoName;
    }

    public String getQuerySql() {
        return this.querySql;
    }

    public void setQuerySql(String querySql) {
        this.querySql = querySql;
    }

    public String getSourceDatabaseName() {
        return this.sourceDatabaseName;
    }

    public void setSourceDatabaseName(String sourceDatabaseName) {
        this.sourceDatabaseName = sourceDatabaseName;
    }

    public String getDestTablename() {
        return this.destTablename;
    }

    public void setDestTablename(String destTablename) {
        this.destTablename = destTablename;
    }

    public String getIsRepeat() {
        return this.isRepeat;
    }

    public void setIsRepeat(String isRepeat) {
        this.isRepeat = isRepeat;
    }

    public String getMapinfoDesc() {
        return this.mapinfoDesc;
    }

    public void setMapinfoDesc(String mapinfoDesc) {
        this.mapinfoDesc = mapinfoDesc;
    }

    public void copy(ExchangeMapinfo other) {

        this.setMapinfoId(other.getMapinfoId());

        this.destDatabaseName = other.getDestDatabaseName();
        this.mapinfoName = other.getMapinfoName();
        this.querySql = other.getQuerySql();
        this.sourceDatabaseName = other.getSourceDatabaseName();
        this.destTablename = other.getDestTablename();
        this.isRepeat = other.getIsRepeat();
        this.mapinfoDesc = other.getMapinfoDesc();

    }

    public void copyNotNullProperty(ExchangeMapinfo other) {

        if (other.getMapinfoId() != null)
            this.setMapinfoId(other.getMapinfoId());

        if (other.getDestDatabaseName() != null)
            this.destDatabaseName = other.getDestDatabaseName();
        if (other.getMapinfoName() != null)
            this.mapinfoName = other.getMapinfoName();
        if (other.getQuerySql() != null)
            this.querySql = other.getQuerySql();
        if (other.getSourceDatabaseName() != null)
            this.sourceDatabaseName = other.getSourceDatabaseName();
        if (other.getDestTablename() != null)
            this.destTablename = other.getDestTablename();
        if (other.getIsRepeat() != null)
            this.isRepeat = other.getIsRepeat();
        if (other.getMapinfoDesc() != null)
            this.mapinfoDesc = other.getMapinfoDesc();
        if (null != other.getRecordOperate()) {
            this.recordOperate = other.getRecordOperate();
        }

    }

    public void clearProperties() {

        this.destDatabaseName = null;
        this.mapinfoName = null;
        this.querySql = null;
        this.sourceDatabaseName = null;
        this.destTablename = null;
        this.isRepeat = null;
        this.mapinfoDesc = null;

    }

    public void addMapinfoDetail(MapinfoDetail mapinfoDetail) {
        if (null == mapinfoDetails) {
            mapinfoDetails = new ArrayList<MapinfoDetail>();
        }

        mapinfoDetails.add(mapinfoDetail);
    }

    public void addMapinfoTrigger(MapinfoTrigger mapinfoTrigger) {
        if (null == mapinfoTriggers) {
            mapinfoTriggers = new ArrayList<MapinfoTrigger>();
        }

        mapinfoTriggers.add(mapinfoTrigger);
    }
}
