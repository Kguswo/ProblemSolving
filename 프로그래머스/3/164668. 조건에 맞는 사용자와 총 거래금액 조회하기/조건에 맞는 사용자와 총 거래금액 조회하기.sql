SELECT b.WRITER_ID AS USER_ID, u.NICKNAME, SUM(b.PRICE) AS TOTAL_SALES
    FROM USED_GOODS_BOARD AS b
        JOIN USED_GOODS_USER AS u
            ON b.WRITER_ID = u.USER_ID
                WHERE b.STATUS = 'DONE'
                    GROUP BY b.WRITER_ID # groupby에서는 명시적으로 써주는게 좋다 USER_ID에서바꿈
                        HAVING TOTAL_SALES >= 700000
                            ORDER BY TOTAL_SALES;