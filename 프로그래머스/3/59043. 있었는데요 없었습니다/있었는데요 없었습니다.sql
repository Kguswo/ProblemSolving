SELECT ai.ANIMAL_ID, ai.NAME
    FROM ANIMAL_INS AS ai
        INNER JOIN ANIMAL_OUTS AS ao
            ON ao.ANIMAL_ID = ai.ANIMAL_ID
                WHERE ai.DATETIME > ao.DATETIME
                    ORDER BY ai.DATETIME ASC;