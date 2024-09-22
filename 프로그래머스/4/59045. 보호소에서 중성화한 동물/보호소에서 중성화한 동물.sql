SELECT ao.ANIMAL_ID, ao.ANIMAL_TYPE, ao.NAME
    FROM ANIMAL_OUTS AS ao
        JOIN ANIMAL_INS AS ai
            ON ai.ANIMAL_ID = ao.ANIMAL_ID
                WHERE ai.SEX_UPON_INTAKE LIKE 'Intact%'
                    AND (ao.SEX_UPON_OUTCOME LIKE 'Spayed%' OR ao.SEX_UPON_OUTCOME LIKE 'Neutered%')
                        ORDER BY ao.ANIMAL_ID ASC;
    