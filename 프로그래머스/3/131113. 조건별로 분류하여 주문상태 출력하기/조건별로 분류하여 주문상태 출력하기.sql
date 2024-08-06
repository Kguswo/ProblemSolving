SELECT fo.ORDER_ID, fo.PRODUCT_ID, DATE_FORMAT(fo.OUT_DATE,"%Y-%m-%d"),
    CASE WHEN fo.OUT_DATE <= '2022-05-01' THEN "출고완료"
         WHEN fo.OUT_DATE IS NULL THEN "출고미정"
         ELSE "출고대기"
    END AS 출고여부
        FROM FOOD_ORDER fo
            ORDER BY fo.ORDER_ID;