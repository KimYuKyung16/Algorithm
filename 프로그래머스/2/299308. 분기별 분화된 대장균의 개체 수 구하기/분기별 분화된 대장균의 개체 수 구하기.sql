# 123 456 789 101112
SELECT 
    CASE
        WHEN  MONTH(DIFFERENTIATION_DATE) IN (1,2,3) THEN "1Q"
        WHEN  MONTH(DIFFERENTIATION_DATE) IN (4,5,6) THEN "2Q"
        WHEN  MONTH(DIFFERENTIATION_DATE) IN (7,8,9) THEN "3Q"
        WHEN  MONTH(DIFFERENTIATION_DATE) IN (10,11,12) THEN "4Q"
    END AS QUARTER,
    COUNT(*) AS ECOLI_COUNT
FROM ECOLI_DATA
GROUP BY QUARTER
ORDER BY QUARTER
