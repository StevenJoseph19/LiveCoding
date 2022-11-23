SELECT * FROM performance;

SELECT  mkt_carrier AS airline, 
        mkt_carrier_fl_num AS flight,
        origin AS depart_city
    FROM performance;
    
SELECT DISTINCT mkt_carrier
    FROM performance;
    
SELECT DISTINCT mkt_carrier,
        origin AS depart_city
    FROM performance;