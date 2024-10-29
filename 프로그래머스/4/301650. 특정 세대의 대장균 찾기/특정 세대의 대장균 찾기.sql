SELECT e3.ID
    FROM ECOLI_DATA AS e1
        JOIN ECOLI_DATA AS e2
            ON e2.PARENT_ID = e1.ID
                JOIN ECOLI_DATA AS e3
                    ON e3.PARENT_ID = e2.ID
                        WHERE e1.PARENT_ID IS NULL
                            ORDER BY e3.ID ASC;