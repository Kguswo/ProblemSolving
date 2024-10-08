SELECT ai.ANIMAL_ID, ai.NAME
    FROM ANIMAL_INS as ai
        JOIN ANIMAL_OUTS as ao ON ai.ANIMAL_ID = ao.ANIMAL_ID
            ORDER BY (ao.DATETIME - ai.DATETIME) DESC
                LIMIT 2;