SELECT DISTINCT CAR_ID,
    CASE 
        WHEN EXISTS (
            SELECT *
                FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY c2
                    WHERE c2.CAR_ID = c1.CAR_ID
            AND c2.START_DATE <= '2022-10-16' AND '2022-10-16' <= c2.END_DATE
        ) THEN '대여중'
        ELSE '대여 가능'
    END AS AVAILABILITY
        FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY c1
            ORDER BY CAR_ID DESC;