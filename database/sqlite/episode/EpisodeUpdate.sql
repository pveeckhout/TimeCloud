UPDATE [Episodes]
SET
    [episode_id] = ?,
    [patient_id] = ?,
    [intake_time] = ?,
    [meg] = ?,
    [triage_time] = ?,
    [triage_level] = ?
WHERE 1 = 1
    AND [episode_id] = ?
;
    