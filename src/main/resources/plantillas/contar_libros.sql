SELECT count(*) FROM `codLibro` INNER JOIN `libro` ON `codlibro`.`idlibro` = `libro`.`idlibro`
WHERE `libro`.`idlibro` = '{ID_LIBRO}' AND `libro`.`Prestable` = 1;