UPDATE [Requests]
SET
    [request_id] = ?,
    [patient_id] = ?,
    [episode_id] = ?,
    [intake_kind] = ?,
    [intake_time] = ?,
    [end_department] = ?,
    [end_medical_department] = ?,
    [request_time] = ?,
    [response_time] = ?,
    [transfer_time] = ?,
    [intake_date] = ?,
    [own_department] = ?
WHERE 1 = 1
    AND [request_id] = ?
;
    