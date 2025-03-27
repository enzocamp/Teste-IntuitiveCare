-- Importar operadoras ativas
\copy operadoras_ativas FROM '../../Teste-IntuitiveCare-Seletivo/teste_3_banco_dados/dados/operadoras_ativas.csv' DELIMITER ';' CSV HEADER ENCODING 'UTF8';

-- Importar demonstrativos 2023
\copy demonstracoes_contabeis FROM '../../Teste-IntuitiveCare-Seletivo/teste_3_banco_dados/dados/demonstracoes_2023/1T2023.csv' DELIMITER ';' CSV HEADER ENCODING 'UTF8';
\copy demonstracoes_contabeis FROM '../../Teste-IntuitiveCare-Seletivo/teste_3_banco_dados/dados/demonstracoes_2023/2T2023.csv' DELIMITER ';' CSV HEADER ENCODING 'UTF8';
\copy demonstracoes_contabeis FROM '../..//Teste-IntuitiveCare-Seletivo/teste_3_banco_dados/dados/demonstracoes_2023/3T2023.csv' DELIMITER ';' CSV HEADER ENCODING 'UTF8';
\copy demonstracoes_contabeis FROM '../../Teste-IntuitiveCare-Seletivo/teste_3_banco_dados/dados/demonstracoes_2023/4T2023.csv' DELIMITER ';' CSV HEADER ENCODING 'UTF8';

-- Importar demonstrativos 2024
\copy demonstracoes_contabeis FROM '../../Teste-IntuitiveCare-Seletivo/teste_3_banco_dados/dados/demonstracoes_2024/1T2024.csv' DELIMITER ';' CSV HEADER ENCODING 'UTF8';
\copy demonstracoes_contabeis FROM '../../Teste-IntuitiveCare-Seletivo/teste_3_banco_dados/dados/demonstracoes_2024/2T2024.csv' DELIMITER ';' CSV HEADER ENCODING 'UTF8';
\copy demonstracoes_contabeis FROM '../../Teste-IntuitiveCare-Seletivo/teste_3_banco_dados/dados/demonstracoes_2024/3T2024.csv' DELIMITER ';' CSV HEADER ENCODING 'UTF8';
\copy demonstracoes_contabeis FROM '../../Teste-IntuitiveCare-Seletivo/teste_3_banco_dados/dados/demonstracoes_2024/4T2024.csv' DELIMITER ';' CSV HEADER ENCODING 'UTF8';
