SELECT DISTINCT crcc.CAR_ID
    FROM CAR_RENTAL_COMPANY_CAR AS crcc
        JOIN CAR_RENTAL_COMPANY_RENTAL_HISTORY AS crcrh
            ON crcc.CAR_ID = crcrh.CAR_ID
                WHERE crcc.CAR_TYPE = '세단' 
                AND MONTH(crcrh.START_DATE) = 10
                    ORDER BY crcc.CAR_ID DESC;