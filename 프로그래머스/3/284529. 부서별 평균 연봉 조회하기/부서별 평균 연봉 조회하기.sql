SELECT hd.DEPT_ID, hd.DEPT_NAME_EN, ROUND(AVG(SAL), 0) AS AVG_SAL
    FROM HR_DEPARTMENT AS hd
        JOIN HR_EMPLOYEES AS he
            ON hd.DEPT_ID = he.DEPT_ID
                GROUP BY hd.DEPT_ID, hd.DEPT_NAME_EN
                    ORDER BY AVG_SAL DESC;