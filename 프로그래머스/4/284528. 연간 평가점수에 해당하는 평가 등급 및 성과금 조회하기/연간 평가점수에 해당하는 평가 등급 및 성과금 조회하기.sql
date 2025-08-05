SELECT hg.EMP_NO, he.EMP_NAME,
    CASE
        WHEN AVG(SCORE) >= 96 THEN 'S'
        WHEN AVG(SCORE) >= 90 THEN 'A'
        WHEN AVG(SCORE) >= 80 THEN 'B'
        ELSE 'C'
    END AS GRADE,
    CASE
        WHEN AVG(SCORE) >= 96 THEN 0.2 * he.SAL
        WHEN AVG(SCORE) >= 90 THEN 0.15 * he.SAL
        WHEN AVG(SCORE) >= 80 THEN 0.1 * he.SAL
        ELSE 0
    END AS BONUS
        FROM HR_GRADE AS hg
            JOIN HR_EMPLOYEES he on hg.EMP_NO = he.EMP_NO
                GROUP BY hg.EMP_NO, he.EMP_NAME, he.SAL;