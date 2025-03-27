-- 1. Top 10 operadoras com maiores despesas com SINISTROS no último trimestre

SELECT
    o.razao_social,
    o.cnpj,
    EXTRACT(YEAR FROM d.data) AS ano,
    EXTRACT(QUARTER FROM d.data) AS trimestre,
    SUM(CAST(REPLACE(d.valor_saldo_final, ',', '.') AS NUMERIC)) AS total_despesas
FROM
    demonstracoes_contabeis d
JOIN
    operadoras_ativas o ON d.registro_ans = o.registro_ans::TEXT
WHERE
    d.descricao ILIKE '%SINISTROS%'
    AND (d.data, d.registro_ans) IN (
        SELECT
            MAX(data),
            registro_ans
        FROM demonstracoes_contabeis
        GROUP BY registro_ans
    )
GROUP BY
    o.razao_social, o.cnpj, ano, trimestre
ORDER BY
    total_despesas DESC
LIMIT 10;


-- 2. Top 10 operadoras com maiores despesas com SINISTROS no último ano

SELECT
    o.razao_social,
    o.cnpj,
    SUM(CAST(REPLACE(d.valor_saldo_final, ',', '.') AS NUMERIC)) AS total_despesas
FROM
    demonstracoes_contabeis d
JOIN
    operadoras_ativas o ON d.registro_ans = o.registro_ans::TEXT
WHERE
    d.descricao ILIKE '%SINISTROS%'
    AND EXTRACT(YEAR FROM d.data) = (
        SELECT MAX(EXTRACT(YEAR FROM data)) FROM demonstracoes_contabeis
    )
GROUP BY
    o.razao_social, o.cnpj
ORDER BY
    total_despesas DESC
LIMIT 10;
