WITH RECURSIVE generations AS (
    SELECT ID, 1 AS generation
        FROM ECOLI_DATA
            WHERE PARENT_ID IS NULL
    
    UNION ALL
    
    SELECT e.ID, g.generation + 1
        FROM ECOLI_DATA e
            JOIN generations g ON e.PARENT_ID = g.ID
)

SELECT COUNT(*) AS COUNT, generation AS GENERATION
    FROM generations g
        WHERE g.ID NOT IN(
            SELECT DISTINCT PARENT_ID
            FROM ECOLI_DATA
            WHERE PARENT_ID IS NOT NULL
        )
        GROUP BY generation
            ORDER BY generation ASC;