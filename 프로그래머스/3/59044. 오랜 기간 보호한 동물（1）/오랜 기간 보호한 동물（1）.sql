# SELECT ai.NAME, ai.DATETIME
#     FROM ANIMAL_INS AS ai
#         LEFT JOIN ANIMAL_OUTS AS ao ON ai.ANIMAL_ID = ao.ANIMAL_ID
#             WHERE ao.ANIMAL_ID IS NULL
#                 ORDER BY ai.DATETIME ASC
#                     LIMIT 3;
                    
SELECT i.NAME, i.DATETIME
    FROM ANIMAL_INS AS i
        LEFT JOIN ANIMAL_OUTS AS o
            ON i.ANIMAL_ID = o.ANIMAL_ID
                WHERE o.ANIMAL_ID IS NULL
                    ORDER BY i.DATETIME ASC
                        LIMIT 3;