package com.spring.jdbc.dao;

import com.spring.jdbc.ipaddresslocation.IpAddressLocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Seth on 1/18/2017.
 */
@Configuration
@ComponentScan(basePackages = "com.spring.jdbc.*")
public class IpAddressLocationDao {

    private String ipAddressRecords = "select ip_address\n" +
            ", country_code\n" +
            ", country_name\n" +
            ", region\n" +
            ", region_name\n" +
            ", city\n" +
            ", postal_code\n" +
            ", latitude\n" +
            ", longitude\n" +
            ", dma_code\n" +
            ", area_code\n" +
            ", metro_code\n" +
            "from ip_address_location limit 50;";

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public IpAddressLocationDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<IpAddressLocation> getIpAddressList() {
        return jdbcTemplate.query(ipAddressRecords, new RowMapper<IpAddressLocation>() {
            public IpAddressLocation mapRow(ResultSet rs, int i) throws SQLException {
                IpAddressLocation ipAddressLocation = new IpAddressLocation();
                ipAddressLocation.setIpAddress(rs.getString(1));
                ipAddressLocation.setCountryCode(rs.getString(2));
                ipAddressLocation.setCountryName(rs.getString(3));
                ipAddressLocation.setRegion(rs.getString(4));
                ipAddressLocation.setRegionName(rs.getString(5));
                ipAddressLocation.setCity(rs.getString(6));
                ipAddressLocation.setPostalCode(rs.getString(7));
                ipAddressLocation.setLatitude(rs.getFloat(8));
                ipAddressLocation.setLongitude(rs.getFloat(9));
                ipAddressLocation.setDmaCode(rs.getInt(10));
                ipAddressLocation.setAreaCode(rs.getInt(11));
                ipAddressLocation.setMetroCode(rs.getInt(12));
                return ipAddressLocation;
            }
        });
    }
}
