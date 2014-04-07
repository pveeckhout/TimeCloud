SELECT distinct        
       transfer0.end_medical_department as "end department" as "end department",
       MIN((strftime('%s',transfer0.transfer_time) - strftime('%s',episode0.intake_time))/60) as "MIN (minutes)",
       MAX((strftime('%s',transfer0.transfer_time) - strftime('%s',episode0.intake_time))/60) as "MAX (minutes)",       
       AVG((strftime('%s',transfer0.transfer_time) - strftime('%s',episode0.intake_time))/60) as "AVG (minutes)"
FROM Episodes episode0
JOIN Transfers transfer0 ON transfer0.episode_id = episode0.episode_id AND transfer0.end_medical_department != transfer0.start_medical_department
GROUP BY transfer0.end_medical_department
ORDER BY transfer0.end_medical_department
;
