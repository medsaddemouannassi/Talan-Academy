\i C:/fiche_personne.sql
INSERT INTO ft_table(login, date_de_creation)
SELECT nom, date_de_naissance
FROM fiche_personne
WHERE nom LIKE '%a%' AND nom LIKE '________' ORDER BY id LIMIT 10;
UPDATE ft_table SET groupe = 'other' WHERE groupe is NULL;