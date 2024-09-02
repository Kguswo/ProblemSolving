SELECT ed.ID AS ID,
    CASE
        WHEN ed.SIZE_OF_COLONY <= 100 THEN 'LOW'
        WHEN ed.SIZE_OF_COLONY >100 AND SIZE_OF_COLONY <= 1000 THEN 'MEDIUM'
        WHEN ed.SIZE_OF_COLONY > 1000 THEN 'HIGH'
    END AS SIZE
        FROM ECOLI_DATA AS ed
            ORDER BY ID ASC; 