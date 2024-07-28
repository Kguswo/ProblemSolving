SELECT b.CATEGORY AS CATEGORY, SUM(bs.SALES) AS TOTAL_SALES
    FROM BOOK b
        JOIN BOOK_SALES bs
            ON b.BOOK_ID = bs.BOOK_ID
                WHERE MONTH(bs.SALES_DATE) = 1 AND YEAR(bs.SALES_DATE) = 2022
                    GROUP BY b.CATEGORY
                        ORDER BY b.CATEGORY ASC;